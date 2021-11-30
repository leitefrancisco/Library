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
   
    private int available;//1 = available ; 2 = unavailable
    private String[] waitReadersId;
    private Queue<Reader> queue;    
    //Book_Id,Amount_Available,queue

    public Availability(String bookId, String amt, String queue) {
        super(bookId);
        this.available = Integer.parseInt(amt);
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
        this.available = amtAvailable;
    }

    public String getCsvLine() {
        if(this.queue.isEmpty()){
             return getId() +","+available+","; 
        }
        return getId() +","+available+","+this.queue.toString(); 
    } 
  
    public String[] getWaitReadersId() {
        return waitReadersId;
        
    }

    public int getAmount() {
        return available;
    }
    
    
    
    
    //0-)   []  1,2,3 fifo lifo
    
}
