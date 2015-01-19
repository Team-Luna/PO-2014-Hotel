package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javafx.print.Collation;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Hotel {

    private List<Room> rooms;
    private List<Room> tempRooms;
    private List<Reservation> reservation;
    private XMLReader reader = new XMLReader();

    /**
     * Clear Constructor. Makes empty reservation and room lists;
     */
    public Hotel() {
        this.reservation = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    /**
     * Constructor that loads Hotel from Config File
     *
     * @param load
     */
    public Hotel(boolean load) {
        if (true) {
            this.reservation = new ArrayList<>();
            this.rooms = reader.loadRooms();
        } else {
            this.reservation = new ArrayList<>();
            this.rooms = new ArrayList<>();
        }
    }

    /**
     * Constructor that loads Hotel from File
     *
     * @param load
     */
    public Hotel(String path) {
        this.reservation = new ArrayList<>();
        this.reader = new XMLReader(path);
        this.rooms = reader.loadRooms();
    }

    /**
     * Constructor with room number
     *
     * @param rooms number of required double rooms
     */
    public Hotel(int rooms) {
        this.reservation = new ArrayList<>();
        this.rooms = new ArrayList<>();
        for (int i = 0; i < rooms; i++) {
            Room temp = new Room(i, 0, ("R" + i), new int[]{2});
            this.rooms.add(temp);
        }
    }

    /**
     * Constructor with room number and specific beds
     *
     * @param rooms number of required rooms
     * @param beds array of beds arrays that will be put into rooms
     */
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

    /**
     * Fuction adding rooms
     *
     * @param room
     */
    public void add(Room room) {
        rooms.add(room);
    }

    /**
     * Function used to find a room with a name
     *
     * @param roomName name of the room to be found
     * @return
     */
    public Room room(String roomName) {
        for (Room room : rooms) {
            if (room.getRoomID().equals(roomName)) {
                return room;
            }
        }
        for (Room room : rooms) {
            if (room.getID() == Integer.parseInt(roomName)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Function returning best 3 room/price configurations in timespan for
     * number of persons.
     *
     * @param start Starting date of search
     * @param end Starting date of search
     * @param nPersons Number of people for whom to find rooms
     * @return List of room/price configurations
     */
    public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int nPersons) {
        if (end.before(Calendar.getInstance())) {
            return new ArrayList<QueryResult>();
        }
        if (rooms == null || rooms == new ArrayList<Room>()) {
            return new ArrayList<QueryResult>();
        }
        List<QueryResult> ret = new ArrayList<>();
        tempRooms = new ArrayList<Room>(rooms);
        clearTempRooms(start, end); //Removes rooms that have reservations during reservation period.

        //##### Phase 1 - Get Best Fitting Rooms
        for (int a = 0; a < 3; a++) {

            List<Room> proposedRooms = getRooms(nPersons);
            if (proposedRooms.isEmpty()) {
                break;
            }
            //System.out.println("Loop: " + a);
            int price = 0;
            for (Room r : proposedRooms) {
                //System.out.println("Room: "+r.name()+"|"+r.getCapacity());
                price += getRoomPrice(r, start, end);
            }
            //System.out.println("Price: "+price);

            QueryResult retQuery = new QueryResult(proposedRooms, price);
            ret.add(retQuery);
        }

        //##### Phase 2 - Get Smallest Rooms
        tempRooms = new ArrayList<Room>(rooms);
        clearTempRooms(start, end); //Removes rooms that have reservations during reservation period.
        QueryResult retQuery = getSmallRooms(nPersons, start, end);
        ret.add(retQuery);

        //##### Phase 3 - Get Cheapest Rooms NoTest
        tempRooms = new ArrayList<Room>(rooms);
        clearTempRooms(start, end); //Removes rooms that have reservations during reservation period.
        retQuery = getCheapestRooms(nPersons, start, end);
        ret.add(retQuery);

        //##### Final Phase
        List<QueryResult> returnQ = new ArrayList<>();
        int lowestPrice = Integer.MAX_VALUE;
        Collections.sort(ret);
        //for (QueryResult returnQuery : ret) {
        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i).price() < lowestPrice) {
                returnQ.clear();
                returnQ.add(ret.get(i));
                lowestPrice = ret.get(i).price();
            }
            if (ret.get(i).price() == lowestPrice && !returnQ.contains(ret.get(i))) {
                returnQ.add(ret.get(i));
            }
        }
        if (!returnQ.isEmpty()) {
            return returnQ;
        }

        return new ArrayList<>();
    }

    /**
     * Function returning number of days between 2 dates.
     *
     * @param startDate
     * @param endDate
     * @return
     */
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

    /**
     * Function returning optimal number of rooms for nPersons
     *
     * @param nPersons
     * @return
     */
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
         }
         return rooms;
         */
        //Hard Variant
        Collections.sort(tempRooms, Collections.reverseOrder());
        int assignedCapacity = 0;
        while (assignedCapacity < nPersons && !tempRooms.isEmpty()) {
            Room temp = getBestFittingRoom(nPersons - assignedCapacity);
            rooms.add(temp);
            assignedCapacity += temp.getCapacity();
            if (assignedCapacity >= nPersons) {
                break;
            }
        }
        if (assignedCapacity >= nPersons) {
            return rooms;
        }
        return new ArrayList<>();
    }

    /**
     * Reservation function
     *
     * @param start start date
     * @param end end date
     * @param result Chosen Query Result
     * @param person Person assigned to reservation
     */
    public void reserve(Calendar start, Calendar end, QueryResult result, Person person) {
        Reservation newRes = new Reservation(start, end, result, person);
        this.reservation.add(newRes);
    }

    /**
     * Returns reservation assigned to person
     *
     * @param person
     * @return
     */
    public Reservation getReservationForPerson(Person person) {
        for (Reservation res : reservation) {
            if (res.isAssignedTo(person)) {
                return res;
            }
        }
        return null;
    }

    /**
     * Returns list of reservations assigned to person
     *
     * @param person
     * @return
     */
    public List<Reservation> getReservationListForPerson(Person person) {
        List<Reservation> ret = new ArrayList<>();
        for (Reservation res : reservation) {
            if (res.isAssignedTo(person)) {
                ret.add(res);
            }
        }
        return ret;
    }

    /**
     * Returns room price for the stated period.
     *
     * @param r room
     * @param start start date
     * @param end end date
     * @return
     */
    private int getRoomPrice(Room r, Calendar start, Calendar end) {
        int price = 0;
        Calendar loopDay = (Calendar) start.clone();
        int days = (int) daysBetween(start, end);
        //System.out.println("Days: " + days);
        for (int i = 0; i < days; i++) {
            price += r.getPriceForDay(loopDay);
            loopDay.add(Calendar.DAY_OF_MONTH, 1);
        }

        return price;
    }

    /**
     * Function finding best fitting room When presented with equal distance
     * will prefere bigger room ex.: nPersons = 3, Rooms 4, 2, 2, 1 capacity
     * Will choose 4 person room
     *
     * @param i
     * @return
     */
    private Room getBestFittingRoom(int i) {
        List<Room> best = new ArrayList<>();
        for (Room room : tempRooms) {
            if (best.isEmpty()) {
                best.add(0, room);
            }
            if (getSizeDiff(room.getCapacity(), i) < getSizeDiff(best.get(0).getCapacity(), i)) {
                best.add(0, room);
            }
        }
        if (best.get(0) != null) {
            tempRooms.remove(best.get(0));
        }
        return best.get(0);
    }

    /**
     * Function returning size difference between rooms
     *
     * @param roomSize
     * @param desiredSize
     * @return
     */
    private int getSizeDiff(int roomSize, int desiredSize) {
        return Math.abs(roomSize - desiredSize);
    }

    /**
     * Crear tempRooms array of rooms that are reserved during the time period
     *
     * @param start
     * @param end
     */
    private void clearTempRooms(Calendar start, Calendar end) {
        for (Reservation res : reservation) {
            if ((res.getStartingDate().after(start)) && (res.getStartingDate().before(end))) {
                for (Room room : res.getRoomList()) {
                    tempRooms.remove(room);
                }
            }
            if ((res.getEndDate().after(start)) && (res.getEndDate().before(end))) {
                for (Room room : res.getRoomList()) {
                    tempRooms.remove(room);
                }
            }
        }
    }

    /**
     *
     * @return
     */
    private QueryResult getSmallRooms(int nPersons, Calendar start, Calendar end) {
        List<Room> rooms = new ArrayList<>();
        Collections.sort(tempRooms);
        int assignedCapacity = 0;
        int lowestPrice = Integer.MAX_VALUE;
        int finalPrice = 0;

        for (Room room : tempRooms) {
            if (rooms.isEmpty()) {
                rooms.add(room);
                assignedCapacity += room.getCapacity();
                lowestPrice = getRoomPrice(room, start, end);
                finalPrice += getRoomPrice(room, start, end);
            }
            if (getRoomPrice(room, start, end) < lowestPrice) {
                rooms.add(room);
                assignedCapacity += room.getCapacity();
                lowestPrice = getRoomPrice(room, start, end);
                finalPrice += getRoomPrice(room, start, end);
            } else {
                if (getRoomPrice(room, start, end) < (lowestPrice + (lowestPrice * 1.5))) {
                    rooms.add(room);
                    assignedCapacity += room.getCapacity();
                    finalPrice += getRoomPrice(room, start, end);
                }
            }
            if (assignedCapacity >= nPersons || !tempRooms.isEmpty()) {
                break;
            }
        }
        if (assignedCapacity < nPersons) {
            return new QueryResult();
        }

        return new QueryResult(rooms, finalPrice);
    }

    private QueryResult getCheapestRooms(int nPersons, Calendar start, Calendar end) {
        List<Room> rooms = new ArrayList<>();
        Collections.sort(tempRooms);
        int assignedCapacity = 0;
        int finalPrice = 0;

        for (int i = 0; i < tempRooms.size(); i++) {
            Room r = getCheapestRoom(start, end);
            if (assignedCapacity < nPersons) {
                rooms.add(r);
                assignedCapacity += r.getCapacity();
                finalPrice += getRoomPrice(r, start, end);
            }
        }

        if (assignedCapacity < nPersons) {
            return new QueryResult();
        }

        return new QueryResult(rooms, finalPrice);
    }

    private Room getCheapestRoom(Calendar start, Calendar end) {
        int lowestPrice = Integer.MAX_VALUE;
        Room cheapestRoom = new Room();
        for (Room room : tempRooms) {
            if (getRoomPrice(room, start, end) < lowestPrice) {
                cheapestRoom = room;
                lowestPrice = getRoomPrice(room, start, end);
            }
        }
        return cheapestRoom;
    }

}
