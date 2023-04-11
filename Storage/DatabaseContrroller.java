
package Storage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import users.*;
import security.*;
import java.util.Map;
import users.*;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import InventoryManagement.Equipment;
import PatientManagement.patient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;


public class DatabaseContrroller {
    private String name;
    private String email;
    private String response;
    private String gender;
    private String occ;
    private String contact;
    private String phone;
    private String sympton;
    private String blood;
    private String religion;
    private double price;
    private String date;
    private String doctor;
    private String field;
    private String operator;
    private String value;
    public ArrayList<patient> patients = new ArrayList<patient>();

    public DatabaseContrroller(String name,String email,String response)
    {
        this.name = name;
        this.email = email;
        this.response = response;
        insert_query();
    }


    public DatabaseContrroller(String field,String operator,String value,ArrayList<patient> patients)
    {
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.patients = patients;
    }

    public DatabaseContrroller()
    {

    }

    public ArrayList<patient> getPatients()
    {
        patients = new ArrayList<patient>();
        patients = new ArrayList<patient>();
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from patients";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                 int id = Integer.parseInt(result.getString(1));
                 String name = result.getString(2);
                 String occupation=result.getString(3);
                 String email=result.getString(4);
                 String gender=result.getString(5);
                 String tele=result.getString(6);
                 String symp=result.getString(7);
                 String blood=result.getString(8);
                 String add=result.getString(9);
                 String docseen=result.getString(10);
                 double paid=  Double.parseDouble(result.getString(11));
                 String date=result.getString(12);
                 String recep=result.getString(13);

                
                patients.add(new patient(id, name, occupation, email, gender, tele, symp, blood, add, docseen, paid, date, recep));
            
            }

            

            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }

        System.out.println("succesful");
        return patients;
    }




    public ArrayList<Equipment> getEquipments()
    {
        ArrayList<Equipment> equipments = new ArrayList<Equipment>();
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from equipments";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                 int id = result.getInt(1);
                 String name = result.getString(2);
                 int quantity=result.getInt(3);
                 double price =result.getDouble(4);
                 String restock =result.getString(5);
                

                
                 equipments.add(new Equipment(id, name, quantity, price, restock));
            
            }

            

            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }

        System.out.println("succesful");
        return equipments;
    }

    public  ArrayList<Receptionist> getadmins()
    {
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from admins";
        ArrayList<Receptionist> admins = new ArrayList<Receptionist>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
           
            while(result.next() != false)
            {
                int id = Integer.parseInt(result.getString(1));
                String fname = result.getString(2);
                String lname= result.getString(3);
                String user= result.getString(4);
                String pass= result.getString(5);
                String email= result.getString(6);
                String pos= result.getString(7);
                String tele= result.getString(8);
                admins.add(new Receptionist(id, fname, lname, user, pass, email, pos, tele));   
            
            }

            sqlSt.close();

            System.out.println(output);



        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
        return admins;
    }

    public void insert_query()
    {
        Statement sqlSt;
        String SQL = "insert into feedback (name, email, feedback)" + " values (?, ?, ?)";
     
        System.out.println(SQL);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, email);
            preparedStmt.setString (3, response);
            preparedStmt.execute();
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }



    public void insert_patient(patient patient)
    {
        Statement sqlSt;
        String SQL = "insert into patients (name, occupation, email, gender, telephone, symptoms, blood, address, doctor_seen, amount_paid, app_date, Receptionist)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     
        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, patient.getname());
            preparedStmt.setString (2, patient.getoc());
            preparedStmt.setString (3, patient.email());
            preparedStmt.setString(4, patient.getgender());
            preparedStmt.setString    (5, patient.get_tele());
            preparedStmt.setString    (6, patient.get_app());
            preparedStmt.setString    (7, patient.get_blood());
            preparedStmt.setString    (8, patient.get_address());
            preparedStmt.setString    (9, patient.get_docseen());
            preparedStmt.setDouble(10, patient.get_Paid());
            preparedStmt.setString    (11, patient.get_Date());
            preparedStmt.setString    (12, patient.getRecep());
            preparedStmt.execute();//magic
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }



    public void update_patient(patient patient)
    {
        Statement sqlSt;
        String SQL1 = "UPDATE patients SET name = ?, occupation = ?, email = ?, gender = ?, telephone = ?, symptoms = ?,";
        String SQL2 = " blood = ?, address = ?, doctor_seen = ?, amount_paid = ?, app_date = ? WHERE id = ?";
     
        String SQL = SQL1 + SQL2;

        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, patient.getname());
            preparedStmt.setString (2, patient.getoc());
            preparedStmt.setString (3, patient.email());
            preparedStmt.setString(4, patient.getgender());
            preparedStmt.setString    (5, patient.get_tele());
            preparedStmt.setString    (6, patient.get_app());
            preparedStmt.setString    (7, patient.get_blood());
            preparedStmt.setString    (8, patient.get_address());
            preparedStmt.setString    (9, patient.get_docseen());
            preparedStmt.setDouble(10, patient.get_Paid());
            preparedStmt.setString    (11, patient.get_Date());
            preparedStmt.setInt(12, patient.getid());
            preparedStmt.execute();//magic
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }



    public ArrayList<patient> filter_query(){
        ArrayList<patient> newpatients = new ArrayList<patient>();
        if(field.equals("Name"))
        {
            for(patient pat : patients)
            {
                if(pat.getname().equals(value))
                {
                    newpatients.add( pat);
                }
            }
        }
        else if(field.equals("Doctor"))
        {
            for(patient pat : patients)
            {
                if(pat.get_docseen().equals(value))
                {
                    newpatients.add( pat);
                }
            }
        }

        else if(field.equals("Blood Group"))
        {
            for(patient pat : patients)
            {
                if(pat.get_group().equals(value))
                {
                    newpatients.add( pat);
                }
            }
        }
        else if(field.equals("Gender"))
        {
            for(patient pat : patients)
            {
                if(pat.getgender().equals(value))
                {
                    newpatients.add( pat);
                }
            }
        }
        else
        {
             try
                {
                    Double.parseDouble(value);
                }
                catch (Exception e)
                {
                    return newpatients;
                }
            if(operator.equals("="))
            {
                for(patient pat : patients)
                {
                
                    if(pat.get_Paid() == Double.parseDouble(value))
                    {
                        newpatients.add( pat);
                    }
                }
            }
            else if(operator.equals(">"))
            {
                for(patient pat : patients)
                {
                
                    if(pat.get_Paid() > Double.parseDouble(value))
                    {
                        newpatients.add( pat);
                    }
                }

            }
            else
            {
                for(patient pat : patients)
                {
                
                    if(pat.get_Paid() < Double.parseDouble(value))
                    {
                        newpatients.add( pat);
                    }
                }
            }
        }

        return newpatients;
    }






    public void insert_equipment(Equipment equipment)
    {
        Statement sqlSt;
        String SQL = "insert into equipments(name, quantity, price, latest)" +" values (?, ?, ?, ?);";
        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, equipment.getname());
            preparedStmt.setInt (2, equipment.getquantity());
            preparedStmt.setDouble (3, equipment.getunit());
            preparedStmt.setString (4, equipment.getlatestRestock());
         
            preparedStmt.execute();//magic
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }



    public void updateEquipment(Equipment equip)
    {
        Statement sqlSt;
        String SQL = "UPDATE equipments SET quantity = ?, price = ? WHERE ID = ?;";
     

        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setInt (1, equip.getquantity());
            preparedStmt.setDouble (2, equip.getunit());
            preparedStmt.setInt (3, equip.getID());
            System.out.println(preparedStmt);
            preparedStmt.execute();//magic
            sqlSt.close();
            System.out.println("update succesful");
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }


    public ArrayList<patient> getchartPatients(String namee)
    {
        patients = new ArrayList<patient>();
        patients = new ArrayList<patient>();
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from patients WHERE name = '" + namee+"';";
        System.out.println(SQL);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                 int id = Integer.parseInt(result.getString(1));
                 String name = result.getString(2);
                 String occupation=result.getString(3);
                 String email=result.getString(4);
                 String gender=result.getString(5);
                 String tele=result.getString(6);
                 String symp=result.getString(7);
                 String blood=result.getString(8);
                 String add=result.getString(9);
                 String docseen=result.getString(10);
                 double paid=  Double.parseDouble(result.getString(11));
                 String date=result.getString(12);
                 String recep=result.getString(13);
                 String remarks = result.getString(14);
                 String medication = result.getString(15);
                 System.out.println(remarks);

                patient patientt = new patient(id, name, occupation, email, gender, tele, symp, blood, add, docseen, paid, date, recep);
                patientt.setDocRemark(remarks);
                patientt.setmedication(medication);
                patients.add(patientt);
            
            }

            

            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }

        System.out.println("succesful");
        return patients;
    }



    public void updateRemarks(String mes, int id, String appdate)
    {
        Statement sqlSt;
        String SQL = "UPDATE patients SET `Doctor Remarks` = ? WHERE id = ? AND `app_date` = ?";;
     

        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString(1,mes);
            preparedStmt.setInt(2,id);
            preparedStmt.setString(3,appdate);
        
            System.out.println(preparedStmt);
            preparedStmt.execute();//magic
            sqlSt.close();
            System.out.println("update succesful");
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }


    public void updatMedic(String mes, int id, String appdate)
    {
        Statement sqlSt;
        String SQL = "UPDATE patients SET `Medications` = ? WHERE id = ? AND `app_date` = ?";;
     

        System.out.println(SQL);

        try{

            //opening a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");


            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString(1,mes);
            preparedStmt.setInt(2,id);
            preparedStmt.setString(3,appdate);
        
            System.out.println(preparedStmt);
            preparedStmt.execute();//magic
            sqlSt.close();
            System.out.println("update succesful");
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }
    
}
