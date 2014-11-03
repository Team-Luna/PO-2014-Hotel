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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public final class IniReader {
    Properties p = new Properties();
    
    public IniReader(){
        try {
            p.load(new FileInputStream("user.ini"));
        } catch (IOException ex) {
            Logger.getLogger(IniReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Calendar getSeasonStart(){
        String month = p.getProperty("SeasonStartMonth");
        String day = p.getProperty("SeasonStartDay");
        Calendar start = Calendar.getInstance();
        start.set(Calendar.MONTH, Integer.parseInt(month));
        start.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        return start;
    }
    
    public Calendar getSeasonEnd(){
        String month = p.getProperty("SeasonEndMonth");
        String day = p.getProperty("SeasonEndDay");
        Calendar start = Calendar.getInstance();
        start.set(Calendar.MONTH, Integer.parseInt(month));
        start.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        return start;
    }
    
    public double getSeasonMulti(){
        return Double.parseDouble(p.getProperty("SeasonMultiplyer"));
    }
}
