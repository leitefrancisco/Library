/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.utils;
import library.models.Book;
import library.models.Reader;
/**
 * this class is responsible for the sorting in the program
 * @author Francisco
 */

public class Sorter {
    
    private boolean bookTitleClicked = false;
    private boolean bookAuthorClicked = false;
    private boolean readerNameClicked = false;
    private boolean borrowIdClicked = false;
    /**
     * sort the Books by title and depending on a boolean, it determines if it will be ascending or descending order
     * this is to allow the sorting happens by clicking only on the header of the table the items are shown
     * @param books
     * @return 
     */
    public Book[] sortBooksByTitle(Book[] books){
        
        for (int i = 1; i<books.length; i++){
            
            Book key = books[i];
            int pos = i;
            if (!bookTitleClicked){
                while(pos > 0 && books[pos-1].getTitle().compareToIgnoreCase(key.getTitle()) > 0){
                    books[pos]=books[pos-1];
                    pos --;
                }
                books[pos]=key;
            }
            else{
                while(pos > 0 && books[pos-1].getTitle().compareToIgnoreCase(key.getTitle()) < 0){
                    books[pos]=books[pos-1];
                    pos --;
                    
                }
                books[pos]=key;
            }
        }
        if(this.bookTitleClicked){
            this.bookTitleClicked = false;
        }
        else{
            this.bookTitleClicked = true;
        }
        return books;
    }
    /**
     * sort the Books by Author and depending on a boolean, it determines if it will be ascending or descending order
     * this is to allow the sorting happens by clicking only on the header of the table the items are shown
     * @param books
     * @return 
     */
    public Book[] sortBooksByAuthor(Book[] books){
        
        for (int i = 1; i<books.length; i++){
            
            Book key = books[i];
            int pos = i;
            if (bookAuthorClicked){
                while(pos > 0 && books[pos-1].getAuthorFullName().compareToIgnoreCase(key.getAuthorFullName()) > 0){
                    books[pos]=books[pos-1];
                    pos --;
                }
                books[pos]=key;
            }
            else{
                while(pos > 0 && books[pos-1].getAuthorFullName().compareToIgnoreCase(key.getAuthorFullName()) < 0){
                    books[pos]=books[pos-1];
                    pos --;
                    
                }
                books[pos]=key;
            }
        }
        if(bookAuthorClicked){
            this.bookAuthorClicked = false;
        }
        else{
            this.bookAuthorClicked = true;
        }
        return books;
    }
    /**
     * sort the Readers by their names and depending on a boolean, it determines if it will be ascending or descending order
     * this is to allow the sorting happens by clicking only on the header of the table the items are shown
     * @param readers
     * @return 
     */
    public Reader[] sortReadersByName(Reader[]readers){
        
        for (int i = 1; i<readers.length; i++){
            
            Reader key = readers[i];
            int pos = i;
            if (readerNameClicked){
                while(pos > 0 && readers[pos-1].getFullName().compareToIgnoreCase(key.getFullName()) < 0){
                    readers[pos]=readers[pos-1];
                    pos --;
                }
                readers[pos]=key;
            }
            else{
                while(pos > 0 && readers[pos-1].getFullName().compareToIgnoreCase(key.getFullName()) > 0){
                    readers[pos]=readers[pos-1];
                    pos --;
                    
                }
                readers[pos]=key;
            }
        }
        if(readerNameClicked){
            this.readerNameClicked = false;
        }
        else{
            this.readerNameClicked = true;
        }
        return readers;
    }
    
//    public Reader[] sortReadersById(Reader[]readers){
//
//        for (int i = 1; i<readers.length; i++){
//
//            Reader key = readers[i];
//            int pos = i;
//            int intId = Integer.parseInt(readers[i].getId());
//
//            if (readerNameClicked){
//                while(pos > 0 && intId > 0){
//               // while(pos > 0 && readers[pos-1].getId().compareToIgnoreCase(key.getId()) < 0){
//                    readers[pos]=readers[pos-1];
//                    pos --;
//                }
//                readers[pos]=key;
//            }
//            else{
//                while(pos > 0 && intId < 0){
//                //while(pos > 0 && readers[pos-1].getId().compareToIgnoreCase(key.getId()) > 0){
//                    readers[pos]=readers[pos-1];
//                    pos --;
//
//                }
//                readers[pos]=key;
//            }
//        }
//        if(readerNameClicked){
//            this.readerNameClicked = false;
//        }
//        else{
//            this.readerNameClicked = true;
//        }
//        return readers;
//    }
    
//    public Borrow[] sortBorrowsById(Borrow[] borrows) {
//
//        for (int i = 1; i<borrows.length; i++){
//
//            Borrow key = borrows[i];
//            int pos = i;
//            int intId = Integer.parseInt(borrows[i].getId());
//
//            if (borrowIdClicked){
//                 while(pos > 0 && intId > 0){
//                //while(pos > 0 && borrows[pos-1].getId().compareToIgnoreCase(key.getId()) < 0){
//                    borrows[pos]=borrows[pos-1];
//                    pos --;
//                }
//                borrows[pos]=key;
//            }
//            else{
//                 while(pos > 0 && intId < 0){
//                //while(pos > 0 && borrows[pos-1].getId().compareToIgnoreCase(key.getId()) > 0){
//                    borrows[pos]=borrows[pos-1];
//                    pos --;
//
//                }
//                borrows[pos]=key;
//            }
//        }
//        if(!borrowIdClicked){
//            this.borrowIdClicked = true;
//        }
//        else{
//            this.borrowIdClicked = false;
//        }
//        return borrows;
//    }
    
}
