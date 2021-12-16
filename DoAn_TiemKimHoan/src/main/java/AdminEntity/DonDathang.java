/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "DON_DATHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonDathang.findAll", query = "SELECT d FROM DonDathang d")})
public class DonDathang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_DH")
    private Integer maDh;
    @Column(name = "MA_GIAM_GIA")
    private String maGiamGia;
    @Column(name = "DIA_CHI")
    private String diaChi;
    @Basic(optional = false)
    @Column(name = "MA_KHACH_HANG")
    private String maKhachHang;
    @Column(name = "PHUONG_THUC")
    private Boolean phuongThuc;
    @Basic(optional = false)
    @Column(name = "NGAY")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donDathang")
    private Collection<ChiTietDathang> chiTietDathangCollection;
    @OneToMany(mappedBy = "maDh")
    private Collection<HoaDon> hoaDonCollection;

    public DonDathang() {
    }

    public DonDathang(Integer maDh) {
        this.maDh = maDh;
    }

    public DonDathang(Integer maDh, String maKhachHang, Date ngay) {
        this.maDh = maDh;
        this.maKhachHang = maKhachHang;
        this.ngay = ngay;
    }

    public DonDathang(Integer maDh, String maGiamGia, String maKhachHang, Boolean phuongThuc, Date ngay) {
		super();
		this.maDh = maDh;
		this.maGiamGia = maGiamGia;
		this.maKhachHang = maKhachHang;
		this.phuongThuc = phuongThuc;
		this.ngay = ngay;
	}

	public Integer getMaDh() {
        return maDh;
    }

    public void setMaDh(Integer maDh) {
        this.maDh = maDh;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Boolean getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(Boolean phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    @XmlTransient
    public Collection<ChiTietDathang> getChiTietDathangCollection() {
        return chiTietDathangCollection;
    }

    public void setChiTietDathangCollection(Collection<ChiTietDathang> chiTietDathangCollection) {
        this.chiTietDathangCollection = chiTietDathangCollection;
    }

    @XmlTransient
    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDh != null ? maDh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonDathang)) {
            return false;
        }
        DonDathang other = (DonDathang) object;
        if ((this.maDh == null && other.maDh != null) || (this.maDh != null && !this.maDh.equals(other.maDh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DonDathang[ maDh=" + maDh + " ]";
    }
    
}
