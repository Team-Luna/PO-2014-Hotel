package main;

import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Room implements Comparable {
    
    private int ID;
    private int floor;
    private String roomID;
    private int[] beds;
    private int price;
    private List<Season> seasons;
    
    public Room() {
        this.ID = -1;
        this.roomID = "";
        this.floor = -1;
        this.beds = null;
    }
    
    public Room(int ID, int floor, String roomID, int[] beds) {
        this.ID = ID;
        this.roomID = roomID;
        this.floor = floor;
        this.beds = beds;
    }
    
    public Room(int ID, int floor, String roomID, int[] beds, List<Season> seasons) {
        this.ID = ID;
        this.roomID = roomID;
        this.floor = floor;
        this.beds = beds;
        this.seasons = seasons;
    }
    
    public String name() {
        return roomID;
    }
    
    public int nPersons() {
        int temp = 0;
        for (int i = 0; i < beds.length; i++) {
            temp += beds[i];
        }
        return temp;
    }
    
    public int getPriceForDay(Calendar day) {
        if (!seasons.isEmpty()) {
            for (Season season : seasons) {
                if (season.start.before(day) || season.start.equals(day)) {
                    if (season.end.after(day)) {
                        return season.price;
                    }
                }
            }
        }
        return price;
    }
    
    public int price(Calendar day) {
        return getPriceForDay(day);
    }
    
    public int getFloor() {
        return floor;
    }
    
    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int[] getBeds() {
        return beds;
    }
    
    public void setBeds(int[] beds) {
        this.beds = beds;
    }
    
    public String getRoomID() {
        return roomID;
    }
    
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
    
    public int getCapacity() {
        return IntStream.of(beds).sum();
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Room.class) {
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        } else {
            Room temp = (Room) obj;
            if (temp.getID() != getID()) {
                return false;
            }
            if (temp.getFloor() != getFloor()) {
                return false;
            }
            if (!temp.getRoomID().equals(getRoomID())) {
                return false;
            }
            return true;
        }
    }
    
    @Override
    public int compareTo(Object t) {
        Room p2 = (Room) t;
        if (this.getCapacity() > p2.getCapacity()) {
            return +1;
        } else {
            if (this.getCapacity() < p2.getCapacity()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
}
