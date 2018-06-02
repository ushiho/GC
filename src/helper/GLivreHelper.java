/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.GLivre;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author ushiho
 */
public class GLivreHelper extends AbstractHelper<GLivre>{
    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Date Enregistrement", "dateEnregistrement"),
            new AbstractHelperItem("Entreprise", "entreprise"),
            new AbstractHelperItem("N°Piece", "nPiece"),
            new AbstractHelperItem("Libelle", "libelleReference"),
            new AbstractHelperItem("Credit", "montantCredit"),
            new AbstractHelperItem("Debit", "montantDebit"),
            new AbstractHelperItem("solde", "solde")
        };
    }

    public GLivreHelper(JTable jTable, List<GLivre> list) {
        super(titres, jTable, list);
    }

    public GLivreHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public GLivreHelper(JTable jTable) {
        super(titres, jTable);
    }
}
