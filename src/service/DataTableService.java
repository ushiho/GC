/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.CompteTransaction;
import bean.DataTable;
import bean.Entreprise;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class DataTableService {

    public DataTable add(CompteTransaction compteTransaction) {
        DataTable dataTable = new DataTable(compteTransaction.getLibelleReference(), compteTransaction.getCompte().getLibelle(), compteTransaction.getEntreprise().getNumSecuriteSiege(), "" + compteTransaction.getnPiece(),
                 compteTransaction.getCompte().getCategorie().getClasse().getNum() + "" + compteTransaction.getCompte().getCategorie().getNum() + "" + compteTransaction.getCompte().getNum(), compteTransaction.getDateEnregistrement());
        if (compteTransaction.getType() == 1) {
            dataTable.setMontantCredit(compteTransaction.getMontant());
            dataTable.setType(1);
        }
        if (compteTransaction.getType() == 2) {
            dataTable.setMontantDebit(compteTransaction.getMontant());
            dataTable.setType(2);
        }
        dataTable.setUtilisateur(compteTransaction.getUtilisateur());
        dataTable.setNumTransaction(compteTransaction.getNumTransaction());
        return dataTable;
    }

    public List<CompteTransaction> formatLigneToCompteTransaction(List<DataTable> donnes) {
        if (donnes != null && !donnes.isEmpty()) {
            List<CompteTransaction> compteTransactions = new ArrayList();
            CompteServices compteServices = new CompteServices();
            EntrepriseServices entrepriseServices = new EntrepriseServices();
            for (int i = 0; i < donnes.size(); i++) {
                DataTable ligne = donnes.get(i);
                Compte compte = compteServices.findCompteByLibelle(ligne.getIntitule());
                Entreprise entreprise = entrepriseServices.findEntreprise(ligne.getEntreprise());
                CompteTransaction compteTransaction = new CompteTransaction(ligne.getDateEntre(), ligne.getLibelle(), ligne.getnPiece(), ligne.getType());
                compteTransaction.setCompte(compte);
                compteTransaction.setNumTransaction(ligne.getNumTransaction());
                compteTransaction.setEntreprise(entreprise);
                compteTransaction.setUtilisateur(ligne.getUtilisateur());
                if (ligne.getType() == 2) {
                    compteTransaction.setMontant(ligne.getMontantDebit());
                }
                if (ligne.getType() == 1) {
                    compteTransaction.setMontant(ligne.getMontantCredit());
                }
                compteTransactions.add(compteTransaction);
            }
            return compteTransactions;
        }
        return null;
    }
}
