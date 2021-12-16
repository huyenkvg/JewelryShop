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
public class DanhGiaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_KHACH_HANG")
    private String maKhachHang;
    @Basic(optional = false)
    @Column(name = "MA_SP")
    private int maSp;

    public DanhGiaPK() {
    }

    public DanhGiaPK(String maKhachHang, int maSp) {
        this.maKhachHang = maKhachHang;
        this.maSp = maSp;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        hash += (int) maSp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhGiaPK)) {
            return false;
        }
        DanhGiaPK other = (DanhGiaPK) object;
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        if (this.maSp != other.maSp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DanhGiaPK[ maKhachHang=" + maKhachHang + ", maSp=" + maSp + " ]";
    }
    
}
