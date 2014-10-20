/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;

/**
 *
 * @author student
 */
class QueryResult {

    private List<Room> rooms;
    private int price;

    public QueryResult() {
    }

    public QueryResult(List<Room> rooms, int price) {
        this.rooms = rooms;
        this.price = price;
    }

    public List<Room> rooms() {
        return this.rooms;
    }

    public int price() {

        return this.price;
    }
}
