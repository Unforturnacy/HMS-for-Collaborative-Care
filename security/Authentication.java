package security;
import java.util.ArrayList;
import users.*;


public class Authentication {
    protected String username;
    protected String password;
    public String name;
  
    public Authentication(String userTest, String passTest)
    {
        this.username = userTest;
        this.password = passTest;
    }
    
    public boolean[] authenticate(ArrayList<Receptionist>adminList)
    {
            boolean coruse = false;
            boolean corpass = false;
            for(Receptionist ad : adminList)
            {
                if (ad.get_User().equals(username))
                {
                    coruse = true;
                    if(ad.get_Password().equals(password))
                    {
                        corpass = true;
                        name = ad.get_Name();

                        break;
                
                    }
                } 
    
            }
            boolean[] result={coruse,corpass};
            return result;
    }
}
