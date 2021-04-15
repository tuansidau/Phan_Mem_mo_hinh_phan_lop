
package DTO;

public class DiadiemDTO {
    String dd_ten,mota,dd_tp;
    int dd_id;

    public DiadiemDTO() {
    }

    public DiadiemDTO(int dd_id, String dd_tp, String dd_ten, String mota) {
        this.dd_ten = dd_ten;
        this.mota = mota;
        this.dd_tp = dd_tp;
        this.dd_id = dd_id;
    }
    
    public String getDd_ten() {
        return dd_ten;
    }

    public void setDd_ten(String dd_ten) {
        this.dd_ten = dd_ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDd_tp() {
        return dd_tp;
    }

    public void setDd_tp(String dd_tp) {
        this.dd_tp = dd_tp;
    }

    public int getDd_id() {
        return dd_id;
    }

    public void setDd_id(int dd_id) {
        this.dd_id = dd_id;
    }
    
}
