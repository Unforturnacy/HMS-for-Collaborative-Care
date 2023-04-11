package PatientManagement;

public class Querydetails {
    private String sign;
    private String field;
    private String value;
    public Querydetails(String sign, String field, String value )
    {
        this.sign = sign;
        this.field = field;
        this.value = value;
    }

    public String getsign()
    {
        return this.sign;
    }

    public String getfield()
    {
        return this.field;
    }

    public String getvalue()
    {
        return this.value;
    }
    
}
