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
@Table(name = "DICH_VU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DichVu.findAll", query = "SELECT d FROM DichVu d")})
public class DichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_DICH_VU")
    private Integer maDichVu;
    @Column(name = "TEN_DICH_VU")
    private String tenDichVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dichVu")
    private Collection<ChiTietDichVu> chiTietDichVuCollection;

    public DichVu() {
    }

    public DichVu(Integer maDichVu) {
        this.maDichVu = maDichVu;
    }


	public Integer getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(Integer maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    @XmlTransient
    public Collection<ChiTietDichVu> getChiTietDichVuCollection() {
        return chiTietDichVuCollection;
    }

    public void setChiTietDichVuCollection(Collection<ChiTietDichVu> chiTietDichVuCollection) {
        this.chiTietDichVuCollection = chiTietDichVuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDichVu != null ? maDichVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DichVu)) {
            return false;
        }
        DichVu other = (DichVu) object;
        if ((this.maDichVu == null && other.maDichVu != null) || (this.maDichVu != null && !this.maDichVu.equals(other.maDichVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DichVu[ maDichVu=" + maDichVu + " ]";
    }
    
}
