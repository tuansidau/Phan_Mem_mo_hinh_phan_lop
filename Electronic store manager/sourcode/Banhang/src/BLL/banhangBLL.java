/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author nngia
 */
import static BLL.thietbiBLL.sumArrtb;
import DAL.BanhangDAL;
import DAL.thietbiDAL;
import DTO.giohangDTO;
import DTO.hoadonDTO;
import DTO.thietbiDTO;
import java.util.ArrayList;

public class banhangBLL {
    public static ArrayList<giohangDTO> giohang = new ArrayList();
    public static ArrayList<hoadonDTO> hdArr; 
    thietbiBLL b = new thietbiBLL();
    BanhangDAL dal = new BanhangDAL();
    public banhangBLL(){b.docThietbi();};
    
    public void themGiohang(String id,int sl,float dongia,float tt){
        boolean check = false,checkLoai=false;
        if(giohang.size() != 0){
            for(giohangDTO a : giohang){
                if(a.getSp_id().equals(id)){
                    a.setSp_sl(a.getSp_sl()+sl);
                    a.setSp_thanhtien(a.getSp_thanhtien()+sl*a.getSp_dongia());
                    check = true;
                    break;
                }
            }
            if(check == false) giohang.add(new giohangDTO(id,sl,dongia,tt,checkLoai));
        }else{
            giohang.add(new giohangDTO(id,sl,dongia,tt,false));
        }
    }
    
    public void xoaGiohang(String id){
        giohangDTO spxoa = new giohangDTO();
        for(giohangDTO a : giohang){
            if(a.getSp_id().equals(id)) spxoa = a;
        }
        giohang.remove(spxoa);
    }
    
    public boolean isEnable(String id){
        for(giohangDTO a : giohang){
            if(a.getSp_id().equals(id)) return a.isEnable();
        }
        return false;
    }
    
    public void suaDongia(String id,int gia){
        for(giohangDTO a : giohang){
            if(a.getSp_id().equals(id)){
                a.setSp_dongia(gia);
                a.setSp_thanhtien(a.getSp_sl()*gia);
                break;
            }
        }
    }
    
    public void suaSl(String id,int sl){
        for(giohangDTO a : giohang){
            if(a.getSp_id().equals(id)){
                a.setSp_sl(sl);
                a.setSp_thanhtien(a.getSp_thanhtien()+sl*a.getSp_dongia());
                break;
            }
        }
    }
    
    public void updateKho(int id,int sl){
        thietbiDAL tbdal = new thietbiDAL();
        for(thietbiDTO a : sumArrtb){
            if(a.getSp_id() == id){
                a.setSp_daban(a.getSp_daban()+sl);
                a.setSp_tonkho(a.getSp_tonkho()-sl);
                tbdal.updateTonkho(a.getSp_tonkho(), id);
                tbdal.updateSlban(a.getSp_daban(), id);
                break;
            }
        }
    }

    public void thanhtoan(int idkh,String ngaylap,String ngnhan,String giao,String dc,float tongtien,String ghichu){
        BanhangDAL dal = new BanhangDAL();
        int idhd = dal.getID();
        dal.themHd(idhd, ngaylap, idkh, ngnhan, dc, giao, tongtien, ghichu);
        for(giohangDTO a : giohang){
            dal.themdetailHd(idhd, Integer.parseInt(a.getSp_id()),a.getSp_sl(), a.getSp_dongia(), tongtien);
            updateKho(Integer.parseInt(a.getSp_id()),a.getSp_sl());
        }
        giohang.removeAll(giohang);
    }
    
    public void docHd(){
        BanhangDAL dal = new BanhangDAL();
        hdArr = dal.docHd();
    }
    
}
