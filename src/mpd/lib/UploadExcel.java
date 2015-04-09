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
public class UploadExcel {
    private final String CrLf = "\r\n";
    String user_name;
    public UploadExcel(String user_name) {
        this.user_name = user_name;
    }
    public void httpConn(int t_cust_account_id,String file_name,String file_location,int p_vat_type_dtl_id) {
        URLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url;
            url = new URL("http://localhost:81/mpd-wp/client/ws.php?type=json&module=bds&class=cust_acc_trans&method=uploadExcelLocal");
            System.out.println("url:" + url);
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
            message1 += "Content-Disposition: form-data; name=\"excel_trans_cust\"; filename=\""+initialFile.getName()+"\""
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
            String param_p_vat_type_dtl_id = CrLf;
            param_p_vat_type_dtl_id += "-----------------------------4664151417711" + CrLf;
            param_p_vat_type_dtl_id += "Content-Disposition: form-data; name=\"p_vat_type_dtl_id\"; "
                    + CrLf;
            param_p_vat_type_dtl_id += CrLf;
            param_p_vat_type_dtl_id += p_vat_type_dtl_id; 
            
            String param_t_cust_account_id = CrLf;
            param_t_cust_account_id += "-----------------------------4664151417711" + CrLf;
            param_t_cust_account_id += "Content-Disposition: form-data; name=\"t_cust_account_id\"; "
                    + CrLf;
            param_t_cust_account_id += CrLf;
            param_t_cust_account_id += t_cust_account_id;
            
            String param_user_name = CrLf;
            param_user_name += "-----------------------------4664151417711" + CrLf;
            param_user_name += "Content-Disposition: form-data; name=\"user_name\"; "
                    + CrLf;
            param_user_name += CrLf;
            param_user_name += user_name;
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
            os.write(param_t_cust_account_id.getBytes());
            os.write(param_p_vat_type_dtl_id.getBytes());
            os.write(param_user_name.getBytes());
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
