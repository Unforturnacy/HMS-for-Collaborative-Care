package ReportGeneration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import InventoryManagement.Equipment;
import PatientManagement.patient;
import Storage.DatabaseContrroller;

public class ReportDesigner {
    private ArrayList<String[]> patientLines;
    private ArrayList<String[]> eqLines;
    private double total = 0;
    private double b = 0;
    private DatabaseContrroller db = new DatabaseContrroller();
    public ReportDesigner()
    {
        patientLines = new ArrayList<>();
        eqLines = new ArrayList<>();
        patientLines.add(new String[] 
        { "Receptionist", "Patient Name", "Amount Paid"," ", "Total"});
        getPatientdata();
        gettInvdata();
        createReport();
    
    }

    public void createReport()
    {
        Report rep = new Report(patientLines, eqLines);
        try {
            rep.download();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getPatientdata()
    {
        ArrayList<patient> patients = db.getPatients();
        for (patient pat: patients)
        {
            total+=pat.get_Paid();
            patientLines.add(new String[] 
        { pat.getRecep(), pat.getname(), "$"+NumberFormat.getNumberInstance(Locale.US).format(pat.get_Paid())});
        }

        patientLines.add(new String[] 
        { "", "","","", "$"+NumberFormat.getNumberInstance(Locale.US).format(total) });
    }

    public void gettInvdata()
    {
       
        ArrayList<Equipment> equipments = db.getEquipments();
        eqLines.add(new String[] 
        { "",""});
        eqLines.add(new String[] 
        { "",""});
        eqLines.add(new String[] 
        { ""});

        eqLines.add(new String[] 
        { "Last Restocked", "Item Name", "Quantity", "Price"});
        for (Equipment eq: equipments)
        {
            b+=eq.getunit()*eq.getquantity();
            eqLines.add(new String[] 
        { eq.getlatestRestock(), eq.getname(), Integer.toString(eq.getquantity()), "$"+NumberFormat.getNumberInstance(Locale.US).format(eq.getunit()), "$"+NumberFormat.getNumberInstance(Locale.US).format(eq.getunit()*eq.getquantity())});
        }

        eqLines.add(new String[] 
        { "", "","", "","$"+NumberFormat.getNumberInstance(Locale.US).format(b) });
    }









    

   
}
