package DTO;

public class ChitietTourDTO {
    int tour_id,ct_thutu,ct_id,dd_id;

    public ChitietTourDTO(int ct_id, int tour_id, int ct_thutu, int dd_id) {
        this.tour_id = tour_id;
        this.ct_thutu = ct_thutu;
        this.ct_id = ct_id;
        this.dd_id = dd_id;
    }

    public ChitietTourDTO() {
    }
    
    public int gettour_id() {
        return tour_id;
    }

    public void settour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getCt_thutu() {
        return ct_thutu;
    }

    public void setCt_thutu(int ct_thutu) {
        this.ct_thutu = ct_thutu;
    }

    public int getCt_id() {
        return ct_id;
    }

    public void setCt_id(int ct_id) {
        this.ct_id = ct_id;
    }

    public int getDd_id() {
        return dd_id;
    }

    public void setDd_id(int dd_id) {
        this.dd_id = dd_id;
    }
}
