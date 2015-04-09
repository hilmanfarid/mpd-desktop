package mpd.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.DBConnection;
import mpd.model.CustAccTrans;

public class daoCustAccTrans{

    Connection connection;
    public int p_vat_type_dtl_id_search;
    public int t_customer_order_id;
    public Date date_start_search;
    public Date date_end_search;
    public int size_per_page=10;
    public String order_and_limit=" order by t_cust_acc_dtl_trans_id DESC LIMIT ? OFFSET ? ";
    final String insert = "INSERT INTO t_cust_order_legal_doc (nomer, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE t_cust_order_legal_doc set nomer=?, nama=?, alamat=? where id=? ;";
    final String delete = "DELETE FROM t_cust_order_legal_doc where id=? ;";
    public String select = "SELECT\n" +
        "     to_char(trans_date, 'yyyy-mm-dd') AS trans_date,\n" +
        "     t_cust_acc_dtl_trans_id,\n" +
        "     sett.t_cust_account_id,\n" +
        "     bill_no,\n" +
        "     service_desc,\n" +
        "     service_charge,\n" +
        "     vat_charge,\n" +
        "     tbl.description,\n" +
        "     tbl.p_vat_type_dtl_id,\n" +
        "     p_finance_period.p_finance_period_id\n" +
        "FROM\n" +
        "     sikp.f_get_cust_acc_dtl_trans (?, NULL) AS tbl (t_cust_acc_dtl_trans_id)\n" +
        "left join t_vat_setllement sett on trunc(sett.start_period) <= trans_date and trunc(sett.end_period) <= trans_date\n"+
        "LEFT JOIN p_finance_period ON p_finance_period.p_finance_period_id = sett.p_finance_period_id\n" +
        "where sett.t_customer_order_id = ?";
    public Integer t_cust_account_id;
                    

    public daoCustAccTrans() {
        connection = DBConnection.openConnection();
    }

    public void insert(CustAccTrans b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            /*statement.setString(1, b.getNomer());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());*/
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setT_cust_acc_dtl_trans_id(rs.getInt(1));
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

    public void update(CustAccTrans b) {
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

    public List<CustAccTrans> getALL(int start, int limit, String orderby, String ordertype) {
        List<CustAccTrans> lb = null;
        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");



        try {
            lb = new ArrayList<CustAccTrans>();
            PreparedStatement st = connection.prepareStatement(select+order_and_limit);
            st.setInt(1, t_cust_account_id);
            st.setInt(2, this.t_customer_order_id);
            st.setInt(3, limit);
            st.setInt(4, ((start-1)*limit));
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CustAccTrans b = new CustAccTrans();
                b.setT_cust_acc_dtl_trans_id(rs.getInt("t_cust_acc_dtl_trans_id"));
                b.setService_desc(rs.getString("service_desc"));
                b.setTrans_date(rs.getDate("trans_date"));
                b.setDescription(rs.getString("description"));
                b.setBill_no(rs.getString("bill_no"));
                b.setService_charge(rs.getDouble("service_charge"));
                b.setVat_charge(rs.getDouble("vat_charge"));
                b.setP_vat_type_dtl_id(rs.getInt("p_vat_type_dtl_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoCustAccTrans.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    public int getCount(){
        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement st = connection.prepareStatement("select count(*) from ("+select+")");
            st.setInt(1, t_cust_account_id);
            st.setInt(2, this.t_customer_order_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(daoCustAccTrans.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
