/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "LOAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loai.findAll", query = "SELECT l FROM Loai l")})
public class Loai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_LOAI")
    private String maLoai;
    @Column(name = "TEN_LOAI")
    private String tenLoai;
    @OneToMany(mappedBy = "maLoai")
    private Collection<ChiTietSanPham> chiTietSanPhamCollection;

    public Loai() {
    }

    public Loai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @XmlTransient
    public Collection<ChiTietSanPham> getChiTietSanPhamCollection() {
        return chiTietSanPhamCollection;
    }

    public void setChiTietSanPhamCollection(Collection<ChiTietSanPham> chiTietSanPhamCollection) {
        this.chiTietSanPhamCollection = chiTietSanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoai != null ? maLoai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loai)) {
            return false;
        }
        Loai other = (Loai) object;
        if ((this.maLoai == null && other.maLoai != null) || (this.maLoai != null && !this.maLoai.equals(other.maLoai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Loai[ maLoai=" + maLoai + " ]";
    }
    
}
