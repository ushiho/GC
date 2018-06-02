/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ushiho
 */
@Entity
public class CompteTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    private Utilisateur utilisateur;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnregistrement;
    private String libelleReference;
    private String nPiece;
    @OneToOne
    private Entreprise entreprise;
    @ManyToOne
    private Compte compte;
    private double montant;
    private double montantTotal;
    private int type;
    private long numTransaction;

    private void generateNumTransaction(){
        
    }
    public CompteTransaction(Long id) {
        this.id = id;
    }

    public CompteTransaction() {
    }

    public CompteTransaction(Date dateEnregistrement, String libelleReference, double montant, String nPiece, int type) {
        this.dateEnregistrement = dateEnregistrement;
        this.libelleReference = libelleReference;
        this.nPiece = nPiece;
        this.montant = montant;
        this.type = type;
    }

    public CompteTransaction(Date dateEnregistrement, String libelleReference, String nPiece, int type) {
        this.dateEnregistrement = dateEnregistrement;
        this.libelleReference = libelleReference;
        this.nPiece = nPiece;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(long numTransaction) {
        this.numTransaction = numTransaction;
    }

    public Utilisateur getUtilisateur() {
        if (utilisateur == null) {
            utilisateur = new Utilisateur();
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getLibelleReference() {
        return libelleReference;
    }

    public void setLibelleReference(String libelleReference) {
        this.libelleReference = libelleReference;
    }

    public String getnPiece() {
        return nPiece;
    }

    public void setnPiece(String nPiece) {
        this.nPiece = nPiece;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final CompteTransaction other = (CompteTransaction) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompteTransaction{" + "id=" + id + ", dateEnregistrement=" + dateEnregistrement + ", libelleReference=" + libelleReference + ", nPiece=" + nPiece + ", montant=" + montant + ", montantTotal=" + montantTotal + ", type=" + type + ", numTransaction=" + numTransaction + '}';
    }

    
   
}
