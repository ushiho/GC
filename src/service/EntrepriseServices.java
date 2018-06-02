/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Entreprise;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class EntrepriseServices extends AbstractFacade<Entreprise> {

    public EntrepriseServices() {
        super(Entreprise.class);
    }

    public int add(String numSecuriteSiege, String tel, String cinChef, String email, String adresse) {
        if (numSecuriteSiege == null || cinChef == null) {
            return -1;
        }
        Entreprise entrepriseExist = findEntreprise(numSecuriteSiege);
        if (entrepriseExist != null) {
            return -2;
        } else {
            Entreprise entreprise = new Entreprise(numSecuriteSiege, cinChef, adresse, email, tel);
            create(entreprise);
            return 1;
        }
    }

    public int delete(Long id) {
        Entreprise entreprise = find(id);
        if (entreprise == null) {
            return -1;
        }
        remove(entreprise);
        return 3;
    }

    public int modify(Long id , Entreprise NvEntre) {
        if (id== null || NvEntre == null) {
            return -1;
        }
        Entreprise entrepriseExist = find(id);
        if (entrepriseExist == null) {
            return -2;
        }  else {
            entrepriseExist.setAdresse(NvEntre.getAdresse());
            entrepriseExist.setCinChef(NvEntre.getCinChef());
            entrepriseExist.setEmail(NvEntre.getEmail());
            entrepriseExist.setNumSecuriteSiege(NvEntre.getNumSecuriteSiege());
            entrepriseExist.setTel(NvEntre.getTel());
            edit(entrepriseExist);
            return 2;
        }
    }

    public List<Entreprise> findByCriteria(String numSecuriteSiege) {

        return getEntityManager().createQuery("SELECT e FROM Entreprise e WHERE e.numSecuriteSiege LIKE '" + numSecuriteSiege + "'").getResultList();
    }

    public Entreprise findEntreprise(String numSecuriteSiege) {
        if (numSecuriteSiege == null) {
            return null;
        }
        List<Entreprise> entreprises = findByCriteria(numSecuriteSiege);
        for (int i = 0; i < entreprises.size(); i++) {
            Entreprise entreprise = entreprises.get(i);
            if (entreprise.getNumSecuriteSiege().equals(numSecuriteSiege)) {
                return entreprise;
            }
        }
        return null;
    }

}
