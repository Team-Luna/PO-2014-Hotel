package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Hotel {

    public List<Room> rooms;

    public Hotel() {
        // TODO Auto-generated constructor stub
    }

    public Hotel(int rooms) {
        this.rooms = new ArrayList<>();
        for (int i = 0; i < rooms ; i++) {
            Room temp = new Room(i, 0, ("R"+i), new int[]{2});
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
        if(end.before(Calendar.getInstance())){
            List<QueryResult> expResult = new ArrayList<>();
            return expResult;
        }
        
        return null;
    }

}
