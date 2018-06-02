/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author ushiho
 */
@Entity
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numSecuriteSiege;
    private String cinChef;
    private String adresse;
    private String email;
    private String tel;

    public Entreprise() {
    }

    public Entreprise(Long id) {
        this.id = id;
    }

    public Entreprise(String numSecuriteSiege, String cinChef, String adresse, String email, String tel) {
        this.numSecuriteSiege = numSecuriteSiege;
        this.cinChef = cinChef;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
    }
    

    
    public String getCinChef() {
        return cinChef;
    }

    public void setCinChef(String cinChef) {
        this.cinChef = cinChef;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNumSecuriteSiege() {
        return numSecuriteSiege;
    }

    public void setNumSecuriteSiege(String numSecuriteSiege) {
        this.numSecuriteSiege = numSecuriteSiege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "" + numSecuriteSiege + "";
    }

   

}
