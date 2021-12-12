/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CHI_TIET_DATHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietDathang.findAll", query = "SELECT c FROM ChiTietDathang c")})
public class ChiTietDathang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ChiTietDathangPK chiTietDathangPK;
    @Column(name = "SO_LUONG")
    private Integer soLuong;
    @Column(name = "GHI_CHU")
    private String ghiChu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GIA")
    private BigDecimal gia;
    @JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ChiTietSanPham chiTietSanPham;
    @JoinColumn(name = "MA_DATHANG", referencedColumnName = "MA_DH", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DonDathang donDathang;

    
    
    public ChiTietDathang() {
    	chiTietSanPham = new ChiTietSanPham();
    	donDathang = new DonDathang();
    	chiTietDathangPK = new ChiTietDathangPK();
    }
    
	public void setMaDathang(int maDathang) {
    	chiTietSanPham = new ChiTietSanPham();
    	donDathang = new DonDathang();
		this.chiTietDathangPK.setMaDathang(maDathang);
	}
	public int getMaDathang() {
		return chiTietDathangPK.getMaDathang();
	}
	public void setMaSanPham(int masp) {
		this.chiTietDathangPK.setMaSanPham(masp);
	}
	public int getMaSanPham() {
		return chiTietDathangPK.getMaSanPham();
	}

	public ChiTietDathang(ChiTietDathangPK chiTietDathangPK) {
        this.chiTietDathangPK = chiTietDathangPK;
    }

    public ChiTietDathang(int maSanPham, int maDathang) {
        this.chiTietDathangPK = new ChiTietDathangPK(maSanPham, maDathang);
    }

    public ChiTietDathangPK getChiTietDathangPK() {
        return chiTietDathangPK;
    }

    public void setChiTietDathangPK(ChiTietDathangPK chiTietDathangPK) {
        this.chiTietDathangPK = chiTietDathangPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getSize() {
        return chiTietDathangPK.getSize();
    }

    public void setSize(Integer size) {
    
        this.chiTietDathangPK.setSize(size);
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public DonDathang getDonDathang() {
        return donDathang;
    }

    public void setDonDathang(DonDathang donDathang) {
        this.donDathang = donDathang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietDathangPK != null ? chiTietDathangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDathang)) {
            return false;
        }
        ChiTietDathang other = (ChiTietDathang) object;
        if ((this.chiTietDathangPK == null && other.chiTietDathangPK != null) || (this.chiTietDathangPK != null && !this.chiTietDathangPK.equals(other.chiTietDathangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietDathang[ chiTietDathangPK=" + chiTietDathangPK + " ]";
    }
    
}
