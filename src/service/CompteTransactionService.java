/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.CompteTransaction;
import bean.Entreprise;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import util.DateUtil;

/**
 *
 * @author ushiho
 */
public class CompteTransactionService extends AbstractFacade<CompteTransaction> {

    public CompteTransactionService() {
        super(CompteTransaction.class);
    }

    public int add(List<CompteTransaction> compteTransactions, double montantTotal) {
        if (compteTransactions == null) {
            return -1;
        }
        for (int i = 0; i < compteTransactions.size(); i++) {
            CompteTransaction compteTransaction = compteTransactions.get(i);
            compteTransaction.setMontantTotal(montantTotal);
            create(compteTransaction);
        }

        return 1;

    }

    public int delete(Long id) {
        CompteTransaction compteTransaction = find(id);
        if (compteTransaction == null) {
            return -1;
        }
        remove(compteTransaction);
        return 1;
    }

    public int deleteByEntreprise(Entreprise entreprise) {
//        return getEntityManager().createQuery("DELETE FROM CompteTransaction c WHERE c.entreprise.id ='"+entreprise.getId()+"'").executeUpdate();
        List<CompteTransaction> compteTransactions = getEntityManager().createQuery("select c from CompteTransaction c where "
                + " c.entreprise.id ='" + entreprise.getId() + "'").getResultList();
        CompteTransactionAssociationServices compteTransacionAssociationServices = new CompteTransactionAssociationServices();
        System.out.println(compteTransactions);
        for (int i = 0; i < compteTransactions.size(); i++) {
            CompteTransaction compteTransaction = compteTransactions.get(i);
            if (Objects.equals(compteTransaction.getEntreprise().getId(), entreprise.getId())) {
                compteTransacionAssociationServices.deleteByCompteTransaction(compteTransaction);
                remove(compteTransaction);
            }
        }
        return 1;
    }

    public double testMontant(List<CompteTransaction> compteTransactions) {
        if (compteTransactions == null || compteTransactions.isEmpty()) {
            return -1;
        } else {
            double montantTotalDebit = 0;
            double montantTotalCredit = 0;
            for (int i = 0; i < compteTransactions.size(); i++) {
                CompteTransaction compteTransaction = compteTransactions.get(i);
                System.out.println(compteTransaction);
                if (compteTransaction.getType() == 1) {
                    montantTotalCredit += compteTransaction.getMontant();
                } else if (compteTransaction.getType() == 2) {
                    montantTotalDebit += compteTransaction.getMontant();
                }
            }
            if (montantTotalCredit != montantTotalDebit) {
                return -2;
            }
            return montantTotalCredit;
        }
    }

    public List<CompteTransaction> findDataForGLivre(Long idEntre, Date dateDep, Date dateArr,
            Compte CompteDep, Compte CompteArr) {
        Date dateArrConverted = DateUtil.convertFormUtilToSql(dateArr);
        Date dateDepConverted = DateUtil.convertFormUtilToSql(dateDep);
        return getEntityManager().createQuery("SELECT c FROM CompteTransaction c "
                + "WHERE c.entreprise.id='" + idEntre + "' AND c.dateEnregistrement >= '" + dateDepConverted + "' AND"
                + " c.dateEnregistrement <= '" + dateArrConverted + "' AND "
                + "c.compte.num >= '" + CompteDep.getNum() + "' AND c.compte.num <= '"
                + CompteArr.getNum() + "' ").getResultList();
    }

    public long getMaxNumTransaction() {
        Long res = (Long) getEntityManager().createNativeQuery("SELECT Max(numTransaction) FROM COMPTETRANSACTION").getSingleResult();
        if (res == null) {
            return 0;
        } else {
            return res;
        }
    }

}
