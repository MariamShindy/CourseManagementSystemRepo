/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemangementsystem;

import java.util.List;

/**
 *
 * @author Dell
 */
class Branch {
    
    private int id;
    private String name;
    List<Room> rooms;

    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
