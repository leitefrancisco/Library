/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.models;


/**
 *
 * @author f.meireles
 */
public class Book extends BaseModel{
    
    
    
    private String authorFirstName;
    private String authorLastName;
    private String title;
    private String[] genres;
    private String authorFullName;

//    public Book(String id, String authorFirstName, String authorLastName, String title, String[] genres) {
//        this.id = id;
//        this.authorFirstName = authorFirstName;
//        this.authorLastName = authorLastName;
//        this.title = title;
//        this.genres = genres;
//        this.authorFullName = authorFirstName + " " + authorLastName;
//    }
    
    public Book(String id, int amt, String authorFirstName, String authorLastName, String title, String[] genres) {
        super(id);
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.genres = genres;
        this.authorFullName = authorFirstName + " " + authorLastName;
    }

   
  
    
    public String getAuthorFirstName() {
        return authorFirstName;
    }
    
    public String getAuthorLastName() {
        return authorLastName;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String[] getGenres() {
        return genres;
    }
    
    
//    public int getAmoutAvailable() {
//        // this.availability.getAmount()
//        return this.amountAvailable;
//    }
    
    public String getAuthorFullName() {
        return authorFullName;
    }
    
    @Override
    public String toString() {
        
        
        String toReturn ="Book{" + "id=" + getId() + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", title=" + title + ", Genres=";
        for (int i = 0; i<genres.length;i++){
            toReturn += genres[i] + ", ";
        }
        toReturn += "}";
        
        return  toReturn;
        
    } 

//    public void setAmount(int amtFile) {
//        this.amountAvailable = amtFile;
//    }
//    
    
    public static Book findBook(String bookId, Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if(books[i].getId().equals(bookId)){
                return books[i];
            }
        }
        return null;
    }

    
    public String getCsvLine() {
        return getId()+","+authorFirstName+","+authorLastName+","+"\""+title+"\","+String.join("|", genres);
    }
 
}
