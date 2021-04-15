/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChiphiDAL;
import DTO.ChiphiDTO;
import DTO.LoaichiphiDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChiphiBLL {
    public static ArrayList<ChiphiDTO> sumArrChiphi; 
    public static ArrayList<LoaichiphiDTO> sumArrLoai; 
    ChiphiDAL dal = new ChiphiDAL();
        
    public ChiphiBLL()
    {
        sumArrChiphi = new ArrayList<ChiphiDTO>();
        sumArrLoai = new ArrayList<LoaichiphiDTO>();
    }
    
    public void docChiphi()
    {
        sumArrChiphi = dal.docChiphi();      
    }
    public void docLoai()
    {
        sumArrLoai = dal.docLoaichiphi();      
    }
    public void themChiphi(ChiphiDTO object)
    {
        sumArrChiphi.add(object);
        dal.themChiphi(object);        
    }
    public void suaChiphi(ChiphiDTO object)
    {
        dal.suaChiphi(object);
        for(ChiphiDTO a : sumArrChiphi)
        {
            if(a.getDoan_id() == object.getDoan_id())
            {
                a.setChiphi_chitiet(object.getChiphi_chitiet());
                a.setChiphi_total(object.getChiphi_total());
                break;
            }
        }
    }
}
