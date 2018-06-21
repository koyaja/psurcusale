/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.entities.identities;

import java.io.Serializable;

/**
 *
 * @author Geraud
 */
public class Contact implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long idContact;
    private String motContact;
    private String contact;

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getMotContact() {
        return motContact;
    }

    public void setMotContact(String motContact) {
        this.motContact = motContact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
}
