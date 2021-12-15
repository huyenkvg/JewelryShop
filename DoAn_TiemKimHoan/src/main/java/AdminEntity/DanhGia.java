/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

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
@Table(name = "DANH_GIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhGia.findAll", query = "SELECT d FROM DanhGia d")})
public class DanhGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DanhGiaPK danhGiaPK;
    @Column(name = "DANH_GIA")
    private String danhGia;
    @Column(name = "DIEM_DANH_GIA")
    private Integer diemDanhGia;
    @JoinColumn(name = "MA_SP", referencedColumnName = "MA_SP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ChiTietSanPham chiTietSanPham;
    @JoinColumn(name = "MAHD", referencedColumnName = "MA_HD")
    @ManyToOne(optional = false)
    private HoaDon mahd;
    @JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "SDT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KhachHang khachHang;

    public DanhGia() {
    }

    public DanhGia(DanhGiaPK danhGiaPK) {
        this.danhGiaPK = danhGiaPK;
    }

    public DanhGia(String maKhachHang, int maSp) {
        this.danhGiaPK = new DanhGiaPK(maKhachHang, maSp);
    }

    public DanhGiaPK getDanhGiaPK() {
        return danhGiaPK;
    }

    public void setDanhGiaPK(DanhGiaPK danhGiaPK) {
        this.danhGiaPK = danhGiaPK;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public Integer getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(Integer diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public HoaDon getMahd() {
        return mahd;
    }

    public void setMahd(HoaDon mahd) {
        this.mahd = mahd;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (danhGiaPK != null ? danhGiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhGia)) {
            return false;
        }
        DanhGia other = (DanhGia) object;
        if ((this.danhGiaPK == null && other.danhGiaPK != null) || (this.danhGiaPK != null && !this.danhGiaPK.equals(other.danhGiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DanhGia[ danhGiaPK=" + danhGiaPK + " ]";
    }
    
}
