import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("proxyHost", "152.78.128.51");
        System.getProperties().put("proxyPort", "3128");

        URL oracle = new URL("https://secure.ecs.soton.ac.uk/people/dem/related_people");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}