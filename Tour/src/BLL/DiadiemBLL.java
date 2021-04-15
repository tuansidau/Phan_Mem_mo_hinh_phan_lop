package BLL;


import DAL.DiadiemDAL;
import java.util.ArrayList;
import DTO.TourDTO;
import DAL.TourDAL;
import DTO.DiadiemDTO;
import java.util.HashSet;

public class DiadiemBLL {
    private ArrayList<DiadiemDTO> dsdd; 
    private DiadiemDAL data = new DiadiemDAL();
    
    public ArrayList<DiadiemDTO> docdsdd(){
        return dsdd = data.docDsdd();
    }
    
    public ArrayList<String> docdstp(){
        HashSet<String> temp = new HashSet<String>();
        for(DiadiemDTO dd : docdsdd()){
            temp.add(dd.getDd_tp());
        }
        return new  ArrayList<String>(temp);
    }
    
    public ArrayList<String> docDsdd(String ten){
        ArrayList<String> kq  = new  ArrayList<String>();
        for(DiadiemDTO dd : docdsdd()){
            if(dd.getDd_tp().equals(ten)) kq.add(dd.getDd_ten());
        }
        return kq;
    }
    
    public String getTen(int id){
        return data.getTen(id);
    }
    
    public int getId(String ten){
        return data.getId(ten);
    }
    
    public boolean them(DiadiemDTO dd){
        if (data.them(dd)){
            return true;
        }
        return false;
    }
    
    public boolean sua(DiadiemDTO dd){
        if (data.sua(dd)){
            return true;
        }
        return false;
    }
    
    public String xoa(int id){
        if(!data.checkTour(id)){
            if (data.xoa(id)) return "Xóa thành công";
        }
        return "Còn tour! Kiểm tra lại!!!";
    }
     
    public  ArrayList<DiadiemDTO> timkiem(String s){
        ArrayList<DiadiemDTO> kq = new  ArrayList();
        for(DiadiemDTO dd : docdsdd()){
            if((dd.getDd_ten().indexOf(s) != -1) || (dd.getMota().indexOf(s) != -1) 
                    || (dd.getDd_tp().indexOf(s) != -1)) kq.add(dd);
        }
        return kq;
    }
}
