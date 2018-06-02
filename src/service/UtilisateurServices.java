/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class UtilisateurServices extends AbstractFacade<Utilisateur> {

    public UtilisateurServices() {
        super(Utilisateur.class);
    }

    public int addUser(String nom, String prenom, int sexe, String email, String nSS, String cin, String nBureau, Date dateEmb, double salaire, String login, String password, String tel, int poste) {
        if (login == null || nSS == null || nBureau == null || cin == null) {
            return -1;
        }
        Utilisateur loginExist = findUtilisateurByCriteria(findUtilisateur(null, null, null, login), login, "login");
        Utilisateur cinExist = findUtilisateurByCriteria(findUtilisateur(null, cin, null, null), cin, "cin");
        Utilisateur nBureauExist = findUtilisateurByCriteria(findUtilisateur(null, null, nBureau, null), nBureau, "nBureau");
        Utilisateur nSSExist = findUtilisateurByCriteria(findUtilisateur(nSS, null, null, null), nSS, "numSecuriteSocial");
        if (loginExist != null || cinExist != null || nBureauExist != null || nSSExist != null) {
            return -2;
        } else {
            Utilisateur utilisateur = new Utilisateur(nSS, nom, prenom, sexe, email, cin, tel, salaire, poste, nBureau, login, password, dateEmb);
            create(utilisateur);
            return 1;
        }

    }

    public int deleteUser(Long id) {
        if (id == null) {
            return -1;
        } else {
            Utilisateur user = find(id);
            if (user == null) {
                return -2;
            } else {
                remove(user);
                return 1;
            }
        }
    }

    public int modifyComptableByAdmin(Utilisateur nvUtilisateur, Utilisateur ancienUtilisateur) {
        if (nvUtilisateur == null || ancienUtilisateur == null) {
            return -1;
        } else {
            ancienUtilisateur.setCin(nvUtilisateur.getCin());
            ancienUtilisateur.setnBureau(nvUtilisateur.getnBureau());
            ancienUtilisateur.setNumSecuriteSocial(nvUtilisateur.getNumSecuriteSocial());
            ancienUtilisateur.setPoste(nvUtilisateur.getPoste());
            ancienUtilisateur.setSalaire(nvUtilisateur.getSalaire());
            ancienUtilisateur.setDateEmbauche(nvUtilisateur.getDateEmbauche());
            edit(ancienUtilisateur);
            return 1;
        }
    }

    public int modifyComptable(Utilisateur nvUtilisateur, Utilisateur ancienUtilisateur) {
        if (nvUtilisateur == null || ancienUtilisateur == null) {
            return -1;
        }
        ancienUtilisateur.setEmail(nvUtilisateur.getEmail());
        ancienUtilisateur.setLogin(nvUtilisateur.getLogin());
        ancienUtilisateur.setNome(nvUtilisateur.getNome());
        ancienUtilisateur.setPassword(nvUtilisateur.getPassword());
        ancienUtilisateur.setPrenome(nvUtilisateur.getPrenome());
        ancienUtilisateur.setSexe(nvUtilisateur.getSexe());
        ancienUtilisateur.setTel(nvUtilisateur.getTel());
        edit(ancienUtilisateur);
        return 1;

    }

    public int modifyAdmin(Utilisateur nvUtilisateur, Utilisateur ancienUtilisateur) {
        if (ancienUtilisateur == null || nvUtilisateur == null) {
            return -1;
        }

        modifyComptable(nvUtilisateur, ancienUtilisateur);
        return modifyComptableByAdmin(nvUtilisateur, ancienUtilisateur);

    }

    public Utilisateur seConnecter(Utilisateur user) {
        int tst = 0;
        if (user == null) {
            return null;
        }
        Utilisateur loadedUser = findUtilisateurByCriteria(findUtilisateur(null, null, null, user.getLogin()), user.getLogin(), "login");
        if (loadedUser == null) {
            return null;
        } else if (!loadedUser.getPassword().equals(user.getPassword())) {
            return null;
        } else if (loadedUser.getPoste() != (user.getPoste())) {
            return null;
        }
        return loadedUser;

    }

    public boolean confirmer(String password, Long id) {
        if (password == null || id == null) {
            return false;
        } else {
            Utilisateur utilisateur = find(id);
            if (utilisateur == null) {
                return false;
            } else if (!utilisateur.getPassword().equals(password)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public Utilisateur findUtilisateurByCriteria(List<Utilisateur> utilisateurs, String value, String atributeName) {
        if (value == null || utilisateurs == null || utilisateurs.isEmpty()) {
            return null;
        }
        for (int i = 0; i < utilisateurs.size(); i++) {
            Utilisateur utilisateur = utilisateurs.get(i);
            if (atributeName.equals("cin")) {
                if (utilisateur.getCin().equals(value)) {
                    return utilisateur;
                }
            }
            if (atributeName.equals("nBureau")) {
                if (utilisateur.getnBureau().equals(value)) {
                    return utilisateur;
                }
            }
            if (atributeName.equals("numSecuriteSocial")) {
                if (utilisateur.getNumSecuriteSocial().equals(value)) {
                    return utilisateur;
                }
            }
            if (atributeName.equals("login")) {
                if (utilisateur.getLogin().equals(value)) {
                    return utilisateur;
                }
            }
        }
        return null;
    }

    public List<Utilisateur> findUtilisateur(String nSS, String cin, String nBireau, String login) {
        String req = "select u from Utilisateur u where 1=1 ";
        if (nSS != null) {
            req += " and u.numSecuriteSocial like '" + nSS + "'";
        }
        if (cin != null) {
            req += " and u.cin like '" + cin + "'";
        }
        if (nBireau != null) {
            req += " and u.nBureau like '" + nBireau + "'";
        }
        if (login != null) {
            req += " and u.login like '" + login + "'";
        }
        return getEntityManager().createQuery(req).getResultList();
    }
//    public static void main(String[] args) {
//        System.out.println("addUser");
//        String nom = "hamza";
//        String prenom = "lotfi";
//        int sexe = 2;
//        String email = "kiol@lom.vo";
//        //
//        String nSS = "NC1";
//        //
//        String cin = "N4520";
//        //
//        String nBureau = "B1";
//        Date dateEmb = null;
//        double salaire = 2000.0;
//        //
//        String login = "lotfi";
//        String password = "hm";
//        String tel = "03256";
//        int poste = 1;
//        UtilisateurServices instance = new UtilisateurServices();
//        int result = instance.addUser(nom, prenom, sexe, email, nSS, cin, nBureau, dateEmb, salaire, login, password, tel, poste);
//        System.out.println("resultat : "+result);
//    }
}
