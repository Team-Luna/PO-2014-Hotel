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
    private String Email;
    private String Address;
    
    public String getName(){
        return FirstName+" "+this.LastName;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setName(String FirstName, String LastName){
        this.FirstName=FirstName;
        this.LastName=LastName;
    }
    
    public void setEmail(String Email){
        this.Email=Email;
    }
    
    public void setAddress(String Address){
        this.Address=Address;
    }
    
    public Person(){
        setName("","");
        setEmail("");
        setAddress("");
    }
    
    public Person(String FirstName, String LastName, String Email, String Address){
        setName(FirstName,LastName);
        setEmail(Email);
        setAddress(Address);
    }
}
