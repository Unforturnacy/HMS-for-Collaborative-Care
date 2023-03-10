package ApplicationCore;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import users.*;
import UserInteraction.*;
import security.*;
import security.*;
import users.*;


public class FilterController {
    private DefaultTableModel model2 = new DefaultTableModel();
    private UserLoginUI entry = new UserLoginUI();
    public FilterController(DefaultTableModel model2, UserLoginUI entry)
    {
        this.model2 = model2;
        this.entry = entry;
    }

    public void addToTable2(patient p)
    {
        String name= p.getname();
        System.out.println(p.get_Date());
        String[] item={Integer.toString(p.getid()),""+ name, ""+ p.get_docseen(),""+p.get_group(),""+p.get_Paid(),""+p.getgender(),""+p.get_Date()};
        model2.addRow(item);        

    }

    

    public void  populateTable()
    {
        
        
        model2.setRowCount(0);
            for(int i = 0 ; i <entry.patients.size();i++)
            {
                if (entry.patients.size()>0)
                    addToTable2(entry.patients.get(i));
    
            }
          
    }

    public void  displayResults(ArrayList<patient> pat)
    {
        

        model2.setRowCount(0);
            for(int i = 0 ; i <pat.size();i++)
            {
                if (pat.size()>0)
                    addToTable2(pat.get(i));
    
            }
    }

    public void filterResults(Querydetails qdetails)
    {
        JFrame f = new JFrame();
            boolean flag = true;
        if (qdetails.getsign() == " "){
            if(qdetails.getfield() == " " && (qdetails.getvalue().isEmpty() || qdetails.getvalue()==null))
            {
                populateTable();
            }
            else
            {
                JOptionPane.showMessageDialog(f, "Select a condition");
            }
            flag =false;

        }
        else if(qdetails.getfield() == " ")
        {
            JOptionPane.showMessageDialog(f, "Select a field");
            flag=false;
        }

        if ((qdetails.getfield().equals("Name") ||qdetails.getfield().equals("Doctor") ||qdetails.getfield().equals("Blood Group")||qdetails.getfield().equals("Gender")) && !qdetails.getsign().equals("="))
            {
                JOptionPane.showMessageDialog(f, "Can only use = on this field");
                flag= false;
            }

        if(flag){
            DatabaseContrroller db = new DatabaseContrroller(qdetails.getfield() ,qdetails.getsign(),qdetails.getvalue(),entry.patients);
            if(db.filter_query().size() > 0)
            {
                displayResults(db.filter_query());
            }
            else{
                JOptionPane.showMessageDialog(f, "No data found");
            }
        }
    }
    
}
