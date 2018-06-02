/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Classe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class ClasseServices extends AbstractFacade<Classe> {

    public ClasseServices() {
        super(Classe.class);
    }

    public int addClasse(int num, String libelle) {

        if (libelle == null) {
            return -1;
        } else {
            Classe resClasse = findClasseByNum(num);
            Classe resClasseByLibelle = findClasseByLibelle(libelle);
            List<Categorie> categories = new ArrayList();
            if (resClasse != null) {
                return -2;
            } else if (resClasseByLibelle != null) {
                return -3;
            }

            Classe classe = new Classe();
            classe.setNum(num);
            classe.setLibelle(libelle);
            classe.setCategories(categories);
            create(classe);
            return 1;

        }
    }

    public int modify(int num, String libelle, String ancienLibelle) {
        Classe resClasse = findClasseByLibelle(ancienLibelle);

        if (libelle == null || ancienLibelle == null) {
            return -1;
        } else if (resClasse == null) {
            return -2;
        }
        //il faut modifier les comptes puis les categorie D'abord!
        if (resClasse.getNum() == num) {
            //changer seulement libelle
            return modifierLibelle(libelle, resClasse);
        } else if (resClasse.getLibelle().equals(libelle)) {
            //changer seulement id
            return modifierId(num, resClasse);
        } else {
            //modifier tous

            modifierId(num, resClasse);
            return modifierLibelle(libelle, resClasse);
        }
    }

    public int modifierLibelle(String nvLibelle, Classe classe) {
        Classe resClasse = findClasseByLibelle(nvLibelle);
        if (classe == null || nvLibelle == null) {
            return -3;
        } else if (resClasse != null) {
            return -4;
        }
        classe.setLibelle(nvLibelle);
        edit(classe);
        return 1;
    }

    public int modifierId(int nvNum, Classe classe) {
        if (classe == null) {
            return -5;
        } else if (findClasseByNum(nvNum) != null) {
            return -6;
        } else {
            classe.setNum(nvNum);
            edit(classe);
            return 1;

        }
    }
//    public int modifierId() 

    public int delelteClasse(String libelle) {
        if (libelle == null) {
            return -1;
        }
        Classe classe = findClasseByLibelle(libelle);
        if (classe == null) {
            return -2;
        } else {
            List<Categorie> categories = classe.getCategories();
            CategorieServices categorieServices = new CategorieServices();
            if (categories != null || !categories.isEmpty()) {
                for (int i = 0; i < categories.size(); i++) {
                    Categorie categorie = categories.get(i);
                    categorieServices.deleteCategorie(categorie.getLibelle(), classe.getNum());
                }
                remove(classe);
            }
            remove(classe);
            return 1;

        }
    }

    public List<Classe> findClasseByCriteria(int num, String libelle) {
        String req = "select c from Classe c where 1=1 ";
        if (num >= 0) {
            req += " and c.num = '" + num + "'";
        }
        if (libelle != null) {
            req += " and c.libelle like '" + libelle + "'";
        }
        return getEntityManager().createQuery(req).getResultList();
    }

    public Classe findClasseByLibelle(String libelle) {
        if (libelle == null) {
            return null;
        }
        List<Classe> classes = findClasseByCriteria(-1, libelle);
        for (int i = 0; i < classes.size(); i++) {
            Classe classe = classes.get(i);
            if (classe.getLibelle().equals(libelle)) {
                return classe;
            }
        }
        return null;
    }

    public Classe findClasseByNum(int num) {

        List<Classe> classes = findClasseByCriteria(num, null);
        for (int i = 0; i < classes.size(); i++) {
            Classe classe = classes.get(i);
            if (classe.getNum() == num) {
                return classe;
            }
        }
        return null;
    }

    public int classeExist(String id, String libelle) {
        String req = "select c from Classe c where 1=1 ";
        if (id != null) {
            req += " and c.id like '" + id + "'";
        }
        if (libelle != null) {
            req += " and c.libelle = '" + libelle + "'";
        }
        List<Classe> resClasses = getEntityManager().createQuery(req).getResultList();
        if (resClasses == null) {
            return -1;
        } else {
            return 1;
        }
    }
//    public int modifyIdClasseCategorie(Classe nvClasse,Classe ancienClasse){
//        if(nvClasse==null||ancienClasse==null){
//            return -1;
//        }
//        CategorieServices categorieServices = new CategorieServices();
//        return categorieServices.getEntityManager().createQuery("update Categorie set "
//                + "classe.id='"+nvClasse.getId()+"'and classe.libelle like '"+nvClasse.getLibelle()+"' where Categorie.classe='"+ancienClasse+"'").executeUpdate();
//    }
}
