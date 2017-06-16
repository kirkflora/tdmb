package org.tmdb.api;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;

/**
 * Created by flora on 6/15/2017.
 */
public class ResponseReader {

    public static String getResponseString(HttpsURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e) {
            //Error reading InputStream
            result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    //Error closing InputStream
                }
            }
        }

        return result;
    }
}
