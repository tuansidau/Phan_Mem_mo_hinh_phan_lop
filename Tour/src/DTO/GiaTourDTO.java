
package DTO;

public class GiaTourDTO {
    int gia_id,tour_id;
    double gia_sotien;
    String gia_ngay;

    public GiaTourDTO(int gia_id, int tour_id, double gia_sotien, String gia_ngay) {
        this.gia_id = gia_id;
        this.tour_id = tour_id;
        this.gia_sotien = gia_sotien;
        this.gia_ngay = gia_ngay;
    }

    public GiaTourDTO() {
    }

    public int getGia_id() {
        return gia_id;
    }

    public void setGia_id(int gia_id) {
        this.gia_id = gia_id;
    }

    public int gettour_id() {
        return tour_id;
    }

    public void settour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public double getGia_sotien() {
        return gia_sotien;
    }

    public void setGia_sotien(double gia_sotien) {
        this.gia_sotien = gia_sotien;
    }

    public String getGia_ngay() {
        return gia_ngay;
    }

    public void setGia_ngay(String gia_ngay) {
        this.gia_ngay = gia_ngay;
    }
    
}
