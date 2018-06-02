/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Compte;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class CompteServices extends AbstractFacade<Compte> {

    public CompteServices() {
        super(Compte.class);
    }

    public int addCompte(int num, String libelle, int numCategorie) {
        if (libelle == null) {
            return -1;
        } else {
            CategorieServices serviceCategorie = new CategorieServices();
            Categorie resCategorie = serviceCategorie.findCategorieByNum(numCategorie);
           // Compte resComptesById = findCompteByNum(num);
            Compte resComptesByLibelle = findCompteByLibelle(libelle);
            if (resCategorie == null) {
                return -2;
            } else if (resComptesByLibelle != null) {
                return -4;
            } else {

                List<Compte> comptes = resCategorie.getComptes();
                Compte compte = new Compte(num, libelle);
                compte.setCategorie(resCategorie);
                create(compte);
                comptes.add(compte);
                resCategorie.setComptes(comptes);
                serviceCategorie.edit(resCategorie);
                return 1;
            }

        }
    }

    public int modify(int num, String libelle, String ancienLibelle) {
        Compte resCompte = findCompteByLibelle(ancienLibelle);
        if (libelle == null || ancienLibelle == null) {
            return -1;
        } else if (resCompte == null) {
            return -2;
        } else if (resCompte.getNum()==num) {
            return modifierLibelle(libelle, resCompte);
        } else if (resCompte.getLibelle().equals(libelle)) {
            return modifierId(num, resCompte);
        } else {
            modifierId(num, resCompte);
            modifierLibelle(libelle, resCompte);
            return 1;
        }

    }

    public int modifierLibelle(String nvLibelle, Compte compte) {
        if (nvLibelle == null || compte == null) {
            return -5;
        } else if (findCompteByLibelle(nvLibelle) != null) {
            return -6;
        }
        compte.setLibelle(nvLibelle);
        edit(compte);
        return 1;
    }

    public int modifierId(int nvNum, Compte compte) {
        if (compte == null) {
            return -3;
        } else if (findCompteByNum(nvNum) != null) {
            return -4;
        }
        compte.setNum(nvNum);
        edit(compte);
        return 1;
    }

    public int deleteCompte(String libelle, String libelleCategorie) {
        if (libelle == null || libelleCategorie == null) {
            return -1;
        } else {
            CategorieServices serviceCategorie = new CategorieServices();
            Categorie categorie = serviceCategorie.findCategorieByLibelle(libelleCategorie);
            Compte compte = findCompteByLibelle(libelle);
            if (categorie == null) {
                return -2;
            } else if (compte == null) {
                return -3;
            } else {
                List<Compte> comptes = categorie.getComptes();
                comptes.remove(compte);
                remove(compte);
                categorie.setComptes(comptes);
                serviceCategorie.edit(categorie);
                return 1;
            }
        }
    }

    public int deleteComptesByCategorie(Categorie categorie) {
        if (categorie == null) {
            return -1;
        } else {
            return getEntityManager().createQuery("delete from Compte c where c.categorie.idDB ='" + categorie.getId() + "'").executeUpdate();
        }
    }

    public List<Compte> findCompteByCriteria(int num, String libelle, int numCategorie) {
        String req = "select c from Compte c where 1=1";
        if (num >=0 ) {
            req += " and c.num = '" + num + "'";
        }
        if (libelle != null) {
            req += " and c.libelle like '" + libelle + "'";
        }
        if (numCategorie >=0 ) {
            req += " and c.categorie.num = '" + numCategorie + "'";
        }
        return getEntityManager().createQuery(req).getResultList();
    }

    public Compte findCompteByLibelle(String libelle) {
        if (libelle == null) {
            return null;
        }
        List<Compte> comptes = findCompteByCriteria(-1, libelle, -1);
        for (int i = 0; i < comptes.size(); i++) {
            Compte compte = comptes.get(i);
            if (compte.getLibelle().equals(libelle)) {
                return compte;
            }
        }
        return null;
    }

    public Compte findCompteByNum(int num) {
        List<Compte> comptes = findCompteByCriteria(num, null, -1);
        for (int i = 0; i < comptes.size(); i++) {
            Compte compte = comptes.get(i);
            if (compte.getNum()==num) {
                return compte;
            }
        }
        return null;
    }
    

}
