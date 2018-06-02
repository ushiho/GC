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
public class DataTable {

    private String libelle;
    private String intitule;
    private String entreprise;
    private String nPiece;
    private String numCompte;
    private double montantDebit;
    private double montantCredit;
    private Date dateEntre;
    private int type;
    private Utilisateur utilisateur;
    private long numTransaction ;
    public DataTable() {
    }

    public DataTable(String Libelle, String intitule, String entreprise, String nPiece, String numCompte, Date dateEntre) {
        this.libelle = Libelle;
        this.intitule = intitule;
        this.entreprise = entreprise;
        this.nPiece = nPiece;
        this.numCompte = numCompte;
        this.dateEntre = dateEntre;
    }

    public DataTable(String libelle, String intitule, String entreprise, String nPiece, String numCompte, Double montantDebit, Double montantCredit, Date dateEntre) {
        this.libelle = libelle;
        this.intitule = intitule;
        this.entreprise = entreprise;
        this.nPiece = nPiece;
        this.numCompte = numCompte;
        this.montantDebit = montantDebit;
        this.montantCredit = montantCredit;
        this.dateEntre = dateEntre;
    }

    public Utilisateur getUtilisateur() {
        if(utilisateur==null){
            utilisateur = new Utilisateur();
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String Entreprise) {
        this.entreprise = Entreprise;
    }

    public String getnPiece() {
        return nPiece;
    }

    public void setnPiece(String nPiece) {
        this.nPiece = nPiece;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public double getMontantDebit() {

        return montantDebit;
    }

    public void setMontantDebit(double montantDebit) {
        this.montantDebit = montantDebit;
    }

    public double getMontantCredit() {
        return montantCredit;
    }

    public void setMontantCredit(double montantCredit) {
        this.montantCredit = montantCredit;
    }

    public Date getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(long numTransaction) {
        this.numTransaction = numTransaction;
    }

    
    @Override
    public String toString() {
        return "DataTable{" + "libelle=" + libelle + ", intitule=" + intitule + ", entreprise=" + entreprise + ", nPiece=" + nPiece + ", numCompte=" + numCompte + ", montantDebit=" + montantDebit + ", montantCredit=" + montantCredit + ", dateEntre=" + dateEntre + ", type=" + type + ", utilisateur=" + utilisateur + '}';
    }

    

}
