/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

/**
 *
 * @author usr
 */
public class Reader extends BaseModel{
    
    
    
    private String firstName;
    private String lastName;
    private String address;
    private String fullName;
    private String active;//1 = Active ; 0= Inactive
    
//    public Reader(String firstName, String lastName, String address) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.fullName = firstName+ " " + lastName;
//    }

    public String getActive() {
        return active;
    }
    
    public Reader(String id, String firstName, String lastName, String address,String active) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.fullName = firstName+ " " + lastName;
        this.active = active;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFullName() {
        this.fullName = firstName+ " " + lastName;;
    }
    
    
    

    @Override
    public String toString() {
       return getId();
    }

    public String getCsvLine() {
        return getId()+ "," + firstName+ "," +lastName+ ",\"" +address+"\","+active;
    }
 
    
    
    
    
    
    
    
    
    
    
}
