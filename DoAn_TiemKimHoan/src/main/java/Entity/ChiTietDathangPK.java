/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HUYENKUTE
 */
@Embeddable
public class ChiTietDathangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_SAN_PHAM")
    private int maSanPham;
    @Basic(optional = false)
    @Column(name = "MA_DATHANG")
    private int maDathang;

    @Basic(optional = false)
    @Column(name = "SIZE")
    private Integer size;

    public ChiTietDathangPK() {
    }

    public ChiTietDathangPK(int maSanPham, int maDathang) {
        this.maSanPham = maSanPham;
        this.maDathang = maDathang;
    }
    
    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaDathang() {
        return maDathang;
    }

    public void setMaDathang(int maDathang) {
        this.maDathang = maDathang;
    }

    public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maSanPham;
        hash += (int) maDathang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDathangPK)) {
            return false;
        }
        ChiTietDathangPK other = (ChiTietDathangPK) object;
        if (this.maSanPham != other.maSanPham) {
            return false;
        }
        if (this.maDathang != other.maDathang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietDathangPK[ maSanPham=" + maSanPham + ", maDathang=" + maDathang + " ]";
    }
    
}
