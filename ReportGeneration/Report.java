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

import PatientManagement.patient;


public class Report {
    private ArrayList<String[]> patientLines;
    private ArrayList<String[]> eqLines;
    public Report(ArrayList<String[]> patientLines, ArrayList<String[]> eqLines)
    {
        this.patientLines = patientLines;
        this.eqLines = eqLines;
    }

    public  void download() throws IOException {

  
        // first create file object for file placed at location
        // specified by filepath
        File csvFile = new File("Report.csv");
        FileWriter fileWriter = new FileWriter(csvFile);
      
        for (String[] data : patientLines) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
    
        for (String[] data : eqLines) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }
    
}
