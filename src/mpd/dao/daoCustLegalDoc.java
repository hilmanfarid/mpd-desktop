package mpd.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.DBConnection;
import mpd.model.CustLegalDoc;

public class daoCustLegalDoc{

    Connection connection;
    public int t_customer_order_id_search;
    public int size_per_page=15;
    public String order_and_limit=" order by t_cust_order_legal_doc_id DESC LIMIT ? OFFSET ? ";
    final String insert = "INSERT INTO t_cust_order_legal_doc (nomer, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE t_cust_order_legal_doc set nomer=?, nama=?, alamat=? where id=? ;";
    final String delete = "DELETE FROM t_cust_order_legal_doc where id=? ;";
    final String select = "SELECT t_cust_order_legal_doc.*,p_legal_doc_type.code as doc_code from t_cust_order_legal_doc"
            + " left join p_legal_doc_type on p_legal_doc_type.p_legal_doc_type_id = t_cust_order_legal_doc.p_legal_doc_type_id"
            + " where t_customer_order_id = ?";
                    
    final String carinama = "SELECT * FROM t_cust_order_legal_doc where nama like ?";

    public daoCustLegalDoc() {
        connection = DBConnection.openConnection();
    }

    public void insert(CustLegalDoc b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            /*statement.setString(1, b.getNomer());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());*/
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setT_cust_order_legal_doc_id(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update(CustLegalDoc b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
           /* statement.setString(1, b.getNomer());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());
            statement.setInt(4, b.getId());*/
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<CustLegalDoc> getALL(int start, int limit, String orderby, String ordertype) {
        List<CustLegalDoc> lb = null;
        try {
            lb = new ArrayList<CustLegalDoc>();
            PreparedStatement st = connection.prepareStatement(select+order_and_limit);
            st.setInt(1, t_customer_order_id_search);
            st.setInt(2, limit);
            st.setInt(3, ((start-1)*limit));
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CustLegalDoc b = new CustLegalDoc();
                b.setT_cust_order_legal_doc_id(rs.getInt("t_cust_order_legal_doc_id"));
                b.setT_customer_order_id(rs.getInt("t_customer_order_id"));
                b.setP_legal_doc_type_id(rs.getInt("p_legal_doc_type_id"));
                b.setDoc_code(rs.getString("doc_code"));
                b.setLegal_doc_desc(rs.getString("legal_doc_desc"));
                b.setOrigin_file_name(rs.getString("origin_file_name"));
                b.setFile_folder(rs.getString("file_folder"));
                b.setFile_name(rs.getString("file_name"));
                b.setDescription(rs.getString("description"));
                b.setUpdated_date(rs.getDate("updated_date"));
                b.setUpdated_by(rs.getString("updated_by"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoCustLegalDoc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    public int getCount(){
        try {
            PreparedStatement st = connection.prepareStatement("select count(*) from ("+select+")");
            st.setInt(1, t_customer_order_id_search);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(daoCustLegalDoc.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
