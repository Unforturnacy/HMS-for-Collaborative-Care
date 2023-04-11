package chartGeneration;


import java.util.ArrayList;

import PatientManagement.patient;
import Storage.DatabaseContrroller;

public class chartController {
    private clientChart chart;
    private DatabaseContrroller db = new DatabaseContrroller();
    
    public chartController()
    {
        
    }
    public chartController(clientChart chart)
    {
        this.chart = chart;
    }


    public void addToTable(patient pat)
    {
       
    Object[] item={pat.get_Date(), pat.getDocRemark(), pat.getMedication()};
    chart.model.addRow(item); 

    }

    public void emptyRow()
    {
        Object[] item={""};
        chart.model.addRow(item);
    }

    public void loadTable()
    {
        ArrayList<patient> patients = new ArrayList<>();
        patients = db.getchartPatients(chart.pat.getname());

        for(patient patient : patients)
        {
            addToTable(patient);
        }
    }

    public void updateRemarks(String rem)
    {
        db.updateRemarks(rem, chart.pat.getid(), chart.apt);
    }

    public void updatTreatment(String rem)
    {
        db.updatMedic(rem, chart.pat.getid(), chart.apt);
    }
    
}
