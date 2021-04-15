
package DTO;

public class TourDTO {
    String tour_ten,tour_mota;
    int tour_id,loai_id;

    public TourDTO(int tour_id, String tour_ten, String tour_mota, int loai_id) {
        this.tour_ten = tour_ten;
        this.tour_mota = tour_mota;
        this.tour_id = tour_id;
        this.loai_id = loai_id;
    }
    public TourDTO(){}
    public String getTour_ten() {
        return tour_ten;
    }

    public void setTour_ten(String tour_ten) {
        this.tour_ten = tour_ten;
    }

    public String getTour_mota() {
        return tour_mota;
    }

    public void setTour_mota(String tour_mota) {
        this.tour_mota = tour_mota;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getLoai_id() {
        return loai_id;
    }

    public void setLoai_id(int loai_id) {
        this.loai_id = loai_id;
    }
    
}
