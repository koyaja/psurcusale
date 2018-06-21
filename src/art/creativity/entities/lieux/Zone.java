/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.entities.lieux;

import java.io.Serializable;


/**
 *
 * @author Geraud
 */
public class Zone implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idZone;
    private String nomination;
    private double longitude;
    private double latitude;
    private double atitude;
    private Ville ville;

    public Long getIdZone() {
        return idZone;
    }

    public void setIdZone(Long idZone) {
        this.idZone = idZone;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }    

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAtitude() {
		return atitude;
	}

	public void setAtitude(double atitude) {
		this.atitude = atitude;
	}

	public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Zone(String nomination, double logitude, double lagitude, Ville ville) {
        this.nomination = nomination;
        this.longitude = logitude;
        this.latitude = lagitude;
        this.ville = ville;
    }

    public Zone() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZone != null ? idZone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idZone fields are not set
        if (!(object instanceof Zone)) {
            return false;
        }
        Zone other = (Zone) object;
        if ((this.idZone == null && other.idZone != null) || (this.idZone != null && !this.idZone.equals(other.idZone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madrojudi.reservationminuteweb.entities.lieux.Zone[ id=" + idZone + " ]";
    }
    
}
