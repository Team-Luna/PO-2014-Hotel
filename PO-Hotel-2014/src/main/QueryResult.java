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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != QueryResult.class){
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }else{
            QueryResult temp = (QueryResult) obj;
            if(temp.price() != price()){
                return false;
            }
            boolean check = true;
            for(int i=0; i<rooms.size(); i++){
                if(!(rooms.get(i).equals(temp.rooms.get(i)))){
                    check = false; 
                }
            }
            return check;
        }
    }
    
}
