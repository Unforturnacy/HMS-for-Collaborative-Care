
package ApplicationCore;
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
import UserInteraction.*;
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

                
                patients.add(new patient(id, name, occupation, email, gender, tele, symp, blood, add, docseen, paid, date));
            
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

    public  ArrayList<admin> getadmins()
    {
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from admins";
        ArrayList<admin> admins = new ArrayList<admin>();
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
                admins.add(new admin(id, fname, lname, user, pass, email, pos, tele));   
            
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
        String SQL = "insert into patients (name, occupation, email, gender, telephone, symptoms, blood, address, doctor_seen, amount_paid, app_date)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     
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
            preparedStmt.setString    (6, patient.get_symm());
            preparedStmt.setString    (7, patient.get_blood());
            preparedStmt.setString    (8, patient.get_address());
            preparedStmt.setString    (9, patient.get_docseen());
            preparedStmt.setDouble(10, patient.get_Paid());
            preparedStmt.setString    (11, patient.get_Date());
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
    
}
