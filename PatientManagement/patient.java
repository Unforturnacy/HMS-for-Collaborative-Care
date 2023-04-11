package PatientManagement;
import java.util.ArrayList;


public class patient {
    enum Appointment {
        PENDING,
        BOOKED,
        NOARRIVAL,
        ARRIVED,
        FULFILLED,

      }


    private int id;
    private String name;
    private String occupation;
    private String email;
    private String gender;
    private String tele;
    private String blood;
    private String add;
    private String docseen;
    private String date;
    private double paid;
    private Appointment app;
    private String recepSeen;
    private String doctorRemark = "";
    private String medication = "";
    
    public patient(int id, String name, String occupation, String email, String gender, String tele, String app, String blood,
    String add,String docseen,double paid,String date, String recepSeen){
        this.id = id;
        this.name = name;
        this.occupation  = occupation;
        this.email = email;
        this.gender = gender;
        this.tele = tele;
        this.date = date; 
        this.blood = blood;
        this.add = add;
        this.docseen = docseen;
        this.paid = paid;
        this.recepSeen = recepSeen;

        switch(app.toLowerCase())
        {
            case "pending":
                this.app = Appointment.PENDING;
                break;
            case "arrived":
                this.app = Appointment.ARRIVED;
                break;
            case "noarrival":
                this.app = Appointment.NOARRIVAL;
                break;
            case "fulfilled":
                this.app = Appointment.FULFILLED;
                break;
            default:
             this.app = Appointment.BOOKED;
        }
    

    }

    public void setDocRemark(String mes)
    {
        doctorRemark = mes;
    }

    public void setmedication(String mes)
    {
        medication = mes;
    }


    public String getDocRemark()
    {
        return this.doctorRemark;
    }

    public String getMedication()
    {
        return medication;
    }
    public int getid()
    {
        return this.id;
    }

    public String getRecep()
    {
        return this.recepSeen;
    }

    public String getname()
    {
        return this.name;
    }

    public String get_group()
    {
        return this.blood;
    }

    public String getgender()
    {
        return this.gender;
    }
    public String email()
    {
        return this.email;
    }

    public String tele()
    {
        return this.tele;
    }

    public String get_docseen()
    {
        return this.docseen;
    }

    public String getoc()
    {
        return this.occupation;
    }

    public double get_Paid()
    {
        return this.paid;
    }

    public String get_Date()
    {
        return this.date;
    }

    public String get_address()
    {
        return this.add;
    }

    public String get_tele()
    {
        return this.tele;
    }

    public String get_blood()
    {
        return this.blood;
    }

    
    

    public String get_app()
    {
        return app.toString();
    }
    
    
    
}
