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
public class Ville implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idVille;
    private String nomVille;
    private String codeVille;
    private Pays pays;
    private Collection<Qtier> qtiers;

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getCodeVille() {
        return codeVille;
    }

    public void setCodeVille(String codeVille) {
        this.codeVille = codeVille;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }


    public Collection<Qtier> getQtiers() {
		return qtiers;
	}

	public void setQtiers(Collection<Qtier> qtiers) {
		this.qtiers = qtiers;
	}

	public Ville(String nomVille, Pays pays, String codeVille) {
        this.nomVille = nomVille;
        this.pays = pays;
        this.codeVille = codeVille;
    }

    public Ville() {
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVille != null ? idVille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idVille fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idVille == null && other.idVille != null) || (this.idVille != null && !this.idVille.equals(other.idVille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ville[ id=" + idVille + " nom="+nomVille+" paysParten="+pays+"]";
    }
    
}
