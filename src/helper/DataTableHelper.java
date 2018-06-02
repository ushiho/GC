/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.DataTable;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author ushiho
 */
public class DataTableHelper extends AbstractHelper<DataTable> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Date","dateEntre"),
            new AbstractHelperItem("N°Piece","nPiece"),
            new AbstractHelperItem("Libelle","libelle"),
            new AbstractHelperItem("Entreprise","entreprise"),
            new AbstractHelperItem("Compte","numCompte"),
            new AbstractHelperItem("intitulé","intitule"),
            new AbstractHelperItem("Débit","montantDebit"),
            new AbstractHelperItem("Crédit","montantCredit")

        };
    }

    public DataTableHelper(JTable jTable, List<DataTable> list) {
       super(titres, jTable, list);
    }

    public DataTableHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public DataTableHelper(JTable jTable) {
        super(titres, jTable);
    }
}
