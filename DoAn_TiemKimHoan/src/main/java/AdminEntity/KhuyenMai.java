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
@Table(name = "KHUYEN_MAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhuyenMai.findAll", query = "SELECT k FROM KhuyenMai k")})
public class KhuyenMai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_GIAM")
    private String maGiam;
    @Basic(optional = false)
    @Column(name = "NGAY_BAT_DAU")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;
    @Basic(optional = false)
    @Column(name = "NGAY_KET_THUC")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khuyenMai")
    private Collection<ChiTietGianGia> chiTietGianGiaCollection;
    @OneToMany(mappedBy = "maGiamGia")
    private Collection<HoaDon> hoaDonCollection;

    public KhuyenMai() {
    }

    public KhuyenMai(String maGiam) {
        this.maGiam = maGiam;
    }

    public KhuyenMai(String maGiam, Date ngayBatDau, Date ngayKetThuc) {
        this.maGiam = maGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(String maGiam) {
        this.maGiam = maGiam;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @XmlTransient
    public Collection<ChiTietGianGia> getChiTietGianGiaCollection() {
        return chiTietGianGiaCollection;
    }

    public void setChiTietGianGiaCollection(Collection<ChiTietGianGia> chiTietGianGiaCollection) {
        this.chiTietGianGiaCollection = chiTietGianGiaCollection;
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
        hash += (maGiam != null ? maGiam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhuyenMai)) {
            return false;
        }
        KhuyenMai other = (KhuyenMai) object;
        if ((this.maGiam == null && other.maGiam != null) || (this.maGiam != null && !this.maGiam.equals(other.maGiam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.KhuyenMai[ maGiam=" + maGiam + " ]";
    }
    
}
