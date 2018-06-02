/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CompteTransaction;
import bean.GLivre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class GLivreService {
    
    
    public List<GLivre> DataAsListe(List<CompteTransaction> compteTranAssoc){
        List<GLivre> lignes = new ArrayList();
        for (int i = 0; i < compteTranAssoc.size(); i++) {
            CompteTransaction compteTran = compteTranAssoc.get(i);
             GLivre ligne = new GLivre() ;
             ligne.setDateEnregistrement(compteTran.getDateEnregistrement());
             ligne.setEntreprise(compteTran.getEntreprise().getNumSecuriteSiege());
             ligne.setIntitule(compteTran.getCompte().getLibelle());
             ligne.setLibelleReference(compteTran.getLibelleReference());
             ligne.setNumCompte(compteTran.getCompte().getNum());
             ligne.setnPiece(compteTran.getnPiece());
             ligne.setMontantCredit(compteTran.getMontant());
             ligne.setMontantDebit(compteTran.getMontant());
             ligne.setSolde(compteTran.getMontant());
             lignes.add(ligne);
        }
        return lignes ;
    }
}
