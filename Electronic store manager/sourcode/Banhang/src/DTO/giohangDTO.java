/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author nngia
 */
public class giohangDTO {
    String sp_id;
    float sp_dongia,sp_thanhtien;
    int sp_sl;
    boolean enable;
    
    public giohangDTO(String sp_id,int sp_sl,float sp_dongia, float sp_thanhtien,boolean enable) {
        this.sp_id = sp_id;
        this.sp_dongia = sp_dongia;
        this.sp_thanhtien = sp_thanhtien;
        this.sp_sl = sp_sl;
        this.enable = enable;
    }

    public giohangDTO(){}

    public String getSp_id() {
        return sp_id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public float getSp_dongia() {
        return sp_dongia;
    }

    public void setSp_dongia(float sp_dongia) {
        this.sp_dongia = sp_dongia;
    }

    public float getSp_thanhtien() {
        return sp_thanhtien;
    }

    public void setSp_thanhtien(float sp_thanhtien) {
        this.sp_thanhtien = sp_thanhtien;
    }

    public int getSp_sl() {
        return sp_sl;
    }

    public void setSp_sl(int sp_sl) {
        this.sp_sl = sp_sl;
    }
    
    
}
