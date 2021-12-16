/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HUYENKUTE
 */
@Embeddable
public class ChiTietGianGiaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_HANG")
    private int maHang;
    @Basic(optional = false)
    @Column(name = "MA_GIAM")
    private String maGiam;

    public ChiTietGianGiaPK() {
    }

    public ChiTietGianGiaPK(int maHang, String maGiam) {
        this.maHang = maHang;
        this.maGiam = maGiam;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(String maGiam) {
        this.maGiam = maGiam;
    }

}
