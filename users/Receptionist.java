
package users;
public class Receptionist{
    private int id;
    private String fname;
    private String lname;
    private String user;
    private String pass;
    private String email;
    private String pos;
    private String tele;
    public Receptionist(int id, String fname, String lname, String user, String pass, String email, String pos, String tele)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.user = user;
        this.pass = pass;
        this.email  = email;
        this.pos = pos;
        this.tele = tele;
    }

    public String get_User()
    {
        return this.user;
    }

    public String get_Password()
    {
        return this.pass;
    }

    public String get_Name()
    {
        return this.fname +" "+lname;
    }
}