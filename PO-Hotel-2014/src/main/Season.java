package main;

import java.util.Calendar;

/**
 *
 * @author student
 */
public class Season {
    public Calendar start;;
    public Calendar end;
    public int price;
    
    public Season(Calendar start, Calendar end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
    
    public Season(){
        
    }
    
}
