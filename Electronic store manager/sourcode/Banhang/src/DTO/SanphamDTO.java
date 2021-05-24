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
public class SanphamDTO {
    int sp_id,loai_id,sp_daban,sp_tonkho;
    double sp_dongia;
    String ten_sp,sp_mota;
    public SanphamDTO(){};
    public SanphamDTO(int sp_id, String sp_ten,int loai_id, String sp_mota, int sp_tonkho,int sp_daban, double sp_dongia) {
        this.sp_id = sp_id;
        this.loai_id = loai_id;
        this.sp_daban = sp_daban;
        this.sp_tonkho = sp_tonkho;
        this.sp_dongia = sp_dongia;
        this.ten_sp = ten_sp;
        this.sp_mota = sp_mota;
    }

    public int getId_sp() {
        return sp_id;
    }

    public void setId_sp(int id_sp) {
        this.sp_id = id_sp;
    }

    public int getLoai_id() {
        return loai_id;
    }

    public void setLoai_id(int loai_id) {
        this.loai_id = loai_id;
    }

    public int getSp_daban() {
        return sp_daban;
    }

    public void setSp_daban(int sp_daban) {
        this.sp_daban = sp_daban;
    }

    public int getSp_tonkho() {
        return sp_tonkho;
    }

    public void setSp_tonkho(int sp_tonkho) {
        this.sp_tonkho = sp_tonkho;
    }

    public double getSp_dongia() {
        return sp_dongia;
    }

    public void setSp_dongia(double sp_dongia) {
        this.sp_dongia = sp_dongia;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getSp_mota() {
        return sp_mota;
    }

    public void setSp_mota(String sp_mota) {
        this.sp_mota = sp_mota;
    }
    
}
