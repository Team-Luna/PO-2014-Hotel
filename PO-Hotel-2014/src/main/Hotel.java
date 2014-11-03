package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Hotel {

    private List<Room> rooms;
    private List<Room> tempRooms;
    private List<Reservation> reservation;

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
        tempRooms = new ArrayList<>();
        tempRooms = rooms;

        for (int a = 0; a < 3; a++) {

            List<Room> proposedRooms = getRooms(nPersons);

            int price = 0;
            for (Room r : proposedRooms) {
                //TODO Seasons
                switch (r.getCapacity()) {
                    case 1:
                        price += (120 * (int) daysBetween(start, end));
                        break;
                    case 2:
                        price += (180 * (int) daysBetween(start, end));
                        break;
                    case 4:
                        price += (300 * (int) daysBetween(start, end));
                        break;
                    default:
                        price += 0;
                        break;
                }
            }

            if (proposedRooms.isEmpty()) {
                break;
            }

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
        for (Room room : tempRooms) {
            int i = room.getCapacity();
            if (room.getCapacity() >= nPersons) {
                rooms.add(room);
                tempRooms.remove(room);
                break;
            }
        }
        return rooms;
    }
    
    public void reserve(Calendar start, Calendar end, QueryResult result, Person person){
           Reservation newRes = new Reservation(start, end, result, person);
           this.reservation.add(newRes);
    }

}
