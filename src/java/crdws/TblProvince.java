/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crdws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Huy Nguyen
 */
@Entity
@Table(name = "tblProvince")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProvince.findAll", query = "SELECT t FROM TblProvince t")
    , @NamedQuery(name = "TblProvince.findByProvinceId", query = "SELECT t FROM TblProvince t WHERE t.provinceId = :provinceId")
    , @NamedQuery(name = "TblProvince.findByProvinceName", query = "SELECT t FROM TblProvince t WHERE t.provinceName = :provinceName")
    , @NamedQuery(name = "TblProvince.findByPopulation", query = "SELECT t FROM TblProvince t WHERE t.population = :population")})
public class TblProvince implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ProvinceId")
    private Integer provinceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProvinceName")
    private String provinceName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Population")
    private long population;

    public TblProvince() {
    }

    public TblProvince(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public TblProvince(Integer provinceId, String provinceName, long population) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.population = population;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceId != null ? provinceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProvince)) {
            return false;
        }
        TblProvince other = (TblProvince) object;
        if ((this.provinceId == null && other.provinceId != null) || (this.provinceId != null && !this.provinceId.equals(other.provinceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crdws.service.TblProvince[ provinceId=" + provinceId + " ]";
    }
    
}
