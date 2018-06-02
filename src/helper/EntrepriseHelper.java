/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Entreprise;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author ushiho
 */
public class EntrepriseHelper extends AbstractHelper<Entreprise> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("C.I.N de Chef", "cinChef"),
            new AbstractHelperItem("numero Securite_Siege", "numSecuriteSiege"),
            new AbstractHelperItem("Adresse", "adresse"),
            new AbstractHelperItem("Tel", "tel"),
            new AbstractHelperItem("E-mail", "email")
        };
    }

    public EntrepriseHelper(JTable jTable, List<Entreprise> list) {
        super(titres, jTable, list);
    }

    public EntrepriseHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public EntrepriseHelper(JTable jTable) {
        super(titres, jTable);
    }

}
