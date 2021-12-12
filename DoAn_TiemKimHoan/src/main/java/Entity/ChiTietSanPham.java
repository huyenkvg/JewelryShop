/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "CHI_TIET_SAN_PHAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietSanPham.findAll", query = "SELECT c FROM ChiTietSanPham c")})
public class ChiTietSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MA_SP")
    private Integer maSp;
    @Column(name = "TEN_SP")
    private String tenSp;
    @Column(name = "MO_TA")
    private String moTa;
    @Column(name = "ANH")
    private String anh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chiTietSanPham")
    private Collection<ChiTietSizeSp> chiTietSizeSpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chiTietSanPham")
    private Collection<ChiTietDathang> chiTietDathangCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chiTietSanPham")
    private Collection<DanhGia> danhGiaCollection;
    @JoinColumn(name = "MA_LOAI", referencedColumnName = "MA_LOAI")
    @ManyToOne
    private Loai maLoai;
    public void setLoai(String ml) {

    	maLoai = new Loai();
    	maLoai.setMaLoai(ml);
	}
    public String getLoai()
    {
    	return maLoai.getMaLoai();
    }
    public ChiTietSanPham() {
    	maLoai = new Loai();
    }

    public ChiTietSanPham(Integer maSp) {

    	maLoai = new Loai();
    	this.maSp = maSp;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @XmlTransient
    public Collection<ChiTietSizeSp> getChiTietSizeSpCollection() {
        return chiTietSizeSpCollection;
    }

    public void setChiTietSizeSpCollection(Collection<ChiTietSizeSp> chiTietSizeSpCollection) {
        this.chiTietSizeSpCollection = chiTietSizeSpCollection;
    }

    @XmlTransient
    public Collection<ChiTietDathang> getChiTietDathangCollection() {
        return chiTietDathangCollection;
    }

    public void setChiTietDathangCollection(Collection<ChiTietDathang> chiTietDathangCollection) {
        this.chiTietDathangCollection = chiTietDathangCollection;
    }

    @XmlTransient
    public Collection<DanhGia> getDanhGiaCollection() {
        return danhGiaCollection;
    }

    public void setDanhGiaCollection(Collection<DanhGia> danhGiaCollection) {
        this.danhGiaCollection = danhGiaCollection;
    }

    public Loai getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loai maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSp != null ? maSp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietSanPham)) {
            return false;
        }
        ChiTietSanPham other = (ChiTietSanPham) object;
        if ((this.maSp == null && other.maSp != null) || (this.maSp != null && !this.maSp.equals(other.maSp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietSanPham[ maSp=" + maSp + " ]";
    }
    
}
