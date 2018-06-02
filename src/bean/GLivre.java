/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author ushiho
 */
public class GLivre {

    private double montantCredit;
    private double montantDebit;
    private double solde;
    private Date dateEnregistrement;
    private String entreprise;
    private String nPiece;
    private String libelleReference;
    private int numCompte;
    private String intitule;

    public GLivre() {
    }

    

    public double getMontantCredit() {
        return montantCredit;
    }

    public void setMontantCredit(double montantCredit) {
        this.montantCredit = montantCredit;
    }

    public double getMontantDebit() {
        return montantDebit;
    }

    public void setMontantDebit(double montantDebit) {
        this.montantDebit = montantDebit;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getnPiece() {
        return nPiece;
    }

    public void setnPiece(String nPiece) {
        this.nPiece = nPiece;
    }

    public String getLibelleReference() {
        return libelleReference;
    }

    public void setLibelleReference(String libelleReference) {
        this.libelleReference = libelleReference;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public String toString() {
        return "GrandLivre{" + "montantCredit=" + montantCredit + ", montantDebit=" + montantDebit + ", solde=" + solde + ", dateEnregistrement=" + dateEnregistrement + ", entreprise=" + entreprise + ", nPiece=" + nPiece + ", libelleReference=" + libelleReference + ", numCompte=" + numCompte + ", intitule=" + intitule + '}';
    }

}
