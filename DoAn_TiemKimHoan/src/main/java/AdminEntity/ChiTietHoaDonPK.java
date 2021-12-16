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
public class ChiTietHoaDonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_SAN_PHAM")
    private int maSanPham;
    @Basic(optional = false)
    @Column(name = "MA_HOA_DON")
    private int maHoaDon;
    @Basic(optional = false)
    @Column(name = "SIZE")
    private int size;

    public ChiTietHoaDonPK() {
    }

    public ChiTietHoaDonPK(int maSanPham, int maHoaDon, int size) {
        this.maSanPham = maSanPham;
        this.maHoaDon = maHoaDon;
        this.size = size;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maSanPham;
        hash += (int) maHoaDon;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDonPK)) {
            return false;
        }
        ChiTietHoaDonPK other = (ChiTietHoaDonPK) object;
        if (this.maSanPham != other.maSanPham) {
            return false;
        }
        if (this.maHoaDon != other.maHoaDon) {
            return false;
        }
        if (this.size != other.size) {
        	return false;
        }
        return true;
    }

    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
    public String toString() {
        return "Entity.ChiTietHoaDonPK[ maSanPham=" + maSanPham + ", maHoaDon=" + maHoaDon + " ]";
    }
    
}
