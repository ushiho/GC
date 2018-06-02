/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Classe;
import bean.Compte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class CategorieServices extends AbstractFacade<Categorie> {

    public CategorieServices() {
        super(Categorie.class);
    }

    public int addCategorie(int num, String libelle, int numClasse) {

        int test = testCategorie(num, libelle, numClasse);
        if (test < 0) {
            return test;
        }
        ClasseServices serviceClasse = new ClasseServices();
        Classe resClasse = serviceClasse.findClasseByNum(numClasse);
        List<Compte> comptes = new ArrayList();
        if (resClasse == null) {
            return -2;
        }
        Categorie categorie = new Categorie(num, libelle);
        categorie.setComptes(comptes);
        categorie.setClasse(resClasse);
        create(categorie);
        List<Categorie> categories = resClasse.getCategories();
        categories.add(categorie);
        resClasse.setCategories(categories);
        serviceClasse.edit(resClasse);
        return 1;

    }

    public int modifyCategorie(int num, String libelle, String ancienLibelle) {
        Categorie resCategorie = findCategorieByLibelle(ancienLibelle);
        if (ancienLibelle == null || resCategorie == null) {
            return -1;
        } else if (resCategorie.getNum() == num) {
            return modifierLibelle(libelle, resCategorie);
        } else if (resCategorie.getLibelle().equals(libelle)) {
            return modifierId(num, resCategorie);
        } else {
            modifierId(num, resCategorie);
            modifierLibelle(libelle, resCategorie);
            return 1;
        }

    }

    public int modifierLibelle(String nvLibelle, Categorie categorie) {
        if (nvLibelle == null || categorie == null) {
            return -2;
        } else if (findCategorieByLibelle(nvLibelle) != null) {
            return -3;
        }
        categorie.setLibelle(nvLibelle);
        edit(categorie);
        return 1;
    }

    public int modifierId(int nvNum, Categorie categorie) {
        if (categorie == null) {
            return -4;
        } else if (findCategorieByNum(nvNum) != null) {
            return -5;
        } else {
            categorie.setNum(nvNum);
            edit(categorie);
            return 1;
        }

    }

    public int deleteCategorie(String libelle, int numClasse) {
        if (libelle == null) {
            return -1;
        } else {
            ClasseServices classeService = new ClasseServices();
            Classe classe = classeService.findClasseByNum(numClasse);
            Categorie categorieExist = findCategorieByLibelle(libelle);
            if (classe == null) {
                return -2;
            } else if (categorieExist == null) {
                return -3;
            } else {
                CompteServices compteServices = new CompteServices();
                List<Compte> comptes = categorieExist.getComptes();
                List<Categorie> categories = classe.getCategories();
                if (comptes == null || !comptes.isEmpty()) {
//                    compteServices.deleteComptesByCategorie(categorieExist);
                    for (int i = 0; i < comptes.size(); i++) {
                        Compte compte = comptes.get(i);
                        compteServices.remove(compte);
                    }
                    remove(categorieExist);
                    
                }
                categories.remove(categorieExist);
                classe.setCategories(categories);
                classeService.edit(classe);
                remove(categorieExist);

            }
            return 1;
        }
    }

    

    public List<Categorie> findCategoriesByCriteria(int num, String libelle, int numClasse) {
        String req = "select c from Categorie c where 1=1 ";
        if (num >= 0) {
            req += " and c.num = '" + num + "'";
        }
        if (libelle != null&&!libelle.equals("")) {
            req += " and c.libelle like '" + libelle + "'";
        }
        if (numClasse >= 0) {
            req += " and c.classe.num = '" + numClasse + "'";
        }
        return getEntityManager().createQuery(req).getResultList();
    }

    public Categorie findCategorieByLibelle(String libelle) {
        if (libelle == null) {
            return null;
        } else {
            List<Categorie> categories = findCategoriesByCriteria(-1, libelle, -1);
            for (int i = 0; i < categories.size(); i++) {
                Categorie categorie1 = categories.get(i);
                if (categorie1.getLibelle().equals(libelle)) {
                    return categorie1;
                }
            }
            return null;
        }
    }

    public Categorie findCategorieByNum(int num) {

        List<Categorie> categories = findCategoriesByCriteria(num, null, -1);
        for (int i = 0; i < categories.size(); i++) {
            Categorie categorie1 = categories.get(i);
            if (categorie1.getNum() == num) {
                return categorie1;
            }
        }
        return null;

    }

    public int testCategorie(int num, String libelle, int numClasse) {
        if (libelle == null) {
            return -1;
        }
        ClasseServices serviceClasse = new ClasseServices();
        Classe resClasse = serviceClasse.findClasseByNum(numClasse);
        Categorie resCategorieById = findCategorieByNum(num);
        Categorie resCategorieByLibelle = findCategorieByLibelle(libelle);

        if (resClasse == null) {
            return -2;
        } else if (resCategorieById != null&&resCategorieById.getClasse().getNum()==resClasse.getNum()) {
            return -3;
        } else if (resCategorieByLibelle != null) {
            //l'id ou la libelle existe deja dans la BD
            return -4;
        } else {
            return 1;
        }
    }

}
