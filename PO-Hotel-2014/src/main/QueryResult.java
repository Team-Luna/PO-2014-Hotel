/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author student
 */
class QueryResult implements Comparable {

    private List<Room> rooms;
    private int price;

    public QueryResult() {
        this.rooms = new ArrayList<>();
        this.price = Integer.MAX_VALUE;
    }

    public QueryResult(List<Room> rooms, int price) {
        this.rooms = rooms;
        this.price = price;
    }

    public QueryResult(List<Room> rooms) {
        this.rooms = rooms;
        this.price = Integer.MAX_VALUE;
    }

    public List<Room> rooms() {
        return this.rooms;
    }

    public int price() {
        return this.price;
    }

    public int roomsCapacity() {
        int cap = 0;
        for (Room r : rooms) {
            cap += r.getCapacity();
        }
        return cap;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != QueryResult.class) {
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        } else {
            QueryResult temp = (QueryResult) obj;
            if (temp.price() != price()) {
                return false;
            }
            if (rooms.isEmpty() && temp.rooms.isEmpty()) {
                return true;
            }
            if (rooms.isEmpty() || temp.rooms.isEmpty()) {
                return false;
            }
            if (roomsCapacity() == temp.roomsCapacity()) {
                return true;
            }
            return false;
        }
    }

    @Override
    public int compareTo(Object t) {
        QueryResult p2 = (QueryResult) t;
        if (this.price() > p2.price()) {
            return +1;
        } else {
            if (this.price() < p2.price()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
