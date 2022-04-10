/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import classes.* ;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author mustafakapucu
 */
public class AdminPanel extends javax.swing.JFrame{
    
    /**
     * Creates new form AdminPanel
     */
    
    protected byte[] image = null;
    String path = null;
    public AdminPanel() {
        
       initComponents();
       
       
       SystemClass sys = new SystemClass();
       sys.populateJTable(admin_table);
         
                }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Login.jPanelGradient();
        browser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        admin_table = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        event_name = new javax.swing.JTextField();
        event_venue = new javax.swing.JTextField();
        event_price = new javax.swing.JTextField();
        event_hour = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        event_descripton = new javax.swing.JTextArea();
        event_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        imagearea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AdminPanel");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        browser.setBackground(new java.awt.Color(0, 51, 102));
        browser.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        browser.setForeground(new java.awt.Color(255, 255, 255));
        browser.setText("Browse");
        browser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserActionPerformed(evt);
            }
        });
        jPanel1.add(browser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 130, 30));

        admin_table.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        admin_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Event", "Venue", "Date", "Hour", "Description", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        admin_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(admin_table);
        if (admin_table.getColumnModel().getColumnCount() > 0) {
            admin_table.getColumnModel().getColumn(0).setResizable(false);
            admin_table.getColumnModel().getColumn(1).setResizable(false);
            admin_table.getColumnModel().getColumn(2).setResizable(false);
            admin_table.getColumnModel().getColumn(3).setResizable(false);
            admin_table.getColumnModel().getColumn(4).setResizable(false);
            admin_table.getColumnModel().getColumn(5).setResizable(false);
            admin_table.getColumnModel().getColumn(6).setResizable(false);
        }
        admin_table.setAutoscrolls(false);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 0, 1020, 620));

        add.setBackground(new java.awt.Color(0, 51, 102));
        add.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 110, 30));

        delete.setBackground(new java.awt.Color(0, 51, 102));
        delete.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 110, 30));

        jLabel1.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel1.setText("Event Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 30));

        jLabel2.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel2.setText("Venue");
        jLabel2.setPreferredSize(new java.awt.Dimension(96, 28));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, -1));

        jLabel3.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel3.setText("Date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel4.setText("Hour");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel5.setText("Descripton");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel6.setText("Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Titillium Web", 0, 18)); // NOI18N
        jLabel7.setText("Image");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, 40));

        event_name.setPreferredSize(new java.awt.Dimension(96, 28));
        jPanel1.add(event_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, -1));

        event_venue.setPreferredSize(new java.awt.Dimension(96, 28));
        jPanel1.add(event_venue, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 250, -1));

        event_price.setPreferredSize(new java.awt.Dimension(96, 28));
        jPanel1.add(event_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, -1));

        event_hour.setPreferredSize(new java.awt.Dimension(96, 28));
        jPanel1.add(event_hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 250, -1));

        event_descripton.setColumns(20);
        event_descripton.setRows(5);
        jScrollPane3.setViewportView(event_descripton);
        event_descripton.setLineWrap(true);
        event_descripton.setWrapStyleWord(true);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 250, 140));

        event_date.setDateFormatString("MM-dd-yyyy");
        jPanel1.add(event_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 250, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 240, -1));
        jPanel1.add(imagearea, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void browserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","gif");
        chooser.addChoosableFileFilter(filter);
        int result= chooser.showSaveDialog(null);
        if(result== JFileChooser.APPROVE_OPTION){
            File selectedFile  = chooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            String fname = selectedFile.getName();
            imagearea.setText(fname);
        
            try {
                File sfile = new File(path);
                FileInputStream fis = new FileInputStream(path);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf  = new byte[1024];
                for(int readNum ;(readNum=fis.read(buf))!=-1;){
                    bos.write(buf,0,readNum);
                }
                image = bos.toByteArray();   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }         
    }//GEN-LAST:event_browserActionPerformed

    private void admin_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_tableMouseClicked
       int rowIndex =  admin_table.getSelectedRow();
      
       event_name.setText((String) admin_table.getValueAt(rowIndex, 2));
       event_venue.setText((String) admin_table.getValueAt(rowIndex, 3));
       event_date.setDate((Date) admin_table.getValueAt(rowIndex, 4));
       event_hour.setText(admin_table.getValueAt(rowIndex, 5).toString());
       event_descripton.setText((String) admin_table.getValueAt(rowIndex, 6));
       event_price.setText(admin_table.getValueAt(rowIndex, 7).toString());
       
       
          
        
    }//GEN-LAST:event_admin_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       event_name.setText("");
       event_venue.setText("");
       event_date.setDate(null);
       event_hour.setText("");
       event_descripton.setText("");
       event_price.setText("");
       SystemClass sys = new SystemClass();
       sys.populateJTable(admin_table);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
          SystemClass.addEvent(event_name, event_venue, event_date, event_hour, event_descripton, event_price, image);
      
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int row = admin_table.getSelectedRow();
        String cell = admin_table.getModel().getValueAt(row, 0).toString();

        String query = ("DELETE FROM `event` WHERE e_id="+cell);
        PreparedStatement ps;
        try {
            Connection con = databaseConnection.connection();
            ps= con.prepareStatement(query);
            ps.execute();
JOptionPane.showMessageDialog(null,
    "DELETE SUCCESSFULLY");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_deleteActionPerformed

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
           UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTable admin_table;
    private javax.swing.JButton browser;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser event_date;
    private javax.swing.JTextArea event_descripton;
    private javax.swing.JTextField event_hour;
    private javax.swing.JTextField event_name;
    private javax.swing.JTextField event_price;
    private javax.swing.JTextField event_venue;
    private javax.swing.JTextField imagearea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
