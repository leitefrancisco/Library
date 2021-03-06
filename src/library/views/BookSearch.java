/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.views;

import library.tableModels.BooksTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import library.controllers.AvailabilityController;
import library.controllers.BookController;
import library.controllers.ReaderController;
import library.utils.Sorter;
import library.models.Book;

/**
 *This view will show all the books in the system
 * @author Francisco
 */
public class BookSearch extends javax.swing.JInternalFrame {
    
    private MainFrame mf;
    private BookController bc;
    
    
    public BookSearch(MainFrame mf){
        this.mf = mf;
        this.bc = new BookController();
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtFieldTitleSearch = new javax.swing.JTextField();
        btnSearchByTitle = new javax.swing.JButton();
        btnClearFilters = new javax.swing.JButton();
        lblAuthor = new javax.swing.JLabel();
        txtFieldAuthorSearch = new javax.swing.JTextField();
        btnSearchByAuthor = new javax.swing.JButton();
        comboBoxGenre = new javax.swing.JComboBox();
        btnBorrowBook = new javax.swing.JButton();
        btnBookQueue = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1149, 466));
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

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booksTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1560, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setText("Search By Title: ");

        txtFieldTitleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTitleSearchActionPerformed(evt);
            }
        });

        btnSearchByTitle.setText("Search Title");
        btnSearchByTitle.setMaximumSize(new java.awt.Dimension(101, 23));
        btnSearchByTitle.setMinimumSize(new java.awt.Dimension(101, 23));
        btnSearchByTitle.setPreferredSize(new java.awt.Dimension(101, 23));
        btnSearchByTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByTitleActionPerformed(evt);
            }
        });

        btnClearFilters.setText("Clear Filters");
        btnClearFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFiltersActionPerformed(evt);
            }
        });

        lblAuthor.setText("Search By Author:");

        btnSearchByAuthor.setText("Search Author");
        btnSearchByAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByAuthorActionPerformed(evt);
            }
        });

        comboBoxGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGenreActionPerformed(evt);
            }
        });

        btnBorrowBook.setText("Borrow Selected Book");
        btnBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowBookActionPerformed(evt);
            }
        });

        btnBookQueue.setText("See Book Queue");
        btnBookQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookQueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAuthor)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFieldTitleSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtFieldAuthorSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchByAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchByTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(158, 158, 158)
                .addComponent(comboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearFilters)
                .addGap(65, 65, 65)
                .addComponent(btnBorrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(btnBookQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle)
                            .addComponent(txtFieldTitleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearFilters)))
                    .addComponent(btnSearchByTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFieldAuthorSearch))
                        .addContainerGap())
                    .addComponent(btnSearchByAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBookQueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrowBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1560, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            showAllBooks();
            showGenres();
            btnBookQueue.setEnabled(true);
            btnBorrowBook.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened
        
    private void txtFieldTitleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldTitleSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTitleSearchActionPerformed
    
    private void btnSearchByTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByTitleActionPerformed
        showBooksByTitleSearch();
    }//GEN-LAST:event_btnSearchByTitleActionPerformed
    /**
     * clear the filters in the view
     * @param evt 
     */
    private void btnClearFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFiltersActionPerformed
        try {
            showAllBooks();
            
        } catch (IOException ex) {
            Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtFieldTitleSearch.setText("");
        txtFieldAuthorSearch.setText("");
        comboBoxGenre.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearFiltersActionPerformed

    private void btnSearchByAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByAuthorActionPerformed
        showBooksByAuthorSearch();
    }//GEN-LAST:event_btnSearchByAuthorActionPerformed
    /**
     * goes to the next view (Detail Book) with the book selected
     * @param evt 
     */
    private void btnBorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowBookActionPerformed
        if(new ReaderController().getAll().length==0){
            JOptionPane.showMessageDialog(this, "No Readers Registered to Borrow Book");
        return;
        }
        int row = booksTable.getSelectedRow();
        if(row != -1){
        Book book = getSelectedBook();
        mf.showBookDetail(book);
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select a book", "No Book Selected", 1);
        }
    }//GEN-LAST:event_btnBorrowBookActionPerformed
    /**
     *controls the genre shown in the table
     * @param evt
     */
    private void comboBoxGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGenreActionPerformed
        String selectedGenre = (String) comboBoxGenre.getSelectedItem();
        if(selectedGenre.equals("Select Genre")){
            try {
                showAllBooks();
            } catch (IOException ex) {
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            txtFieldTitleSearch.setText("");
            txtFieldAuthorSearch.setText("");
            showBooksByGenre(selectedGenre);
        }
    }//GEN-LAST:event_comboBoxGenreActionPerformed
    
    private void btnBookQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookQueueActionPerformed
        int row = booksTable.getSelectedRow();
        if(row != -1){
        Book book = getSelectedBook();
        this.mf.showBookQueue(getSelectedBook());
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select a book", "No Book Selected", 1);
        }
    }//GEN-LAST:event_btnBookQueueActionPerformed
    /**
     * controls what options ara available for the selected book in the table
     * @param evt 
     */
    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked
       
        if(new AvailabilityController().getById(getSelectedBook().getId()).getAmount() == 0){
            btnBorrowBook.setEnabled(false);
        }
        else{
            btnBorrowBook.setEnabled(true);
        }
    }//GEN-LAST:event_booksTableMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable booksTable;
    private javax.swing.JButton btnBookQueue;
    private javax.swing.JButton btnBorrowBook;
    private javax.swing.JButton btnClearFilters;
    private javax.swing.JButton btnSearchByAuthor;
    private javax.swing.JButton btnSearchByTitle;
    private javax.swing.JComboBox comboBoxGenre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtFieldAuthorSearch;
    private javax.swing.JTextField txtFieldTitleSearch;
    // End of variables declaration//GEN-END:variables
   /**
    * loads the genres in memory into the combo box
    */
    private void showGenres(){
        String [] genres = bc.getGenres();
        comboBoxGenre.setModel(new javax.swing.DefaultComboBoxModel(genres));
    }
    /**
     * gets all books in the memory and adds it to the table
     * @throws IOException 
     */
    private void showAllBooks() throws IOException{
        BooksTableModel model = new BooksTableModel(bc.getAll());
        setTableModel(model);
    }
    /**
     * gets the books in memory that matches the title in the text Field
     */
    private void showBooksByTitleSearch(){
        Book[] books = bc.getBooksByTitle(txtFieldTitleSearch.getText());
        if(books.length==0){
            JOptionPane.showMessageDialog(this, "Error : No Books Found");
        }
        else{BooksTableModel model = new BooksTableModel(books);
        setTableModel(model);
        }
    }
    /**
     * gets the books in memory that matches the author in the text Field
     */
    private void showBooksByAuthorSearch() {
        Book[] books = bc.getBooksByAuthor(txtFieldAuthorSearch.getText());
        if(books.length==0){
            JOptionPane.showMessageDialog(this, "Error : No Author Found");
        }
        else{BooksTableModel model = new BooksTableModel(books);
        setTableModel(model);
        }
    }
     /**
      * set the model received to refresh the table 
      * @param model 
      */   
    private void setTableModel(BooksTableModel model){      
        Sorter sorter = new Sorter();
        model.setBooks(sorter.sortBooksByTitle(model.getBooks()));
        booksTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = booksTable.columnAtPoint(e.getPoint());
                if(col==0){
                    model.setBooks(sorter.sortBooksByTitle(model.getBooks()));
                    booksTable.repaint();
                }
                else if(col==1){
                    model.setBooks(sorter.sortBooksByAuthor(model.getBooks()));
                    booksTable.repaint();
                }
            }
        });
        booksTable.setModel(model);
        booksTable.setRowHeight(50);
        booksTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        booksTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        booksTable.getColumnModel().getColumn(3).setMinWidth(180);
        booksTable.getColumnModel().getColumn(3).setMaxWidth(180);
        booksTable.removeColumn(booksTable.getColumnModel().getColumn(5));
        booksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        booksTable.repaint();
    }
    /**
     * gets the book in memory based in the genre selected in the combo box
     * @param selectedGenre 
     */
    private void showBooksByGenre(String selectedGenre) {
        Book[] books = bc.getBooksByGenre(selectedGenre);
        if(books.length==0){
            JOptionPane.showMessageDialog(this, "Error : No Author Found");
        }
        else{BooksTableModel model = new BooksTableModel(books);
        setTableModel(model);
        }
    }
    /**
     * returns the selected book in the table
     */
    private Book getSelectedBook(){
        int row = booksTable.getSelectedRow();
        return (Book) booksTable.getModel().getValueAt(row, 5);
    }    
}
