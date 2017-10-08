
/**
 * This program will take an input in the form of an email id,
 * and output the name of the faculty member who uses the id.
 *
 * @author Justin Rauh
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
public class Email
{
    
   public static void main(String args[]) throws Exception 
   {
       InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Random rand = new Random();
        System.out.println("Greetings Resident\nPlease enter the I.D. of the desired personel.");
        String name = br.readLine();
        String url = "http://www.ecs.soton.ac.uk/people/";
        String fullURL = url+name;
        //System.out.println(fullURL);
        URL myURL = new URL(fullURL);
         BufferedReader in = new BufferedReader(
        new InputStreamReader(myURL.openStream()));
        String inputLine;
        String title = "";
        String telephone = "";
        System.out.println("Affermative. Searching Now.\n");
        int n = rand.nextInt(10)+3;
        for(int q=0;q<=n;q++)
        {
            System.out.print(" .");
            Thread.sleep(300);
        }
        
        while ((inputLine = in.readLine()) != null){
            if(inputLine.contains("<title>"))
            {
            title = inputLine.substring(11,inputLine.indexOf("|")-1);
            }
            if(inputLine.contains("property='telephone'>"))
            {
                int a = inputLine.indexOf("property='telephone'>")+21;
                String temp = inputLine.substring(a); 
                int b = a+temp.indexOf("</a>");
                telephone = inputLine.substring(a,b);
            }
        }
        in.close();
        System.out.println("\n"+title);
        System.out.println(telephone);
        
        
    }

    /**
     * Constructor for objects of class Email
     */
    public Email()
    {
    
    }
}
