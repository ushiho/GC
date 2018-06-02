/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ushiho
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numSecuriteSocial;
    private String nome;
    private String prenome;
    private int sexe;//1 : f 2 : h
    private String email;
    private String cin;
    private String tel;
    private double salaire;
    private int poste;
    private String nBureau;
    private String login;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEmbauche;

    public Utilisateur(String nSS, String nome, String prenome, int sexe, String email, String cin, String tel, double salaire, int poste, String nBureau, String login, String password, Date dateEmbauche) {
        this.numSecuriteSocial = nSS;
        this.nome = nome;
        this.prenome = prenome;
        this.sexe = sexe;
        this.email = email;
        this.cin = cin;
        this.tel = tel;
        this.salaire = salaire;
        this.poste = poste;
        this.nBureau = nBureau;
        this.login = login;
        this.password = password;
        this.dateEmbauche = dateEmbauche;
    }

    public Utilisateur() {
    }

    public Utilisateur(Long id) {
        this.id = id;
    }

    public String getNumSecuriteSocial() {
        return numSecuriteSocial;
    }

    public void setNumSecuriteSocial(String numSecuriteSocial) {
        this.numSecuriteSocial = numSecuriteSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public int getPoste() {
        return poste;
    }

    public void setPoste(int poste) {
        this.poste = poste;
    }

    public String getnBureau() {
        return nBureau;
    }

    public void setnBureau(String nBureau) {
        this.nBureau = nBureau;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", numSecuriteSocial=" + numSecuriteSocial + ", nome=" + nome + ", prenome=" + prenome + ", sexe=" + sexe + ", email=" + email + ", cin=" + cin + ", tel=" + tel + ", salaire=" + salaire + ", poste=" + poste + ", nBureau=" + nBureau + ", login=" + login + ", password=" + password + ", dateEmbauche=" + dateEmbauche + '}';
    }

}
