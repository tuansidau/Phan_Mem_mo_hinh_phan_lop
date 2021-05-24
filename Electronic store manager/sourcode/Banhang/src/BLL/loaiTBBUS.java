package BLL;


import java.util.ArrayList;
import DTO.loaiDTO;
import DAL.loaiTBDAO;


public class loaiTBBUS {
    loaiTBDAO dAO = new loaiTBDAO();
    private ArrayList<loaiDTO> dsloai; 

    public ArrayList<loaiDTO> docdsloai(){
        return dsloai = dAO.docloai();
    }
    
    public ArrayList<String> dsloai(){
        docdsloai();
        ArrayList<String> kq = new ArrayList<String>();
        for(loaiDTO loai : dsloai){
            kq.add(loai.getLoai_ten());   
        }
        return kq;
    }
    
    public String getTenloai(int id){
        docdsloai();
        for(loaiDTO loai : dsloai){
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
