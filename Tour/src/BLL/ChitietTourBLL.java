package BLL;


import DAL.ChitietTourDAL;
import DAL.DiadiemDAL;
import java.util.ArrayList;
import DTO.TourDTO;
import DAL.TourDAL;
import DTO.ChitietTourDTO;
import DTO.DiadiemDTO;

public class ChitietTourBLL{
    private ArrayList<ChitietTourDTO> dsdetail; 
    private ChitietTourDAL data = new ChitietTourDAL();
 
    public ArrayList<ChitietTourDTO> docdsdetail(){
        return dsdetail = data.docDetail();
    }
    
    public String docdd(int id){
        String kq="";
        for(ChitietTourDTO ct : docdsdetail()){
            if(ct.gettour_id() == id){
                kq+=new DiadiemBLL().getTen(ct.getDd_id())+"-";
            }
        }
        return kq.substring(0,kq.length()-1);
    }

    public boolean them(ChitietTourDTO dd){
        if (data.them(dd)){
            return true;
        }
        return false;
    }
    
    public boolean sua(ChitietTourDTO dd){
        if (data.sua(dd)){
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
