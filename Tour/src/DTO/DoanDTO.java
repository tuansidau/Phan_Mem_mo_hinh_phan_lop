
package DTO;


public class DoanDTO {
    private int doan_id, tour_id, gia_id;
    private String doan_ten, doan_ngaydi, doan_ngayve, doan_chitiet;
    private boolean doan_tinhtrang;
    public DoanDTO()
    {}

    public DoanDTO(int doan_id) {
        this.doan_id = doan_id;
    }
    
    public DoanDTO(int doan_id, int tour_id, int gia_id, String doan_ten, String doan_ngaydi, String doan_ngayve, String doan_chitiet, boolean doan_tinhtrang) {
        this.doan_id = doan_id;
        this.tour_id = tour_id;
        this.gia_id = gia_id;
        this.doan_ten = doan_ten;
        this.doan_ngayve = doan_ngayve;
        this.doan_ngaydi = doan_ngaydi;
        this.doan_chitiet = doan_chitiet;
        this.doan_tinhtrang = doan_tinhtrang;
    }

    public DoanDTO(int doan_id, int tour_id, int gia_id, String doan_ten, String doan_ngaydi, String doan_ngayve, String doan_chitiet) {
        this.doan_id = doan_id;
        this.tour_id = tour_id;
        this.gia_id = gia_id;
        this.doan_ten = doan_ten;
        this.doan_ngaydi = doan_ngaydi;
        this.doan_ngayve = doan_ngayve;
        this.doan_chitiet = doan_chitiet;
    }

    public DoanDTO(int tour_id, int gia_id, String doan_ten, String doan_ngaydi, String doan_ngayve, String doan_chitiet) {
        this.tour_id = tour_id;
        this.gia_id = gia_id;
        this.doan_ten = doan_ten;
        this.doan_ngaydi = doan_ngaydi;
        this.doan_ngayve = doan_ngayve;
        this.doan_chitiet = doan_chitiet;
    }
    
    public int getDoan_id() {
        return doan_id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public int getGia_id() {
        return gia_id;
    }

    public String getDoan_ten() {
        return doan_ten;
    }

    public String getDoan_ngayve() {
        return doan_ngayve;
    }

    public String getDoan_ngaydi() {
        return doan_ngaydi;
    }

    public String getDoan_chitiet() {
        return doan_chitiet;
    }

    public void setDoan_id(int doan_id) {
        this.doan_id = doan_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public void setGia_id(int gia_id) {
        this.gia_id = gia_id;
    }

    public void setDoan_ten(String doan_ten) {
        this.doan_ten = doan_ten;
    }

    public void setDoan_ngayve(String doan_ngayve) {
        this.doan_ngayve = doan_ngayve;
    }

    public void setDoan_ngaydi(String doan_ngaydi) {
        this.doan_ngaydi = doan_ngaydi;
    }

    public void setDoan_chitiet(String doan_chitiet) {
        this.doan_chitiet = doan_chitiet;
    }

    public boolean isDoan_tinhtrang() {
        return doan_tinhtrang;
    }

    public void setDoan_tinhtrang(boolean doan_tinhtrang) {
        this.doan_tinhtrang = doan_tinhtrang;
    }
    
    public String formatTinhtrang()
    {
        if(isDoan_tinhtrang())
        {
            return "Đã nhập chi phí";
        } else {
            return "Chưa nhập chi phí";
        }
    }
}
