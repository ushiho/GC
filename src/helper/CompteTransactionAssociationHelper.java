/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.CompteTransactionAssociation;
import bean.Entreprise;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author ushiho
 */
public class CompteTransactionAssociationHelper extends AbstractHelper<CompteTransactionAssociation> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
           new AbstractHelperItem("JOR"),
            new AbstractHelperItem("Date"),
            new AbstractHelperItem("Compte"),
            new AbstractHelperItem("intitulé"),
            new AbstractHelperItem("N°Piece"),
            new AbstractHelperItem("Libelle"),
            new AbstractHelperItem("Débit"),
            new AbstractHelperItem("Crédit")
        };
    }

    public CompteTransactionAssociationHelper(JTable jTable, List<CompteTransactionAssociation> list) {
        super(titres, jTable, list);
    }
    public CompteTransactionAssociationHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public CompteTransactionAssociationHelper(JTable jTable) {
        super(titres, jTable);
    }
}
