/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "TAI_KHOAN_DANG_NHAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoanDangNhap.findAll", query = "SELECT t FROM TaiKhoanDangNhap t")})
public class TaiKhoanDangNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_DANG_NHAP")
    private String maDangNhap;
    @Basic(optional = false)
    @Column(name = "MAT_KHAI")
    private String matKhai;
    @Basic(optional = false)
    @Column(name = "TRANG_THAI")
    private boolean trangThai;
    @JoinColumn(name = "MA_DANG_NHAP", referencedColumnName = "CMND", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NhanVien nhanVien;

    public TaiKhoanDangNhap() {
    }

    public TaiKhoanDangNhap(String maDangNhap) {
        this.maDangNhap = maDangNhap;
    }

    public TaiKhoanDangNhap(String maDangNhap, String matKhai, boolean trangThai) {
        this.maDangNhap = maDangNhap;
        this.matKhai = matKhai;
        this.trangThai = trangThai;
    }

    public String getMaDangNhap() {
        return maDangNhap;
    }

    public void setMaDangNhap(String maDangNhap) {
        this.maDangNhap = maDangNhap;
    }

    public String getMatKhai() {
        return matKhai;
    }

    public void setMatKhai(String matKhai) {
        this.matKhai = matKhai;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDangNhap != null ? maDangNhap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoanDangNhap)) {
            return false;
        }
        TaiKhoanDangNhap other = (TaiKhoanDangNhap) object;
        if ((this.maDangNhap == null && other.maDangNhap != null) || (this.maDangNhap != null && !this.maDangNhap.equals(other.maDangNhap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TaiKhoanDangNhap_1[ maDangNhap=" + maDangNhap + " ]";
    }
    
}
