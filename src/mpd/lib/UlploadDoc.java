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
public class UlploadDoc {
    private final String CrLf = "\r\n";
    String user_name;
    public UlploadDoc(String user_name) {
        this.user_name = user_name;
    }
    public void httpConn(int t_customer_order_id,int p_legal_doc_type_id,String legal_doc_desc,String file_name,String file_location,int t_cust_order_legal_doc_id) {
        URLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url;
            String param_t_cust_order_legal_doc_id = "";
            if(t_cust_order_legal_doc_id == 0){
                url = new URL("http://localhost:81/mpd-wp/server/ws.php?type=json&module=bds&class=upload_doc_local&method=create");
                System.out.println("url:" + url);
            }else{
                url = new URL("http://localhost:81/mpd-wp/server/ws.php?type=json&module=bds&class=upload_doc_local&method=update");
                param_t_cust_order_legal_doc_id = String.valueOf(t_cust_order_legal_doc_id);
                System.out.println("url:" + url);
            }
            conn = url.openConnection();
            conn.setDoOutput(true);

            String postData = "";
            File initialFile = new File(file_location);
            InputStream imgIs = new FileInputStream(initialFile);
            //InputStream imgIs = getClass().getResourceAsStream("C://bg-yanjak.jpg");
            byte[] imgData = new byte[imgIs.available()];
            imgIs.read(imgData);

            String message1 = "";
            message1 += "-----------------------------4664151417711" + CrLf;
            message1 += "Content-Disposition: form-data; name=\"uploadedfile\"; filename=\""+initialFile.getName()+"\""
                    + CrLf;
            message1 += "Content-Type: multipart/form-data" + CrLf;
            message1 += CrLf;

            // the image is sent between the messages in the multipart message.

            String message2 = "";
            message2 += CrLf + "-----------------------------4664151417711--"
                    + CrLf;

            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=---------------------------4664151417711");
            // might not need to specify the content-length when sending chunked
            // data.
            conn.setRequestProperty("Content-Length", String.valueOf((message1
                    .length() + message2.length() + imgData.length)));
            String content ="user=tes_ah";  
            
            System.out.println("open os");
            os = conn.getOutputStream();

            System.out.println(message1);
             //////////add param post header here///////////////////////////////////////////
            String param_t_customer_order_id = CrLf;
            param_t_customer_order_id += "-----------------------------4664151417711" + CrLf;
            param_t_customer_order_id += "Content-Disposition: form-data; name=\"t_customer_order_id\"; "
                    + CrLf;
            param_t_customer_order_id += CrLf;
            param_t_customer_order_id += t_customer_order_id;

            
            String param_p_legal_doc_type_id = CrLf;
            param_p_legal_doc_type_id += "-----------------------------4664151417711" + CrLf;
            param_p_legal_doc_type_id += "Content-Disposition: form-data; name=\"p_legal_doc_type_id\"; "
                    + CrLf;
            param_p_legal_doc_type_id += CrLf;
            param_p_legal_doc_type_id += p_legal_doc_type_id;
            
            String param_legal_doc_desc = CrLf;
            param_legal_doc_desc += "-----------------------------4664151417711" + CrLf;
            param_legal_doc_desc += "Content-Disposition: form-data; name=\"legal_doc_desc\"; "
                    + CrLf;
            param_legal_doc_desc += CrLf;
            param_legal_doc_desc += legal_doc_desc;

            String json = "{"
                    + "\"t_cust_order_legal_doc_id\":"+param_t_cust_order_legal_doc_id+","
                    + "\"t_customer_order_id\": "+t_customer_order_id+","
                    + "\"p_legal_doc_type_id\":\""+p_legal_doc_type_id+"\","
                    + "\"legal_doc_desc\":\""+legal_doc_desc+"\","
                    + "\"origin_file_name\":\"\","
                    + "\"file_folder\":\"var\","
                    + "\"file_name\":\""+file_name+"\","
                    + "\"user_name\":\""+this.user_name+"\""
                    + "}";
            
            String param_items = CrLf;
            param_items += "-----------------------------4664151417711" + CrLf;
            param_items += "Content-Disposition: form-data; name=\"items\"; "
                    + CrLf;
            param_items += CrLf;
            param_items += json;
            /////////////////////////////////////////////////////////////////////////////////
            os.write(message1.getBytes());

            // SEND THE IMAGE
            int index = 0;
            int size = 1024;
            do {
                System.out.println("write:" + index);
                if ((index + size) > imgData.length) {
                    size = imgData.length - index;
                }
                os.write(imgData, index, size);
                index += size;
            } while (index < imgData.length);
            System.out.println("written:" + index);

            System.out.println(message2);
            os.write(message2.getBytes());
            //////////add param post here/////////////////
            os.write(param_t_customer_order_id.getBytes());
            os.write(param_p_legal_doc_type_id.getBytes());
            os.write(param_legal_doc_desc.getBytes());
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
