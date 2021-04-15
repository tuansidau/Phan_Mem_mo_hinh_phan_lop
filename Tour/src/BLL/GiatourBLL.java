package BLL;


import DAL.DiadiemDAL;
import DAL.GiaTourDAL;
import java.util.ArrayList;
import DTO.TourDTO;
import DAL.TourDAL;
import DTO.DiadiemDTO;
import DTO.GiaTourDTO;

public class GiatourBLL {
    public ArrayList<GiaTourDTO> dsgia; 
    private GiaTourDAL data = new GiaTourDAL();
    
    public ArrayList<GiaTourDTO> docdsgia(){
        return data.docgia();
    }

    public boolean them(GiaTourDTO gia){
        if (data.them(gia)){
            return true;
        }
        return false;
    }
    
    public boolean sua(GiaTourDTO gia){
        if (data.sua(gia)){
            return true;
        }
        return false;
    }
    
    public boolean xoa(int id){
        if (data.xoa(id)){
            return true;
        }
        return false;
    }
}
