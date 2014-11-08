package main;

import java.util.Calendar;
import java.util.List;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Reservation {

    private QueryResult res;
    private Person customer;
    private Calendar startingDate;
    private Calendar endDate;

    public Reservation() {
        Calendar cal = Calendar.getInstance(), cal1 = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1990);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 14);
        this.startingDate = cal;
        cal1.set(Calendar.YEAR, 1990);
        cal1.set(Calendar.MONTH, 1);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        cal1.set(Calendar.HOUR_OF_DAY, 10);
        this.endDate = cal1;
        this.res = null;
        this.customer = null;
    }

    public Reservation(Calendar startingDate, Calendar endDate, QueryResult result, Person person) {
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.res = result;
        this.customer = person;
    }

    public List<Room> getRoomList() {
        return res.rooms();
    }

    /* public void setRoomList(Room[] roomList) {
     this.roomList = roomList;
     }*/
    public String getCustomerName() {
        return customer.getName();
    }

    public void setCustomerName(String customerFirstName, String customerLastName) {
        this.customer.setName(customerFirstName, customerLastName);
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }

    public void setCustomerEmail(String customerEmail) {
        this.customer.setEmail(customerEmail);
    }

    public String getCustomerAddress() {
        return customer.getAddress();
    }

    public void setCustomerAddress(String customerAddress) {
        this.customer.setAddress(customerAddress);
    }

    public boolean isAssignedTo(Person per) {
        return customer.equals(per);
    }

    public Calendar getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Calendar startingDate) {
        this.startingDate = startingDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Reservation.class) {
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        } else {
            Reservation temp = (Reservation) obj;
            if (temp.customer != customer) {
                return false;
            }
            if (temp.startingDate.get(Calendar.YEAR) != startingDate.get(Calendar.YEAR)) {
                return false;
            }
            if (temp.startingDate.get(Calendar.MONTH) != startingDate.get(Calendar.MONTH)) {
                return false;
            }
            if (temp.startingDate.get(Calendar.DAY_OF_MONTH) != startingDate.get(Calendar.DAY_OF_MONTH)) {
                return false;
            }
            if (temp.endDate.get(Calendar.YEAR) != endDate.get(Calendar.YEAR)) {
                return false;
            }
            if (temp.endDate.get(Calendar.MONTH) != endDate.get(Calendar.MONTH)) {
                return false;
            }
            if (temp.endDate.get(Calendar.DAY_OF_MONTH) != endDate.get(Calendar.DAY_OF_MONTH)) {
                return false;
            }
            if (temp.res != res) {
                return false;
            }
            return true;
        }
    }
}
