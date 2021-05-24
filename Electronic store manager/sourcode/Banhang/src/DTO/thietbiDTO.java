/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HOANG MINH HUY
 */
public class thietbiDTO 
{
    public int sp_id;
    public String sp_ten;
    public int loai_id;
    public String sp_mota;
    public int sp_tonkho, sp_daban;
    public float sp_dongia;
  //  private byte[] ; 

    public thietbiDTO(int sp_id, String sp_ten, int loai_id, String sp_mota, int sp_tonkho, int sp_daban, float sp_dongia) {
        this.sp_id = sp_id;
        this.sp_ten = sp_ten;
        this.loai_id = loai_id;
        this.sp_mota = sp_mota;
        this.sp_tonkho = sp_tonkho;
        this.sp_daban = sp_daban;
        this.sp_dongia = sp_dongia;
    }

    public thietbiDTO(String sp_ten, int loai_id, String sp_mota, int sp_tonkho, int sp_daban, float sp_dongia) {
        this.sp_ten = sp_ten;
        this.loai_id = loai_id;
        this.sp_mota = sp_mota;
        this.sp_tonkho = sp_tonkho;
        this.sp_daban = sp_daban;
        this.sp_dongia = sp_dongia;
    }

    public thietbiDTO() {
    }

    public thietbiDTO(int sp_id) {
        this.sp_id = sp_id;
    }

    

    public String getSp_ten() {
        return sp_ten;
    }

    public String getSp_mota() {
        return sp_mota;
    }

//    public String getSp_img() {
//        return sp_img;
//    }

    public int getSp_id() {
        return sp_id;
    }

    public int getLoai_id() {
        return loai_id;
    }

    public int getSp_tonkho() {
        return sp_tonkho;
    }

    public int getSp_daban() {
        return sp_daban;
    }

    public float getSp_dongia() {
        return sp_dongia;
    }

    public void setSp_ten(String sp_ten) {
        this.sp_ten = sp_ten;
    }

    public void setSp_mota(String sp_mota) {
        this.sp_mota = sp_mota;
    }

//    public void setSp_img(String sp_img) {
//        this.sp_img = sp_img;
//    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public void setLoai_id(int loai_id) {
        this.loai_id = loai_id;
    }

    public void setSp_tonkho(int sp_tonkho) {
        this.sp_tonkho = sp_tonkho;
    }

    public void setSp_daban(int sp_daban) {
        this.sp_daban = sp_daban;
    }

    public void setSp_dongia(float sp_dongia) {
        this.sp_dongia = sp_dongia;
    }
       
}
