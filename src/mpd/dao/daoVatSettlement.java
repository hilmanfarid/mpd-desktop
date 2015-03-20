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
import mpd.model.VatSettlement;

public class daoVatSettlement{

    Connection connection;
    public int t_cust_account_id_search;
    public int size_per_page=15;
    public String order_and_limit=" order by settlement.start_period DESC,settlement.t_vat_setllement_id DESC LIMIT ? OFFSET ? ";
    final String insert = "INSERT INTO VatSettlement (nomer, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE VatSettlement set nomer=?, nama=?, alamat=? where id=? ;";
    final String delete = "DELETE FROM VatSettlement where id=? ;";
    final String select = "SELECT\n" +
                    "     cust_order.t_customer_order_id AS t_customer_order_id,\n" +
                    "     settlement.*, \n" +
                    "		 period.code AS finance_period_code,\n" +
                    "     cust_order.order_no,\n" +
                    "     cust_order.p_rqst_type_id,\n" +
                    "     to_char(\n" +
                    "          settlement.settlement_date,\n" +
                    "          'yyyy-mm-dd'\n" +
                    "     ) AS settlement_date,\n" +
                    "     to_char(\n" +
                    "          settlement.start_period,\n" +
                    "          'yyyy-mm-dd'\n" +
                    "     ) AS start_period,\n" +
                    "     to_char(\n" +
                    "          settlement.end_period,\n" +
                    "          'yyyy-mm-dd'\n" +
                    "     ) AS end_period,\n" +
                    " to_char(\n" +
                    "			settlement.payment_due_day,\n" +
                    "			'dd-mm-yyyy HH24:mi:ss'\n" +
                    " ) AS pay_due_date\n" +
                    "FROM sikp.t_vat_setllement settlement\n" +
                    "		left join p_finance_period period on settlement.p_finance_period_id = period.p_finance_period_id\n" +
                    "		left join t_customer_order cust_order on cust_order.t_customer_order_id = settlement.t_customer_order_id\n" +
                    "		left join t_cust_account cust_acc on cust_acc.t_cust_account_id = settlement.t_cust_account_id\n"+
                    "where\n"+
                    "settlement.t_cust_account_id = ? \n" +
                    "--and settlement.p_settlement_type_id = 1\n";/* +
                    "and cust_order.p_order_status_id = 1\n" +
                    "and settlement.payment_key is not null\n" +
                    "and settlement.payment_key <> ''";*/
                    
    final String carinama = "SELECT * FROM VatSettlement where nama like ?";

    public daoVatSettlement() {
        connection = DBConnection.openConnection();
    }

    public void insert(VatSettlement b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            /*statement.setString(1, b.getNomer());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());*/
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.sett_vat_setllement_id(rs.getInt(1));
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

    public void update(VatSettlement b) {
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

    public List<VatSettlement> getALL(int start, int limit, String orderby, String ordertype) {
        List<VatSettlement> lb = null;
        try {
            lb = new ArrayList<VatSettlement>();
            PreparedStatement st = connection.prepareStatement(select+order_and_limit);
            st.setInt(1, t_cust_account_id_search);
            st.setInt(2, limit);
            st.setInt(3, ((start-1)*limit)+1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VatSettlement b = new VatSettlement();
                /*b.setId(rs.getInt("id"));
                b.setNomer(rs.getString("nomer"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));*/
                b.sett_vat_setllement_id(rs.getInt("t_vat_setllement_id"));
                b.sett_customer_order_id(rs.getInt("t_customer_order_id"));
                
                b.setsettlement_date(rs.getDate("settlement_date"));
                b.setp_finance_period_id(rs.getInt("p_finance_period_id"));
                b.sett_cust_account_id(rs.getInt("t_cust_account_id")); 
                b.setnpwd(rs.getString("npwd"));
                b.settotal_trans_amount(rs.getFloat("total_trans_amount"));
                b.settotal_vat_amount(rs.getFloat("total_vat_amount"));
                b.setp_settlement_type_id(rs.getInt("p_settlement_type_id"));
                b.setfinance_periode_code(rs.getString("finance_period_code"));
                b.settotal_penalty_amount(rs.getFloat("total_penalty_amount"));
                b.setpayment_key(rs.getString("payment_key"));
                b.setis_settled(rs.getString("is_settled"));
                b.setdue_date(rs.getDate("due_date"));
                b.setpayment_due_day(rs.getDate("payment_due_day"));
                b.setorder_no(rs.getString("order_no"));
                b.setcreation_date(rs.getDate("creation_date"));
                b.setcreated_by(rs.getString("created_by"));
                b.setupdated_date(rs.getDate("updated_date")); 
                b.setupdated_by(rs.getString("updated_by"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoVatSettlement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    public int getCount(){
        try {
            PreparedStatement st = connection.prepareStatement("select count(*) from ("+select+")");
            st.setInt(1, t_cust_account_id_search);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(daoVatSettlement.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
