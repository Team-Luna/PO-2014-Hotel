package main;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Reservation {
    private Room[] roomList;
    private String customerFirstName;
    private String customerSurName;
    private String customerEmail;
    private String customerAddress;
    private Date startingDate;
    private Date endDate;

    public Reservation() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1990);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 14);
        this.startingDate = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY, 10);
        this.endDate = cal.getTime();
        this.roomList = null;
        this.customerFirstName = "";
        this.customerSurName = "";
        this.customerEmail = "";
        this.customerAddress = "";
    }

    public Reservation(String customerFirstName, String customerSurName, String customerEmail, String customerAddress, Date startingDate, Date endDate, Room[] roomList) {
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.roomList = roomList;
        this.customerFirstName = customerFirstName;
        this.customerSurName = customerSurName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Room[] getRoomList() {
        return roomList;
    }

    public void setRoomList(Room[] roomList) {
        this.roomList = roomList;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerSurName() {
        return customerSurName;
    }

    public void setCustomerSurName(String customerSurName) {
        this.customerSurName = customerSurName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
