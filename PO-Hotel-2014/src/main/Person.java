/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author student
 */
public class Person {
    private String FirstName;
    private String LastName;
    
    public String getName(){
        return this.FirstName+" "+this.LastName;
    }
    
    public void SetName(String FirstName, String LastName){
        this.FirstName=FirstName;
        this.LastName=LastName;
    }
}
