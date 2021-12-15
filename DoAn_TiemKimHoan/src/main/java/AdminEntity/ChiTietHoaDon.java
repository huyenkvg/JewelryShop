/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "CHI_TIET_HOA_DON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietHoaDon.findAll", query = "SELECT c FROM ChiTietHoaDon c")})
public class ChiTietHoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietHoaDonPK chiTietHoaDonPK;
    @Column(name = "SO_LUONG")
    private Integer soLuong;
    @Column(name = "GHI_CHU")
    private String ghiChu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GIA")
    private BigDecimal gia;
    @Column(name = "KHAU_TRU")
    private Integer khauTru;
    @JoinColumns({
        @JoinColumn(name = "SIZE", referencedColumnName = "MA_SP", insertable = false, updatable = false),
        @JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "SIZE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ChiTietSizeSp chiTietSizeSp;
    @JoinColumn(name = "MA_HOA_DON", referencedColumnName = "MA_HD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;

    public ChiTietHoaDon() {

    	chiTietHoaDonPK = new ChiTietHoaDonPK();
    	chiTietSizeSp = new ChiTietSizeSp();
    }

    public ChiTietHoaDon(ChiTietHoaDonPK chiTietHoaDonPK, Integer soLuong, BigDecimal gia, BigDecimal khautru,
			HoaDon hoaDon) {
		super();
		this.chiTietHoaDonPK = chiTietHoaDonPK;
		this.soLuong = soLuong;
		this.gia = gia;
		this.khauTru = khauTru;
		this.hoaDon = hoaDon;
	}

	public ChiTietHoaDon(ChiTietHoaDonPK chiTietHoaDonPK) {
        this.chiTietHoaDonPK = chiTietHoaDonPK;

    	chiTietSizeSp = new ChiTietSizeSp();
    }
    public ChiTietHoaDon(ChiTietHoaDonPK chiTietHoaDonPK, ChiTietSizeSp sp) {
    	this.chiTietSizeSp = sp;
    	this.gia = sp.getGia();
    	this.chiTietHoaDonPK = chiTietHoaDonPK;
    }

    public ChiTietHoaDon(int maSanPham, int maHoaDon, int size) {
        this.chiTietHoaDonPK = new ChiTietHoaDonPK(maSanPham, maHoaDon, size);
    }

    public ChiTietHoaDonPK getChiTietHoaDonPK() {
        return chiTietHoaDonPK;
    }

    public void setChiTietHoaDonPK(ChiTietHoaDonPK chiTietHoaDonPK) {
        this.chiTietHoaDonPK = chiTietHoaDonPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    public Integer getSize() {
    	return chiTietHoaDonPK.getSize();
    }
    
    public void setSize(Integer s) {
    	
    	this.chiTietHoaDonPK.setSize(s);
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getKhauTru() {
        return khauTru;
    }

    public void setKhauTru(Integer khauTru) {
        this.khauTru = khauTru;
    }

    public ChiTietSizeSp getChiTietSizeSp() {
        return chiTietSizeSp;
    }

    public void setChiTietSizeSp(ChiTietSizeSp chiTietSizeSp) {
    	
        this.chiTietSizeSp = chiTietSizeSp;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    public int getMaSp() {
    	return chiTietHoaDonPK.getMaSanPham();
    }
    
    public void setMaSp(int x) {
    	this.chiTietHoaDonPK.setMaSanPham(x);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietHoaDonPK != null ? chiTietHoaDonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDon)) {
            return false;
        }
        ChiTietHoaDon other = (ChiTietHoaDon) object;
        if ((this.chiTietHoaDonPK == null && other.chiTietHoaDonPK != null) || (this.chiTietHoaDonPK != null && !this.chiTietHoaDonPK.equals(other.chiTietHoaDonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietHoaDon[ chiTietHoaDonPK=" + chiTietHoaDonPK + " ]";
    }
    
}
