/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.ResultSet;
import java.util.List;
import mpd.dao.daoVatSettlement;
import mpd.lib.PaginationVatSettlement;
import mpd.model.VatSettlement;

/**
 *
 * @author Admin
 */
public class TesModel {
    public static void main(String args[]) {
        daoVatSettlement sett = new daoVatSettlement();
        System.out.println(sett.getCount());
        /*sett.size_per_page=15;
        PaginationVatSettlement pag = new PaginationVatSettlement(sett);
        List<VatSettlement> res = pag.nextPage();
        for (VatSettlement temp : res) {
                System.out.println(temp.gettotal_vat_amount());
		System.out.println(temp.gettotal_penalty_amount());
	}*/
    }
}
