/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.views;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.controllers.AvailabilityController;
import library.controllers.BookController;
import library.controllers.BorrowController;
import library.controllers.ReaderController;
import library.models.Book;
import library.models.Reader;
import library.utils.InvalidFileException;

/**
 *This Class is the Main Frame and it will control all the other frames, in order to open and change the view all internal frames will have this 
 * class as a parameter and this class controls what will be shown in its Desktop Pane
 * 
 * @author f.meireles
 * 
 */
public class MainFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form Main
     */
    public MainFrame(){
        initComponents();
        refreshMemory();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        panelTop = new javax.swing.JPanel();
        btnBookSearch = new javax.swing.JButton();
        btnReaders = new javax.swing.JButton();
        btnRegisterReader = new javax.swing.JButton();
        btnRegisterBook = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        btnBookSearch.setText("Search Book");
        btnBookSearch.setName(""); // NOI18N
        btnBookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookSearchActionPerformed(evt);
            }
        });

        btnReaders.setText("Readers List");
        btnReaders.setToolTipText("");
        btnReaders.setActionCommand("btnReaders");
        btnReaders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadersActionPerformed(evt);
            }
        });

        btnRegisterReader.setText("Register New Reader");
        btnRegisterReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterReaderActionPerformed(evt);
            }
        });

        btnRegisterBook.setText("Register New Book");
        btnRegisterBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterBookActionPerformed(evt);
            }
        });

        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnReturn.setText("Return Book / See All Borrows");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnBookSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReaders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterReader)
                .addGap(2, 2, 2)
                .addComponent(btnReturn)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBookSearch)
                        .addComponent(btnReaders)
                        .addComponent(btnRegisterReader)
                        .addComponent(btnRegisterBook)
                        .addComponent(btnReturn))
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBookSearch.getAccessibleContext().setAccessibleName("btnBookSearch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPanel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookSearchActionPerformed
        
        showBookSearchFrame();
        
    }//GEN-LAST:event_btnBookSearchActionPerformed
    
    private void btnReadersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadersActionPerformed
        showReaderSearch();
    }//GEN-LAST:event_btnReadersActionPerformed
    
    private void btnRegisterBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterBookActionPerformed
        showBookRegister();
    }//GEN-LAST:event_btnRegisterBookActionPerformed
    
    private void btnRegisterReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterReaderActionPerformed
        showReaderRegister();
    }//GEN-LAST:event_btnRegisterReaderActionPerformed
    
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        goHome();
    }//GEN-LAST:event_btnHomeActionPerformed
    
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        showBorrows();
    }//GEN-LAST:event_btnReturnActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                MainFrame mf = new MainFrame();
                mf.setVisible(true);      
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookSearch;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReaders;
    private javax.swing.JButton btnRegisterBook;
    private javax.swing.JButton btnRegisterReader;
    private javax.swing.JButton btnReturn;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
    
    /**
     * This method receives a view as a parameter and open it in the its DeskTop panel, 
     * this method removes everything from the desktop pane in the main frame
     * and displays only the new Internal frame
     *  @param JInternalFrame
     */
    private void showWindow(javax.swing.JInternalFrame window){
        this.desktopPanel.removeAll();
        window.setVisible(true);
        window.setClosable(false);
        this.desktopPanel.add(window);
        try {
            window.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method receives a view as a parameter and open it in the its DeskTop panel, 
     * this method does not remove anything from the desktop pane in the main frame and the displays the
     * new Internal Frame over the current Internal frame allowing the user to go back to the previous screen
     * @param JInternalFrame
     */
    private void showClosableWindow(javax.swing.JInternalFrame window) {
        
        this.desktopPanel.add(window);
        window.moveToFront();
        
        window.setVisible(true);
        try {
            window.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /**
     * shows the books in the system
     */
    private void showBookSearchFrame() {
        BookSearch bs = new BookSearch(this);
        showWindow(bs);
    }
    /**
     * Loads the CSV files in the memory so the program doesn't need to read the files every time to fill in a table of books or readers for example
     */
    void refreshMemory() {
        try {
            new AvailabilityController().loadFile();
            new ReaderController().loadFile();
            new BookController().loadFile();
            new BorrowController().loadFile();
            
        } catch (InvalidFileException | IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * shows the book detail frame 
     * @param Book
     */
    void showBookDetail(Book book) {
        BookDetail bd = new BookDetail(this, book);
        showClosableWindow(bd);
    }
    /**
     * shows a table of readers in the system
     */
    void showReaderSearch(){
        ReaderSearch rs = new ReaderSearch(this);
        showWindow(rs);
    }
    /**
     * shows Reader Register View
     */
    void showReaderRegister(){
        ReaderRegister rr = new ReaderRegister(this);
        showWindow(rr);
    }
    /**
     * show Book Register View
     */
    void showBookRegister(){
        BookRegister br = new BookRegister(this);
        showWindow(br);
    }
    /**
     * Show Borrows view
     */
    void showBorrows() {
        Borrows br = new Borrows(this);
        showWindow(br);
    }
    /**
     * From any View this method will allow the user to go to Home Screen
     */
    public void goHome(){
        desktopPanel.removeAll();
        desktopPanel.repaint();
    }
    /**
     * show  ReaderBorrowHistoric view 
     * @param Reader
     */
    void showReaderBorrowHistoric(Reader reader) {
        ReaderBorrowsHistoric rbh = new ReaderBorrowsHistoric(this, reader);
        showClosableWindow(rbh);
    }
    /**
     * Show Reader Edit View
     */
    void showReaderEdit(Reader reader) {
        ReaderEdit re = new ReaderEdit(this, reader);
        showClosableWindow(re);
    }
    /**
     * show BookQueue View
     * @param Book
     */
    void showBookQueue(Book book) {
        BookQueue bq = new BookQueue(this,book);
        showClosableWindow(bq);
    }
    /**
     * Show Reader to add in Queue View
     * @param Book
     */
    void showReadersToAddInQueue(Book book) {
        ReadersToAddInQueue rq = new ReadersToAddInQueue(this, book);
        showClosableWindow(rq);
    }
    
}
