/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.tableModels;

import javax.swing.table.AbstractTableModel;
import library.models.Reader;

/**
 *
 * @author usr
 */
public class ReadersTableModel extends AbstractTableModel {
    private String[] columnNames = {"Reader Full Name   --A-Z-- ","Address","Active","Reader"};
    private Reader [ ] readers;
    

    public ReadersTableModel(Reader[] readers) {
        this.readers = readers;
    }
    
    public Reader[] getReaders(){
        return this.readers;
    }

    public void setReaders(Reader[] readers) {
        this.readers = readers;
    }
    
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public int getRowCount() {
          return readers.length;
    }
    
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //switch to return title, genre and director in the rent frame
        Reader reader = readers[rowIndex];
        switch (columnIndex){
            case 0: {
                return reader.getFirstName() +" "+reader.getLastName();
            }
            case 1:{
                return reader.getAddress();
            }
            case 2:{
                
                if(reader.getActive().equals("1")){
                    return "Active";
                }
                else {
                    return "Inactive";
                }
            }  
            case 3:{
                return reader;
            }
            
        }
        return null;
    }
}
