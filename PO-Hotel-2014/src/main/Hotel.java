package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Hotel {

    private List<Room> rooms;
    private List<Room> tempRooms;
    private List<Reservation> reservation;
    private ConfigReader reader = new ConfigReader();

    public Hotel() {
        this.reservation = new ArrayList<>();
    }

    public Hotel(int rooms) {
        this.reservation = new ArrayList<>();
        this.rooms = new ArrayList<>();
        for (int i = 0; i < rooms; i++) {
            Room temp = new Room(i, 0, ("R" + i), new int[]{2});
            this.rooms.add(temp);
        }
    }

    public Hotel(int rooms, int[][] beds) {
        this.reservation = new ArrayList<>();
        this.rooms = new ArrayList<>();
        int pointer = 0;
        for (int i = 0; i < rooms; i++) {
            Room temp = new Room(i, 0, ("R" + i), beds[pointer++]);
            this.rooms.add(temp);
        }
    }

    /**
     * @param args Starting parameter
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void add(Room room) {

    }

    public Room room(String room) {
        return null;

    }

    public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int nPersons) {
        if (end.before(Calendar.getInstance())) {
            return new ArrayList<QueryResult>();
        }
        if (rooms == null || rooms == new ArrayList<Room>()) {
            return new ArrayList<QueryResult>();
        }
        List<QueryResult> ret = new ArrayList<>();
        tempRooms = new ArrayList<Room>(rooms);

        for (int a = 0; a < 3; a++) {

            List<Room> proposedRooms = getRooms(nPersons);
            if (proposedRooms.isEmpty()) {
                break;
            }
            //System.out.println("Loop: "+a);
            int price = 0;
            for (Room r : proposedRooms) {
                //System.out.println("Room: "+r.name()+"|"+r.getCapacity());
                price += getRoomPrice(r, start, end);
            }
            //System.out.println("Price: "+price);

            QueryResult retQuery = new QueryResult(proposedRooms, price);
            ret.add(retQuery);
        }
        return ret;
    }

    public static long daysBetween(final Calendar startDate, final Calendar endDate) {
        //assert: startDate must be before endDate  
        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        long endInstant = endDate.getTimeInMillis();
        int presumedDays
                = (int) ((endInstant - startDate.getTimeInMillis()) / MILLIS_IN_DAY);
        Calendar cursor = (Calendar) startDate.clone();
        cursor.add(Calendar.DAY_OF_YEAR, presumedDays);
        long instant = cursor.getTimeInMillis();
        if (instant == endInstant) {
            return presumedDays;
        }

        final int step = instant < endInstant ? 1 : -1;
        do {
            cursor.add(Calendar.DAY_OF_MONTH, step);
            presumedDays += step;
        } while (cursor.getTimeInMillis() <= endInstant);
        return presumedDays;
    }

    private List<Room> getRooms(int nPersons) {
        List<Room> rooms = new ArrayList<>();
        //Easy Variant
        /*
         for (Room room : tempRooms) {
         if (room.getCapacity() >= nPersons) {
         rooms.add(room);
         tempRooms.remove(room);
         break;
         }
         }*/
        //Hard Variant
        Collections.sort(tempRooms, Collections.reverseOrder());
        int assignedCapacity = 0;
        for (Room room : tempRooms) {
            assignedCapacity += room.getCapacity();
            rooms.add(room);
            //tempRooms.remove(room);

            if (assignedCapacity >= nPersons) {
                break;
            }
        }
        for (Room room : rooms) {
            tempRooms.remove(room);
        }
        //return rooms;
        if (assignedCapacity >= nPersons) {
            return rooms;
        }
        return new ArrayList<>();
    }

    public void reserve(Calendar start, Calendar end, QueryResult result, Person person) {
        Reservation newRes = new Reservation(start, end, result, person);
        this.reservation.add(newRes);
    }

    private int getRoomPrice(Room r, Calendar start, Calendar end) {
        int price = 0;
        Calendar loopDay = (Calendar) start.clone();
        int days = (int) daysBetween(start, end);
        //System.out.println("Days: "+days);
        for (int i = 0; i < days; i++) {
            price += reader.getPriceForDay(r.getCapacity(), loopDay);
            loopDay.add(Calendar.DAY_OF_MONTH, 1);
        }

        return price;
    }

}
