/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.views;

import library.tableModels.ReadersTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import library.controllers.BorrowController;
import library.controllers.ReaderController;
import library.utils.Sorter;
import library.models.Book;
import library.models.Reader;
import library.utils.InvalidFileException;

/**
 *
 * @author f.meireles
 */
public class BookDetail extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form BookDetail
     */
    private Book book;
    private MainFrame mf;
    
    
    public BookDetail(MainFrame mf, Book book) {
        this.mf = mf;
        this.book = book;
        initComponents();
        setLabels();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBookTitle = new javax.swing.JLabel();
        lblBookAuthor = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        readersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnSearchName = new javax.swing.JButton();
        btnSearchId = new javax.swing.JButton();
        btnRegisterNewReader = new javax.swing.JButton();
        btnConfirmReader = new javax.swing.JButton();

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

        lblBookTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblBookTitle.setText("Book Title");

        lblBookAuthor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBookAuthor.setText("Book Author");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(lblBookAuthor))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblBookTitle)))
                .addContainerGap(819, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBookTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBookAuthor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Reader:");

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
        readersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(readersTable);

        jLabel2.setText("Search by Name:");

        jLabel3.setText("Search By ID:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnSearchName.setText("Search Name");

        btnSearchId.setText("Search ID");
        btnSearchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIdActionPerformed(evt);
            }
        });

        btnRegisterNewReader.setText("Register New Reader");

        btnConfirmReader.setText("Select Reader");
        btnConfirmReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmReaderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirmReader))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchName)
                                .addGap(84, 84, 84)
                                .addComponent(btnRegisterNewReader))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1454, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnSearchId)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchName)
                    .addComponent(btnRegisterNewReader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmReader)
                    .addComponent(btnBack))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void btnSearchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchIdActionPerformed
    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        showAllReaders();
    }//GEN-LAST:event_formInternalFrameOpened
    
    private void btnConfirmReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmReaderActionPerformed
        if(getSelectedReader().getActive().equals("0")){
            JOptionPane.showMessageDialog(this, "This Reader is inactive, please go to Readers Search and Activate him/her");
        }
        else{
            if(readersTable.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(this, "no reader selected");
                
            }
            else{
                int n = JOptionPane.showConfirmDialog(this,"Confirm Borrow \n\nBOOK: \n"+
                        book.getTitle()+" \nTO:\n "+
                        getSelectedReader().getFullName(),
                        "Confirm Borrow",
                        JOptionPane.YES_NO_OPTION);
                if(n==0){
                    BorrowController bc = new BorrowController();
                    String readerId = getSelectedReader().getId();
                    
                    try {
                        bc.addNewBorrow(readerId, book.getId());
                        JOptionPane.showMessageDialog(this, "Borrow registered");
                        this.mf.refreshMemory();
                        this.mf.goHome();
                    } catch (IOException ex) {
                        Logger.getLogger(BookDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidFileException ex) {
                        Logger.getLogger(BookDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConfirmReaderActionPerformed
    
    private void readersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readersTableMouseClicked
        
    }//GEN-LAST:event_readersTableMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmReader;
    private javax.swing.JButton btnRegisterNewReader;
    private javax.swing.JButton btnSearchId;
    private javax.swing.JButton btnSearchName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblBookAuthor;
    private javax.swing.JLabel lblBookTitle;
    private javax.swing.JTable readersTable;
    // End of variables declaration//GEN-END:variables
    
    public void setLabels(){
        lblBookTitle.setText("TITLE: "+ book.getTitle());
        lblBookAuthor.setText("Author: "+ book.getAuthorLastName()+
                ", " + book.getAuthorFirstName()+".");
        
    }
    
    private void setTableModel(ReadersTableModel model){
        
        Sorter sorter = new Sorter();
        model.setReaders(sorter.sortReadersByName(model.getReaders()));
        readersTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                int col = readersTable.columnAtPoint(e.getPoint());
                
                if(col==0){
                    model.setReaders(sorter.sortReadersByName(model.getReaders()));
                    readersTable.repaint();
                }
                
                else if(col==1){
                    model.setReaders(sorter.sortReadersByName(model.getReaders()));
                    readersTable.repaint();
                }
            }
        });
        readersTable.setModel(model);
        readersTable.setRowHeight(50);
        readersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        readersTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        readersTable.getColumnModel().getColumn(3).setMinWidth(180);
        readersTable.getColumnModel().getColumn(3).setMaxWidth(180);
        readersTable.removeColumn(readersTable.getColumnModel().getColumn(3));
        readersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        readersTable.repaint();
    }
    
    private void showAllReaders() {
        
        Reader[]readers = new ReaderController().getAll();
        if(readers.length==0){
            JOptionPane.showMessageDialog(this, "No Readers Registered");
        }
        
        ReadersTableModel model = new ReadersTableModel(readers);
        setTableModel(model);
    }
    private Reader getSelectedReader(){
       
        return (Reader) readersTable.getModel().getValueAt(readersTable.getSelectedRow(), 3);
    }
    
    
}
