package main;

/**
 * Created by K O M P U T E R on 2014-10-06.
 */
public class Room {
    private int ID;
    private int floor;
    private String roomID;
    private int[] beds;

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
    
    public String name(){
        return roomID;
    }
    
    public int nPersons(){
        int temp=0;
        for(int i=0;i<beds.length;i++){
            temp+=beds[i];
        }
        return temp;
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
}
