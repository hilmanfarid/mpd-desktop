/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.lib;

import java.util.List;
import mpd.dao.daoCustLegalDoc;
import mpd.model.CustLegalDoc;

/**
 *
 * @author Admin
 */
public class PaginationCustLegalDoc {
    private daoCustLegalDoc dao;
    private int page_now;
    public int total_data;
    public PaginationCustLegalDoc(daoCustLegalDoc thisdao){
        this.page_now=1;
        this.dao = thisdao;
        this.total_data = dao.getCount();
    }
    public List<CustLegalDoc> nextPage(){
        if(page_now > Math.floor(total_data/this.dao.size_per_page)){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now+1;
        List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_order_legal_doc_id", "DESC");
        //List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(0, 15, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustLegalDoc> lastPage(){
        if(page_now > Math.floor(total_data/this.dao.size_per_page)){
            System.out.println(page_now);
            return null;
        }
        page_now=(int)Math.ceil((float)total_data/getDao().size_per_page);
        List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustLegalDoc> prevPage(){
        if(page_now <= 1){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now-1;
        List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_order_legal_doc_id", "DESC");
        //List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(0, 15, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustLegalDoc> firstPage(){
        if(page_now <= 1){
            System.out.println(page_now);
            return null;
        }
        page_now=1;
        List<CustLegalDoc> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public daoCustLegalDoc getDao(){
        return this.dao;
    }
    public int getCurrentPage(){
        return this.page_now;
    }
}
