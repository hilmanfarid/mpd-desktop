/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.model;

/**
 *
 * @author toshiba
 */
public class Item {
    
    private Integer id;
    private String description;
    
    public Item(Integer id, String description) {
        this.id = id;
        this.description = description;
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
    
}
