package post;

/*
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MetodoPOST {
    public static void main(String args[]) {
        HttpClient client = new HttpClient();
        client.getParams().setParameter("http.useragent", "");

        BufferedReader br = null;

        PostMethod method = new PostMethod("https://www.jesusninoc.com/getypost/examplepost.php");
        method.addParameter("nombre", "Juan");
        method.addParameter("edad", "34");

        try{
            int returnCode = client.executeMethod(method);
            if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
                System.err.println("Método POST no implementado");
                // still consume the response body
                method.getResponseBodyAsString();
            } else {
                br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
                String readLine;
                while(((readLine = br.readLine()) != null)) {
                    System.err.println(readLine);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
            if(br != null) try { br.close(); } catch (Exception fe) {}
        }
    }
}*/