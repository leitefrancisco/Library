/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

/**
 *
 * @author Xiquinho
 */
public abstract class BaseModel {
    
    
    
    
    private String id;

    public BaseModel(String id) {
        this.id = id;
    }
    
    
    
    
    
    public String getId() {
        return id;
    }
    
     public void setId(String i) {
        this.id = i;
    }
}
