package AWT_Swing_Projects.User_Login_Page;
import java.lang.*;
public class Main
{
    public static void main(String[] args)
    {
        IDandPasswords idandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    }
}
