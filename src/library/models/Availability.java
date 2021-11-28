/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.ArrayList;
import library.utils.Queue;

 

/**
 *This class is the model for the availability of the book, it will store if the book is currently available and whether it has a queue or not
 * @author Francisco
 */
public class Availability extends BaseModel{
   
    private int amtAvailable;
    private String[] waitReadersId;
    private Queue<Reader> queue;    
    //Book_Id,Amount_Available,queue

    public Availability(String bookId, String amt, String queue) {
        super(bookId);
        this.amtAvailable = Integer.parseInt(amt);
        if(queue == null || queue.equals("")){
            this.waitReadersId = new String[0];
        }else{ // "".split(";") [""]
            this.waitReadersId = queue.split(";");
        }
        this.queue = new Queue<Reader>(10);
    }
       
    public Queue<Reader> getQueue() {
        return queue;
    }
    
    public void setAmtAvailable(int amtAvailable) {
        this.amtAvailable = amtAvailable;
    }

    public String getCsvLine() {
        if(this.queue.isEmpty()){
             return getId() +","+amtAvailable+","; 
        }
        return getId() +","+amtAvailable+","+this.queue.toString(); 
    } 
  
    public String[] getWaitReadersId() {
        return waitReadersId;
        
    }

    public int getAmount() {
        return amtAvailable;
    }
    
    
    
    
    //0-)   []  1,2,3 fifo lifo
    
}
