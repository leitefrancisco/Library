/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.tableModels.ReadersTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import library.controllers.AvailabilityController;
import library.controllers.ReaderController;
import library.models.Availability;
import library.models.Book;
import library.models.Reader;
import library.utils.InvalidFileException;

/**
 * This view will receive a book as a parameter and will show the current queue for it
 * @author Francisco
 */
public class BookQueue extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form BookQueue
     */
    private Book book;
    private MainFrame mf;
    public BookQueue(MainFrame mf,Book book) {
        initComponents();
        this.mf = mf;
        this.book = book;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        readersTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRemoveFirst = new javax.swing.JButton();
        btnAddToQueue = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        readersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(readersTable);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRemoveFirst.setText("Remove First in Queue");
        btnRemoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFirstActionPerformed(evt);
            }
        });

        btnAddToQueue.setText("Add Reader To Queue");
        btnAddToQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToQueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoveFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnAddToQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();  
    }//GEN-LAST:event_btnBackActionPerformed
    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        showBookQueue();
    }//GEN-LAST:event_formInternalFrameOpened
    
    private void btnRemoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFirstActionPerformed
        try {
            int n = JOptionPane.showConfirmDialog(this,"Remove First Reader From Queue?",
                    "Confirm remove",
                    JOptionPane.YES_NO_OPTION);
            if(n==0){
                AvailabilityController ac = new AvailabilityController();
                ac.removeFirstReaderFromQueue(book.getId());
                JOptionPane.showMessageDialog(this," First Reader was removed from Queue");
            }
            
            
        } catch (IOException | InvalidFileException ex) {
            Logger.getLogger(BookQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        showBookQueue();
        this.repaint();
    }//GEN-LAST:event_btnRemoveFirstActionPerformed
    
    private void btnAddToQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToQueueActionPerformed
        this.mf.showReadersToAddInQueue(book);
    }//GEN-LAST:event_btnAddToQueueActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToQueue;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveFirst;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable readersTable;
    // End of variables declaration//GEN-END:variables
    
    /**
     * will set the model for the table
     * @param model
     */
    private void setTableModel(ReadersTableModel model){
        readersTable.setModel(model);
        readersTable.setRowHeight(50);
        readersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        readersTable.removeColumn(readersTable.getColumnModel().getColumn(3));
        readersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        readersTable.repaint();
    }
    
    /**
     * gets the readers in the queue in the memory and created a model with it
     * to be used in the setTableModel Method
     */
    private void showBookQueue() {
        ReaderController rc = new ReaderController();
        AvailabilityController ac = new AvailabilityController();
        Availability bookAvailability = ac.getById(book.getId());
        ArrayList<Reader> readers = new ArrayList<>();
        
        if(bookAvailability.getWaitReadersId().length!=0){
            for(String s: bookAvailability.getWaitReadersId()){
                readers.add(rc.getReaderById(s));
            }
        }
        
        ReadersTableModel model = new ReadersTableModel(readers.toArray(new Reader[readers.size()]));
        setTableModel(model);
        if(readers.toArray(new Reader[readers.size()]).length==0){
            JOptionPane.showMessageDialog(this, "The Queue is Empty");
        }
    }
}
