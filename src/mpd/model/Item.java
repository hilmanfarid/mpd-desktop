/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.model;

import java.util.HashMap;

/**
 *
 * @author toshiba
 */
public class Item {
    
    private Integer id;
    private String description;
    private HashMap additionVal;
    
    public Item(Integer id, String description) {
        this.id = id;
        this.description = description;    
        this.additionVal = new HashMap<String,String>();
        
    }
    
    public String getAdditionalVal(String key) {
        String value = (String) additionVal.get(key);
        return value;
    }
    
    public void setAdditionalVal(String key, String value) {
        additionVal.put(key, value);
    }
    
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return description;
    }
    @Override
    public boolean equals(Object obj) {
        Item thisObj = (Item) obj;
        if(this.id==thisObj.id){
            return true;
        }else{
            return false;
        }
    }
}
