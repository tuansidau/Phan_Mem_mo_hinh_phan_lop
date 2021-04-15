/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DoanDAL;
import DTO.DoanDTO;
import DTO.NguoidiDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class DoanBLL {
    public static ArrayList<DoanDTO> sumArrDoan; 
    public static ArrayList<NguoidiDTO> sumArrNguoidi; 
    public DoanDTO doanDTO;
    public NguoidiDTO nguoidiDTO;
    DoanDAL dal = new DoanDAL();
        
    public DoanBLL()
    {
        sumArrDoan = new ArrayList<DoanDTO>();
        sumArrNguoidi = new ArrayList<NguoidiDTO>();
    }
    
    public void docDoan()
    {
        sumArrDoan = dal.docDoan();      
    }
    
    public void docNguoidi()
    {
        sumArrNguoidi = dal.docNguoidi();      
    }
    
    public ArrayList<DoanDTO> search(String str, int index)
    {
        ArrayList<DoanDTO> result = new ArrayList <DoanDTO>();
        for(DoanDTO a : sumArrDoan)
        {
            if(index == 0)//all
            {
                if(a.getDoan_ten().toUpperCase().contains(str)  
                   || a.getDoan_ngaydi().toUpperCase().contains(str)
                   || a.getDoan_ngayve().toUpperCase().contains(str)
                   || a.getDoan_chitiet().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 1) {//ten
                if(a.getDoan_ten().toUpperCase().contains(str))                    
                {
                    result.add(a);
                }
            } else if (index == 2) {//ngaydi
                if( a.getDoan_ngaydi().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 3) {//ngayve
                if(a.getDoan_ngayve().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } else if (index == 4) {//chitiet
                if(a.getDoan_chitiet().toUpperCase().contains(str))
                {
                    result.add(a);
                }
            } 
        }
        return result;
    }
    
    public void themDoan(DoanDTO object)
    {
        sumArrDoan.add(object);
        dal.themDoan(object);        
    }
    
    public void themNguoidi(NguoidiDTO object)
    {
        sumArrNguoidi.add(object);
        dal.themNguoidi(object);        
    }
    public int getIdDoan()
    {
        int rs = 0;
        docDoan();
        int max = 0;
        if(sumArrDoan == null)
        {
            rs = 1;
        } else {
            for (DoanDTO a : sumArrDoan) 
            {
                max = Math.max(a.getDoan_id(), max);
            }
            rs = max + 1;
        }
        return rs;
    }
    
    public void suaDoan(DoanDTO object)
    {
        dal.suaDoan(object);
        for(DoanDTO a : sumArrDoan)
        {
            if(a.getDoan_id() == object.getDoan_id())
            {
                a.setDoan_ten(object.getDoan_ten());
                a.setDoan_ngaydi(object.getDoan_ngaydi());
                a.setDoan_ngayve(object.getDoan_ngayve());
                a.setDoan_chitiet(object.getDoan_chitiet());
                a.setTour_id(object.getTour_id());
                a.setGia_id(object.getGia_id());
                break;
            }
        }
    }
    public void suaNguoidi(NguoidiDTO object)
    {
        dal.suaNguoidi(object);
        for(NguoidiDTO a : sumArrNguoidi)
        {
            if(a.getDoan_id() == object.getDoan_id())
            {
                a.setNguoidi_dsnhanvien(object.getNguoidi_dsnhanvien());
                a.setNguoidi_dskhach(object.getNguoidi_dskhach());               
                break;
            }
        }
    }
    
    public void suaTrangthai(int id)
    {
        dal.suaTrangthai(id);
        for(DoanDTO a : sumArrDoan)
        {
            if(a.getDoan_id() == id)
            {
                a.setDoan_tinhtrang(true);
                break;
            }
        }
    }
    public void xoaDoan(int id)
    {
        dal.xoaDoan(id);
        for(DoanDTO a : sumArrDoan)
        {
            if(a.getDoan_id() == id)
            {
                sumArrDoan.remove(a);
                break;
            }
        }
    }
}
