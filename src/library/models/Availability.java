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
public class Availability extends BaseModel{
   
    private int amtAvailable;
    private String[] readersId;
        
    //Book_Id,Amount_Available,queue

    public Availability(String bookId, String amt, String queue) {
        super(bookId);
        this.amtAvailable = Integer.parseInt(amt);
        
        this.readersId = queue.split(";");
        
    }

    public void setAmtAvailable(int amtAvailable) {
        this.amtAvailable = amtAvailable;
    }

    public String getCsvLine() {
        return getId() +","+amtAvailable+","+String.join(";",  this.readersId    ); 
    }
//
//    public String readQueueToString(){
//        ArrayList<String> a = new ArrayList<>();
//        Queue q = queue;
//        String current = null;
//        do {
//            current = q.dequeue();
//            if(current!=null){
//                a.add(current);
//            }
//        }while(current!=null);
//        
//        if(queue.peakFirst()==null){
//            System.out.println("Fodeu");
//        }
//        
//        return ;
//    }

  

    public String[] getReadersId() {
        return readersId;
        
    }

    public int getAmount() {
        return amtAvailable;
    }
    
    
    
}
