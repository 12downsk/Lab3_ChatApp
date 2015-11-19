/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author MohammadA
 */ 
public class Story{
    public String story;
    public Calendar date;
    public Story(String story,Calendar date){
        this.story=story;
        this.date=date;
    }
    
    public String toString(){
        String str_date=date.get(Calendar.MONTH) + 1 + "/"+date.get(Calendar.DATE)+"  "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
        return "("+str_date+"): "+this.story;
    }
    
}
