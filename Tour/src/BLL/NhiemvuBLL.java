/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhiemvuDAL;
import DTO.NhiemvuDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class NhiemvuBLL {
    public static ArrayList<NhiemvuDTO> sumArr; 
    public NhiemvuDTO nvdto;
    NhiemvuDAL dal = new NhiemvuDAL();
        
    public NhiemvuBLL()
    {
        sumArr = new ArrayList<NhiemvuDTO>();
    }
    
    public void docNhiemvu()
    {
        sumArr = dal.docNhiemvu();      
    }
}
