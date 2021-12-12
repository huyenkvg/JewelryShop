/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "CHI_TIET_GIAN_GIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietGianGia.findAll", query = "SELECT c FROM ChiTietGianGia c")})
public class ChiTietGianGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietGianGiaPK chiTietGianGiaPK;
    @Column(name = "PHAN_TRAM_GIAM")
    private Integer phanTramGiam;
    @JoinColumn(name = "MA_GIAM", referencedColumnName = "MA_GIAM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KhuyenMai khuyenMai;

    public String getMaGiam() {
    	return khuyenMai.getMaGiam();
    }
    
    public void setMaGiam(String mg) {
    	khuyenMai.setMaGiam(mg);
    }
    
    public int getMaHang() {
    	return chiTietGianGiaPK.getMaHang();
    }
    
    public void setMaHang(int mg) {
    	chiTietGianGiaPK.setMaHang(mg);
    }
    
    public ChiTietGianGia() {
    	this.khuyenMai = new KhuyenMai();
    }

    public ChiTietGianGia(ChiTietGianGiaPK chiTietGianGiaPK) {

    	this.khuyenMai = new KhuyenMai();
        this.chiTietGianGiaPK = chiTietGianGiaPK;
    }

    public ChiTietGianGia(int maHang, String maGiam) {

    	this.khuyenMai = new KhuyenMai();
        this.chiTietGianGiaPK = new ChiTietGianGiaPK(maHang, maGiam);
    }

    public ChiTietGianGiaPK getChiTietGianGiaPK() {
        return chiTietGianGiaPK;
    }

    public void setChiTietGianGiaPK(ChiTietGianGiaPK chiTietGianGiaPK) {
        this.chiTietGianGiaPK = chiTietGianGiaPK;
    }

    public Integer getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Integer phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietGianGiaPK != null ? chiTietGianGiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietGianGia)) {
            return false;
        }
        ChiTietGianGia other = (ChiTietGianGia) object;
        if ((this.chiTietGianGiaPK == null && other.chiTietGianGiaPK != null) || (this.chiTietGianGiaPK != null && !this.chiTietGianGiaPK.equals(other.chiTietGianGiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietGianGia[ chiTietGianGiaPK=" + chiTietGianGiaPK + " ]";
    }
    
}
