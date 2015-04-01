/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Admin
 */
public class DeleteDoc {
    private final String CrLf = "\r\n";
    String user_name;
    public DeleteDoc(String user_name) {
        this.user_name = user_name;
    }
    public void httpConn(int t_cust_order_legal_doc_id) {
        URLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url;
            String param_t_cust_order_legal_doc_id = String.valueOf(t_cust_order_legal_doc_id);

            url = new URL("http://localhost:81/mpd-wp/server/ws.php?type=json&module=bds&class=upload_doc_local&method=destroy");

            conn = url.openConnection();
            conn.setDoOutput(true);

            String postData = "";
            //InputStream imgIs = getClass().getResourceAsStream("C://bg-yanjak.jpg");


            System.out.println("open os");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=---------------------------4664151417711");
            conn.setRequestProperty("Content-Length", "10000000");
            os = conn.getOutputStream();
            
            String content ="user=tes_ah";  
             //////////add param post header here///////////////////////////////////////////
            String json = "\""
                    +param_t_cust_order_legal_doc_id
                    + "\"";
            
            String param_items = CrLf;
            param_items += "-----------------------------4664151417711" + CrLf;
            param_items += "Content-Disposition: form-data; name=\"items\"; "
                    + CrLf;
            param_items += CrLf;
            param_items += json;
            /////////////////////////////////////////////////////////////////////////////////
            // SEND THE IMAGE
 
            os.write(param_items.getBytes());
            //////////////////////////////////////////////
            os.flush();

            System.out.println("open is");
            is = conn.getInputStream();
            
            char buff = 1024;
            int len;
            byte[] data = new byte[buff];
            do {
                System.out.println("READ");
                len = is.read(data);

                if (len > 0) {
                    System.out.println(new String(data, 0, len));
                }
            } while (len > 0);

            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Close connection");
            try {
                os.close();
            } catch (Exception e) {
            }
            try {
                is.close();
            } catch (Exception e) {
            }
            try {

            } catch (Exception e) {
            }
        }
    }
}
