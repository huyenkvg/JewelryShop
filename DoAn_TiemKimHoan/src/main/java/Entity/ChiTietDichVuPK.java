/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HUYENKUTE
 */
@Embeddable
public class ChiTietDichVuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_HD")
    private int maHd;
    @Basic(optional = false)
    @Column(name = "MA_DICH_VU")
    private int maDichVu;
    @Basic(optional = false)
    @Column(name = "NGAY_SD")
    @Temporal(TemporalType.DATE)
    private Date ngaySd;

    public ChiTietDichVuPK() {
    }

    public ChiTietDichVuPK(int maHd, int maDichVu, Date ngaySd) {
        this.maHd = maHd;
        this.maDichVu = maDichVu;
        this.ngaySd = ngaySd;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public Date getNgaySd() {
        return ngaySd;
    }

    public void setNgaySd(Date ngaySd) {
        this.ngaySd = ngaySd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maHd;
        hash += (int) maDichVu;
        hash += (ngaySd != null ? ngaySd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDichVuPK)) {
            return false;
        }
        ChiTietDichVuPK other = (ChiTietDichVuPK) object;
        if (this.maHd != other.maHd) {
            return false;
        }
        if (this.maDichVu != other.maDichVu) {
            return false;
        }
        if ((this.ngaySd == null && other.ngaySd != null) || (this.ngaySd != null && !this.ngaySd.equals(other.ngaySd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietDichVuPK[ maHd=" + maHd + ", maDichVu=" + maDichVu + ", ngaySd=" + ngaySd + " ]";
    }
    
}
