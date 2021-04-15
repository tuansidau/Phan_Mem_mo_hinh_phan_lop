package BLL;


import java.util.ArrayList;
import DTO.TourDTO;
import DAL.LoaiTourDAL;
import DTO.LoaiTourDTO;

public class LoaiTourBLL {
    LoaiTourDAL data = new LoaiTourDAL();
    private ArrayList<LoaiTourDTO> dsloai; 

    public ArrayList<LoaiTourDTO> docdsloai(){
        return dsloai = data.docloai();
    }
    
    public ArrayList<String> dsloai(){
        docdsloai();
        ArrayList<String> kq = new ArrayList<String>();
        for(LoaiTourDTO loai : dsloai){
            kq.add(loai.getLoai_ten());   
        }
        return kq;
    }
    
    public String getTenloai(int id){
        docdsloai();
        for(LoaiTourDTO loai : dsloai){
            if(loai.getLoai_id()==id) return loai.getLoai_ten();
        }
        return "Lỗi";
    }
    
    public void them(){
        
    }
    
    public void sua(){
        
    }
    
    public void xoa(){
        
    }
     
    public void timkiem(){
        
    }
}
