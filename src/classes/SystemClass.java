/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author mustafakapucu
 */
public class SystemClass {
    public static String loggedUser = null;
    public static String loggedUserMail = null;
    public static ArrayList<Event> Events = new ArrayList<>();
    public static Guest guest = null;
    public static Student student = null;
    public static Instructor instructor = null;
    public static String user_type = null;
    static Connection con = databaseConnection.connection();
   SimpleDateFormat sdt = new SimpleDateFormat("HH:mm",new Locale("tr","TR"));
   SimpleDateFormat sdd = new SimpleDateFormat("MM-dd-yyyy",new Locale("tr","TR"));
    
    
    
    public SystemClass() {
        
    }
    
                         
            
    public static void  newUser(JTextField a, // Each of the places where we get data from the user while designing gui has its own name. For example, in the place we used for the Register panel, we set the name of the section where the user writes his name as s_name. Since we cannot access the Register panel directly here, we have written the function parameters here as JTextField, like JComboBox f. Later, we called this function in the Register.java --- Design section when the user clicked the Register button.
                               JTextField b,
                               JTextField c,
                               JTextField d,
                               JTextField e,
                               JPasswordField f,
                               JComboBox g,
                               JComboBox h,
                               JTextField i
                                       ){
                                
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO `user`(`name`, `lastname`, `phone`, `email`, `password`, `gender`,`usertype`,`snumber`) VALUES(?,?,?,?,?,?,?,?)");

            if(h.getSelectedItem().equals("Guest")){
                Guest gst;
                  gst = new Guest(a.getText(),
                        b.getText(),
                        (c.getText()+d.getText())
                        ,e.getText(),
                        f.getText(),
                        (String)g.getSelectedItem(),
                        (String) h.getSelectedItem());
                
                
                
                
                pst.setString(1, gst.getName());
                pst.setString(2, gst.getSurname());
                pst.setString(3, gst.getPhoneNumber());
                pst.setString(4, gst.getE_mail());
                pst.setString(5, gst.getPassword());
                pst.setString(6, gst.getGender());
                pst.setString(7, gst.getType());
                pst.setString(8, null);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"REGISTER SUCCESSFULL");
            }
            else if (h.getSelectedItem().equals("Student")){
                Student st = new Student(a.getText(),
                        b.getText(),
                        (c.getText()+d.getText())
                        ,e.getText(),
                        f.getText(),
                        (String)g.getSelectedItem(),
                        (String) h.getSelectedItem(),
                        i.getText());
                
                
                
                pst.setString(1, st.getName());
                pst.setString(2, st.getSurname());
                pst.setString(3, st.getPhoneNumber());
                pst.setString(4, st.getE_mail());
                pst.setString(5, st.getPassword());
                pst.setString(6, st.getGender());
                pst.setString(7, st.getType());
                pst.setString(8, st.getStudentId());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"REGISTER SUCCESSFULL");
            }
            
            else{
                Instructor inst = new Instructor(a.getText(),
                        b.getText(),
                        (c.getText()+d.getText())
                        ,e.getText(),
                        f.getText(),
                        (String)g.getSelectedItem(),
                        (String) h.getSelectedItem());
                
              
                
                
                pst.setString(1, inst.getName());
                pst.setString(2, inst.getSurname());
                pst.setString(3, inst.getPhoneNumber());
                pst.setString(4, inst.getE_mail());
                pst.setString(5, inst.getPassword());
                pst.setString(6, inst.getGender());
                pst.setString(7, inst.getType());
                pst.setString(8, null);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"REGISTER SUCCESSFULL");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        
      }
     
    public static boolean log(String mail , String  password){  //Here we wrote a boolean function that returns true or false. Here, it will search the mail and password received from the user in the relevant table in the database, return true if found, or false if the mail and password do not match.
        PreparedStatement pst, pst2 ;
        
        ResultSet rs , rs2;
        String query = "SELECT * FROM `user` WHERE `email` =? AND `password` =?";
        String query2 = "SELECT * FROM `user` WHERE `email` ="+"'"+mail+"'";
        
            try {
            pst = con.prepareStatement(query);
            pst.setString(1, mail);
            pst.setString(2, password);
            rs= pst.executeQuery();
            
            if(rs.next()){
                pst2 = con.prepareStatement(query2);
                rs2=pst2.executeQuery(query2);
                if(rs2.next()){
                    
                loggedUser = rs2.getString("name")+" "+rs2.getString("lastname"); 
                user_type= rs2.getString("usertype");
                loggedUserMail= mail;
                
                if(user_type.equals("Instructor")){
                    instructor= new Instructor(rs2.getString("name"),
                            rs2.getString("lastname"),
                            rs2.getString("phone"),
                            rs2.getString("email"),
                            rs2.getString("password"),
                            rs2.getString("gender"),
                            rs2.getString("usertype"));
                    
                }
                
                else if(user_type.equals("Student")){
                    student= new Student(rs2.getString("name"),
                            rs2.getString("lastname"),
                            rs2.getString("phone"),
                            rs2.getString("email"),
                            rs2.getString("password"),
                            rs2.getString("gender"),
                            rs2.getString("usertype"),
                            rs2.getString("snumber"));
                }
                
                else{
                    guest=new Guest(rs2.getString("name"),
                            rs2.getString("lastname"),
                            rs2.getString("phone"),
                            rs2.getString("email"),
                            rs2.getString("password"),
                            rs2.getString("gender"),
                            rs2.getString("usertype"));
                }
                }
                
                
        return true;      
        }
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,e);
        }
        
         return false;
}
    
    
    public ArrayList<Event> readFromdb(String valueToSearch){  // This function adds the events  
               ArrayList<Event> list =  new ArrayList<Event>();        // from the database into an arraylist and then returns
                                                                       // that list to us.
               
               
                try {
                    con = databaseConnection.connection();
                    PreparedStatement ps;
                    ps=con.prepareStatement("SELECT * FROM `event` WHERE CONCAT "
                     + "(`e_id`,"
                     + "`e_name`,"
                     + "`e_venue`,"
                     + "`e_date`,"
                     + "`e_hour`,"
                     + "`e_description`,"
                     + "`e_price`,"
                     + "`e_image`) "
                     + "LIKE ?");
                    ps.setString(1,"%"+ valueToSearch+"%");
                    ResultSet rs = ps.executeQuery();
                    Event e ;
                    while(rs.next()){
                        e = new Event(rs.getInt("e_id"),
                            rs.getString("e_name"),
                            rs.getString("e_venue"),
                            rs.getDate("e_date"),
                            rs.getDate("e_hour"),
                            rs.getString("e_description"),
                            rs.getDouble("e_price"),
                            rs.getBytes("e_image"));
                        
                    list.add(e);
                    Events.add(e);
                    }   
                } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null, e);
                }
                
                return list;
            }
            
            
            
            
    public class TheModel extends AbstractTableModel{ // don't care
                private String [] columns ;    
                private Object [][] rows ;
                
                
                public TheModel(Object[][] data , String [] columnName){
                    this.rows=data;
                    this.columns=columnName;
      
               
               }
                @Override
                public Class getColumnClass(int column){
                        
                        if(column == 1){
                            return Icon.class;
                            }
                        else{
                            return getValueAt(0,column).getClass();
                    }
                }
                
                @Override
                public int getRowCount() {
                        return this.rows.length;
                }           

                @Override
                public int getColumnCount() {
                        return this.columns.length;
                 }

    
                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
    
                        return this.rows[rowIndex][columnIndex];
                    }
                @Override
                public String getColumnName(int col){
                        return this.columns[col];
    }
            }
     public void populateJTable(JTable table){  //We call the above function to create an event class type arraylist. Then we get the data in this list with the get functions in Event class. We use a for loop to fill in the required places in the table.
                    //The important point here is that we use the getBytes method when we capture images from the database. Others like getString etc. as you already know.

                    ArrayList<Event> list = readFromdb("");
                    String[] columnName = {"Id","Image","Event","Venue","Date","Hour","Description","Price"};
                    Object[][] rows = new Object[list.size()][8];
                    for(int i = 0; i < list.size(); i++){
                        rows[i][0]= list.get(i).geteId();
                        rows[i][2] = list.get(i).geteTitle();
                        rows[i][3] = list.get(i).geteVenue();
                        rows[i][4] = list.get(i).geteStart();
                        rows[i][5] = sdt.format(list.get(i).geteHour()); 
                        rows[i][6] = list.get(i).geteDescription();
                        rows[i][7] = list.get(i).getePrice();

                        if(list.get(i).geteImage()!= null){

                         ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).geteImage()).getImage()
                         .getScaledInstance(457, 252, 0) );   
                         
                        rows[i][1] = image;
                        }
                        else{
                            rows[i][1] = null;
                        }
                       
                    }

                    TheModel model = new TheModel(rows, columnName);
                    table.setModel(model);
                    table.setRowHeight(252); 
                    table.setAutoResizeMode(0);
                    table.getColumnModel().getColumn(1).setPreferredWidth(457);
                    table.getColumnModel().getColumn(6).setPreferredWidth(152);
                    
                    for(int k=2 ; k<8 ; k++){
                    table.getColumnModel().getColumn(k).setCellRenderer(new WordWrapCellRenderer());}
                   } 
                   
     static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
          WordWrapCellRenderer() 
                   {
                        setLineWrap(true);
                        setWrapStyleWord(true);
                        
                        setBackground(Color.WHITE);
 
                    }

          @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setText(value.toString());
                setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
                        
                return this;
                }
            }
                   
                   
                   
         public static void addEvent(JTextField a, //Here, just like the newUser function below, we used the components whose function parameters we use in gui design.
                                        JTextField b,
                                        JDateChooser c,
                                        JTextField d,
                                        JTextArea e,
                                        JTextField f,
                                        byte[] image){
                       
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        
        
        try {
            
            PreparedStatement ps ;
            ps= con.prepareStatement("INSERT INTO `event`(`e_name`,"
                    + " `e_venue`,"
                    + " `e_date`,"
                    + " `e_hour`,"
                    + " `e_description`,"
                    + " `e_price`,"
                    + " `e_image`) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, a.getText());
            ps.setString(2, b.getText());
            ps.setString(3, dcn.format((c.getDate())));
            ps.setString(4, d.getText());
            ps.setString(5, e.getText());
            ps.setString(6, f.getText());
            ps.setBytes(7, image);
           
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"ADDED SUCCESSFULLY");
        } 
        catch(SQLException h){
            JOptionPane.showMessageDialog(null, h);
        }                       
     }
         

    public  void fillHome(JTable table){
         ArrayList<Event> mlist = readFromdb("");
        
        
        String[] columnName = {"","Event","Venue","Date","Hour","Details","Price"};
        Object[][] rows = new Object[mlist.size()][7];
                for(int i = 0; i < mlist.size(); i++){
            rows[i][1] = mlist.get(i).geteTitle();
            rows[i][2] = mlist.get(i).geteVenue();
            rows[i][3] = mlist.get(i).geteStart();
            rows[i][4] = sdt.format((mlist.get(i).geteHour()));
            rows[i][5] = mlist.get(i).geteDescription();
            rows[i][6] = mlist.get(i).getePrice()+"₺";

            if(mlist.get(i).geteImage()!= null){

             ImageIcon image = new ImageIcon(new ImageIcon(mlist.get(i).geteImage()).getImage()
             .getScaledInstance(228, 252,Image.SCALE_SMOOTH) );   

            rows[i][0] = image;
            }
            else{
                rows[i][0] = null;
            }

        }
        
        TheModel model = new TheModel(rows, columnName);
        table.setModel(model);
        table.setRowHeight(252);
        table.setAutoResizeMode(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(228);
        table.getColumnModel().getColumn(5).setPreferredWidth(152);
        table.setRowMargin(15);
        
            
        
        for(int k=1 ; k<7 ; k++){
        table.getColumnModel().getColumn(k).setCellRenderer(new WordWrapCellRenderer());
        
        }
        
        table.getTableHeader().setBorder(new MatteBorder(5,5,0,5,Color.white));

    }
     
    public static void compRes(String a , String b , String c , Date e , Double d){
        
        PreparedStatement ps;
        
        try {
            ps= con.prepareStatement("INSERT INTO `reservations`(`r_id`,"
                    + " `mail`,"
                    + " `ename`,"
                    +  "`e_date`,"
                    + " `price`)"
                    +" VALUES(?,?,?,?,?)");
            
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setDate(4, (java.sql.Date) e);
            ps.setDouble(5, d);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
    

