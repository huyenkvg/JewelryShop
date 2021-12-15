/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Controller.QuanlyController;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "HOA_DON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NGAY")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MA_HD")
    private Integer maHd;
    @Basic(optional = false)
    @Column(name = "LOAI")
    private String loai;
    @Column(name = "PHUONG_THUC")
    private Boolean phuongThuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private Collection<ChiTietDichVu> chiTietDichVuCollection;
    @JoinColumn(name = "MA_DH", referencedColumnName = "MA_DH")
    @ManyToOne
    private DonDathang maDh;
    @JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "SDT")
    @ManyToOne(optional = false)
    private KhachHang maKhachHang;
    @JoinColumn(name = "MA_GIAM_GIA", referencedColumnName = "MA_GIAM")
    @ManyToOne
    private KhuyenMai maGiamGia;
    @JoinColumn(name = "MA_NV", referencedColumnName = "CMND")
    @ManyToOne(optional = false)
    private NhanVien maNv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mahd")
    private Collection<DanhGia> danhGiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private Collection<ChiTietHoaDon> chiTietHoaDonCollection;

    @Column(name = "TongTien")
    private BigDecimal tongTien;
    
    public BigDecimal  getTongTien() {
    	return tongTien;
    }
    
   

	public void setTongTien(BigDecimal  tongTien) {
		this.tongTien = tongTien;
	}

	public HoaDon() {
    	maDh = new DonDathang();
    	maKhachHang = new KhachHang();
    	loai = "Xuat";
    	maNv = new NhanVien();
    	maGiamGia = new KhuyenMai();
    }

    public HoaDon(Integer maHd) {
        this.maHd = maHd;
    }

    public HoaDon(Integer maHd, Date ngay, String loai) {
        this.maHd = maHd;
        this.ngay = ngay;
        this.loai = loai;
    }
    

    public HoaDon(Date ngay, Integer maHd, String loai, Boolean phuongThuc, DonDathang maDh, KhachHang maKhachHang,
			KhuyenMai maGiamGia, NhanVien maNv) {
		super();
		this.ngay = ngay;
		this.maHd = maHd;
		this.loai = loai;
		this.phuongThuc = phuongThuc;
		this.maDh = maDh;
		this.maKhachHang = maKhachHang;
		this.maGiamGia = maGiamGia;
		this.maNv = maNv;
	}

	public HoaDon(Date ngay, Integer maHd, String loai, Boolean phuongThuc,
			Collection<ChiTietDichVu> chiTietDichVuCollection, DonDathang maDh, KhachHang maKhachHang,
			KhuyenMai maGiamGia, NhanVien maNv, Collection<DanhGia> danhGiaCollection,
			Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
		super();
		this.ngay = ngay;
		this.maHd = maHd;
		this.loai = loai;
		this.phuongThuc = phuongThuc;
		this.chiTietDichVuCollection = chiTietDichVuCollection;
		this.maDh = maDh;
		this.maKhachHang = maKhachHang;
		this.maGiamGia = maGiamGia;
		this.maNv = maNv;
		this.danhGiaCollection = danhGiaCollection;
		this.chiTietHoaDonCollection = chiTietHoaDonCollection;
	}

	public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Integer getMaHd() {
        return maHd;
    }

    public void setMaHd(Integer ma) {
        this.maHd = ma;
    }
    public Integer getMaDh() {
    	return maDh.getMaDh();
    }
    
    public void setMaDh(Integer ma) {
    	maDh = new DonDathang();
    	this.maDh.setMaDh(ma);
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Boolean getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(Boolean phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    @XmlTransient
    public Collection<ChiTietDichVu> getChiTietDichVuCollection() {
        return chiTietDichVuCollection;
    }

    public void setChiTietDichVuCollection(Collection<ChiTietDichVu> chiTietDichVuCollection) {
        this.chiTietDichVuCollection = chiTietDichVuCollection;
    }
    
    public String getMaGiam() {
    	if(maGiamGia ==null) return null;
    	return maGiamGia.getMaGiam();
    }
    public String getMaNv() {
    	if(maNv == null) return null;
    	return maNv.getCmnd();
    }
    public String getMaKh() {
    	if(maKhachHang==null) return null;
    	return maKhachHang.getSdt();
    }
    public void setMaGiam(String x) {
    	maGiamGia.setMaGiam(x);
    }
    public void setMaNv(String x) {
    	maNv = new NhanVien();
    	maNv.setCmnd(x);
    }
    public void setMaKh(String x) {
    	maKhachHang = new KhachHang();
    	maKhachHang.setSdt(x);
    }
    
//
//    public DonDathang getMaDh() {
//        return maDh;
//    }
//
//    public void setMaDh(DonDathang maDh) {
//        this.maDh = maDh;
//    }

    public String getMaKhachHang() {
        return maKhachHang.getSdt();
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang.setSdt(maKhachHang);;
    }

    public KhuyenMai getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(KhuyenMai maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

 
//    public String getMaNv() {
//		return maNv.getCmnd();
//	}
//
//	public void setMaNv(String maNv) {
//		this.maNv.setCmnd(maNv);
//	}

	public String getCmnd() {
		if(maNv == null) return null;
    	return maNv.getCmnd();
    }
    
   

	public void setCmnd(String maNv) {
    	this.maNv.setCmnd(maNv);
    }

    @XmlTransient
    public Collection<DanhGia> getDanhGiaCollection() {
        return danhGiaCollection;
    }

    public void setDanhGiaCollection(Collection<DanhGia> danhGiaCollection) {
        this.danhGiaCollection = danhGiaCollection;
    }

    @XmlTransient
    public Collection<ChiTietHoaDon> getChiTietHoaDonCollection() {
        return chiTietHoaDonCollection;
    }

    public void setChiTietHoaDonCollection(Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
        this.chiTietHoaDonCollection = chiTietHoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHd != null ? maHd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHd == null && other.maHd != null) || (this.maHd != null && !this.maHd.equals(other.maHd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HoaDon[ maHd=" + maHd + " ]";
    }
    
}
