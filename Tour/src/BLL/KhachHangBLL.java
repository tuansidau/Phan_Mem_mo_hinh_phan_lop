/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.ArrayList;


public class KhachHangBLL {
    public static ArrayList<KhachHangDTO> sumArr; 
    public KhachHangDTO khachDTO;
    KhachHangDAL dal = new KhachHangDAL();
        
    public KhachHangBLL()
    {
        sumArr = new ArrayList<KhachHangDTO>();
    }
    
    public void docKhach()
    {
        sumArr = dal.docKhach();      
    }
    
    public void themKhach(KhachHangDTO object)
    {
        sumArr.add(object);
        dal.themKhach(object);        
    }
    
    public void suaKhach(KhachHangDTO object)
    {
        dal.suaKhach(object);
        for(KhachHangDTO a : sumArr)
        {
            if(a.getIdkh() == object.getIdkh())
            {
                a.setKh_ten(object.getKh_ten());
                a.setKh_sdt(object.getKh_sdt());
                a.setKh_ngaysinh(object.getKh_ngaysinh());
                a.setKh_ghichu(object.getKh_ghichu());
                a.setKh_cmnd(object.getKh_cmnd());
                a.setKh_email(object.getKh_email());
                break;
            }
        }
    }
    
    public ArrayList<KhachHangDTO> search(String str, int index)
    {
        ArrayList<KhachHangDTO> result = new ArrayList <KhachHangDTO>();
        for(KhachHangDTO a : sumArr)
        {
            if(index == 0)//all
            {
                if(a.getKh_ten().toUpperCase().contains(str)  
                   || a.getKh_cmnd().toUpperCase().contains(str)
                   || a.getKh_sdt().toUpperCase().contains(str)
                   || a.getKh_email().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 1) {//ten
                if(a.getKh_ten().toUpperCase().contains(str))                    
                {
                    result.add(a);
                }
            } else if (index == 2) {//sdt
                if( a.getKh_sdt().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 3) {//cmnd
                if(a.getKh_cmnd().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 4) {//mail
                if(a.getKh_email().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } 
        }
        return result;
    }
    public void suaTrangthai(int id, int trangthai)
    {
        dal.suaTrangthai(id, trangthai);
        for(KhachHangDTO a : sumArr)
        {
            if(a.getIdkh() == id)
            {
                a.setKh_trangthai(trangthai);
                break;
            }
        }
    }
}
