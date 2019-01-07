import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
public class gs {

	public static void main(String[] args) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        // Install Authenticator
        MyAuthenticator.setPasswordAuthentication("sadhana.burra@biogen.com.devusccs", "usrbame:Goal@2019");
        Authenticator.setDefault (new MyAuthenticator ());

        try {
            url = new URL("https://usccsdev-biogen-usccsdev.cs94.force.com/servlet/servlet.FileDownload?file=00P0R000003NqiTUAS");
            
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

    }

}