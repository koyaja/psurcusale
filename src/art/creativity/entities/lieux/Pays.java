/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.entities.lieux;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Geraud
 */
public class Pays implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPays;
    private String nomFR;
    private String nomEN;
    private String alpha2;
    private String codePays;
    private Collection<Ville> villes;

    public Integer getIdPays() {
        return idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }

    public String getNomFR() {
		return nomFR;
	}

	public void setNomFR(String nomFR) {
		this.nomFR = nomFR;
	}

	public String getNomEN() {
		return nomEN;
	}

	public void setNomEN(String nomEN) {
		this.nomEN = nomEN;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public Collection<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Collection<Ville> villes) {
        this.villes = villes;
    }


	public Pays(Integer idPays, String nomFR, String nomEN, String alpha2, String codePays, Collection<Ville> villes) {
		super();
		this.idPays = idPays;
		this.nomFR = nomFR;
		this.nomEN = nomEN;
		this.alpha2 = alpha2;
		this.codePays = codePays;
		this.villes = villes;
	}

	public Pays() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPays != null ? idPays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idPays fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.idPays == null && other.idPays != null) || (this.idPays != null && !this.idPays.equals(other.idPays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madrojudi.reservationminuteweb.entities.lieux.Pays[ id=" + idPays + " ]";
    }
    
}
