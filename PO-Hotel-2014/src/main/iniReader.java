/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author student
 */
public final class iniReader {
    Properties p = new Properties();
    
    public iniReader() throws FileNotFoundException, IOException{
        p.load(new FileInputStream("user.ini"));
    }
    
    public Calendar getSeasonStart(){
        p.getProperty("SeasonStart");
        //TODO
        return null;
        
    }
    
    public Calendar getSeasonEnd(){
        p.getProperty("SeasonEnd");
        //TODO
        return null;
        
    }
    
    public Calendar getSeasonMulti(){
        p.getProperty("SeasonMultiplyer");
        //TODO
        return null;
        
    }
}
