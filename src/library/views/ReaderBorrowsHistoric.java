/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.views;

import library.tableModels.BorrowsTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import library.controllers.BorrowController;
import library.utils.Sorter;
import library.models.Reader;

/**
 *
 * @author Xiquinho
 */
public class ReaderBorrowsHistoric extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReaderBorrowsHistoric
     */
    private MainFrame mf;
    private Reader reader;
    
    public ReaderBorrowsHistoric(MainFrame mf, Reader r) {
        initComponents();
        this.mf = mf;
        this.reader = r;
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReaderName = new javax.swing.JLabel();
        lblReaderID = new javax.swing.JLabel();
        lblReaderAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowsTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

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

        lblReaderName.setText("jLabel1");

        lblReaderID.setText("jLabel1");

        lblReaderAddress.setText("jLabel2");

        borrowsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(borrowsTable);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1612, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblReaderName, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(lblReaderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblReaderAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnBack)))
                        .addGap(0, 1228, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblReaderID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReaderName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReaderAddress)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBack)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     showAllBorrows();
     setLabels();
      
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borrowsTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReaderAddress;
    private javax.swing.JLabel lblReaderID;
    private javax.swing.JLabel lblReaderName;
    // End of variables declaration//GEN-END:variables

    private void setLabels() {
        lblReaderAddress.setText("Address: "+reader.getAddress());
        lblReaderName.setText("Full Name: " + reader.getFullName());
        lblReaderID.setText("ID: "+reader.getId());
                
    }
    
    private void setTableModel(BorrowsTableModel model){
        
//        Sorter sorter = new Sorter();
//        model.setBorrows(sorter.sortBorrowsById(model.getBorrows()));
//        borrowsTable.getTableHeader().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                
//                int col = borrowsTable.columnAtPoint(e.getPoint());
//                
//                
//                if(col==0){
//                    model.setBorrows(sorter.sortBorrowsById(model.getBorrows()));
//                    borrowsTable.repaint();
//                }
//
//            }
//        });
        borrowsTable.setModel(model);
        borrowsTable.setRowHeight(50);
        borrowsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        borrowsTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        borrowsTable.removeColumn(borrowsTable.getColumnModel().getColumn(4));
        borrowsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        borrowsTable.repaint();
    }

    private void showAllBorrows() {
        BorrowsTableModel model = new BorrowsTableModel(new BorrowController().getBorrowsByReaderId(reader.getId()));
        setTableModel(model);
    }
}
