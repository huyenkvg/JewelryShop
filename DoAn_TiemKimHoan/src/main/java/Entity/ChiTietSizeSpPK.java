/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HUYENKUTE
 */
@Embeddable
public class ChiTietSizeSpPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MA_SP")
    private int maSp;
    @Basic(optional = false)
    @Column(name = "SIZE")
    private int size;

    public ChiTietSizeSpPK() {
    }

    public ChiTietSizeSpPK(int maSp, int size) {
        this.maSp = maSp;
        this.size = size;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
    	
        this.maSp = maSp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maSp;
        hash += (int) size;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietSizeSpPK)) {
            return false;
        }
        ChiTietSizeSpPK other = (ChiTietSizeSpPK) object;
        if (this.maSp != other.maSp) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietSizeSpPK[ maSp=" + maSp + ", size=" + size + " ]";
    }
    
}
