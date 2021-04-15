/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanvienDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class NhanVienBLL {
    public static ArrayList<NhanvienDTO> sumArr; 
    public NhanvienDTO nhanvienDTO;
    NhanVienDAL dal = new NhanVienDAL();
        
    public NhanVienBLL()
    {
        sumArr = new ArrayList<NhanvienDTO>();
    }
    
    public void docNhanvien()
    {
        sumArr = dal.docNhanvien();      
    }
    
    public void themNhanvien(NhanvienDTO object)
    {
        sumArr.add(object);
        dal.themNhanvien(object);        
    }
    
    public void suaNhanvien(NhanvienDTO object)
    {
        dal.suaNhanvien(object);
        for(NhanvienDTO a : sumArr)
        {
            if(a.getNv_id() == object.getNv_id())
            {
                a.setNv_ten(object.getNv_ten());
                a.setNv_sdt(object.getNv_sdt());
                a.setNv_ngaysinh(object.getNv_ngaysinh());
                a.setNv_nhiemvu(object.getNv_nhiemvu());
                a.setNv_email(object.getNv_email());
                break;
            }
        }
    }
    
    public void xoaNhanvien(int id)
    {
        dal.xoaNhanvien(id);
        for(NhanvienDTO a : sumArr)
        {
            if(a.getNv_id() == id)
            {
                sumArr.remove(a);
                break;
            }
        }
    }
    public ArrayList<NhanvienDTO> search(String str, int index)
    {
        ArrayList<NhanvienDTO> result = new ArrayList <NhanvienDTO>();
        for(NhanvienDTO a : sumArr)
        {
            if(index == 0)//all
            {
                if(a.getNv_ten().toUpperCase().contains(str)  
                   || a.getNv_nhiemvu().toUpperCase().contains(str)
                   || a.getNv_sdt().toUpperCase().contains(str)
                   || a.getNv_email().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 1) {//ten
                if(a.getNv_ten().toUpperCase().contains(str))                    
                {
                    result.add(a);
                }
            } else if (index == 2) {//sdt
                if( a.getNv_sdt().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 3) {//nhiem vu
                if(a.getNv_nhiemvu().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 4) {//mail
                if(a.getNv_email().toUpperCase().contains(str))
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
        for(NhanvienDTO a : sumArr)
        {
            if(a.getNv_id() == id)
            {
                a.setNv_trangthai(trangthai);
                break;
            }
        }
    }
}
