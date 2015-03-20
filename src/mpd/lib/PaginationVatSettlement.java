/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.lib;

import java.sql.ResultSet;
import java.util.List;
import mpd.dao.daoVatSettlement;
import mpd.model.VatSettlement;

/**
 *
 * @author Admin
 */
public class PaginationVatSettlement {
    private daoVatSettlement dao;
    private int page_now;
    public int total_data;
    public PaginationVatSettlement(daoVatSettlement thisdao){
        this.page_now=1;
        this.dao = thisdao;
        this.total_data = dao.getCount();
    }
    public List<VatSettlement> nextPage(){
        if(page_now > Math.floor(total_data/this.dao.size_per_page)){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now+1;
        List<VatSettlement> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_vat_setllement_id", "DESC");
        //List<VatSettlement> rs_vat_setllement = this.dao.getALL(0, 15, "t_vat_setllement_id", "DESC");
        return rs_vat_setllement;
    }
    public List<VatSettlement> prevPage(){
        if(page_now <= 1){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now-1;
        List<VatSettlement> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_vat_setllement_id", "DESC");
        //List<VatSettlement> rs_vat_setllement = this.dao.getALL(0, 15, "t_vat_setllement_id", "DESC");
        return rs_vat_setllement;
    }
}
