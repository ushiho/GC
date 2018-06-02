/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CompteTransactionAssociation;
import bean.CompteTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ushiho
 */
public class CompteTransactionAssociationServices extends AbstractFacade<CompteTransactionAssociation> {

    public CompteTransactionAssociationServices() {
        super(CompteTransactionAssociation.class);
    }

    public int add(List<CompteTransaction> compteTransactions, double montantTotal) {
        if (compteTransactions == null || compteTransactions.isEmpty()) {
            return -1;
        }
        CompteTransactionService compteTransactionService = new CompteTransactionService();
        List<CompteTransaction> compteTransacionsDebits = new ArrayList();
        List<CompteTransaction> compteTransacionsCredits = new ArrayList();
        for (int i = 0; i < compteTransactions.size(); i++) {
            CompteTransaction compteTransaction = compteTransactions.get(i);
            if (compteTransaction.getType() == 1) {
                compteTransacionsCredits.add(compteTransaction);
            } else if (compteTransaction.getType() == 2) {
                compteTransacionsDebits.add(compteTransaction);
            }
        }
        if (compteTransacionsCredits.size() > compteTransacionsDebits.size()) {
            for (int i = 0; i < compteTransacionsCredits.size(); i++) {

                CompteTransaction compteTransactionCredit = compteTransacionsCredits.get(i);
                for (int j = 0; j < compteTransacionsDebits.size(); j++) {
                    CompteTransactionAssociation compteTransacionAssociationCredit = new CompteTransactionAssociation();
                    CompteTransaction compteTransactionDebit = compteTransacionsDebits.get(j);
                    compteTransacionAssociationCredit.setCompteTransactionCredit(compteTransactionCredit);
                    compteTransacionAssociationCredit.setCompteTransactionDebit(compteTransactionDebit);
                    compteTransacionAssociationCredit.setMontantTotal(montantTotal);
                    compteTransacionAssociationCredit.setNumTransaction(compteTransactionCredit.getNumTransaction());
                    create(compteTransacionAssociationCredit);
                }

            }
        } else if (compteTransacionsCredits.size() < compteTransacionsDebits.size()) {
            for (int i = 0; i < compteTransacionsDebits.size(); i++) {
                System.out.println("c=d");
                CompteTransaction compteTransactionDebit = compteTransacionsDebits.get(i);
                for (int j = 0; j < compteTransacionsCredits.size(); j++) {
                    CompteTransactionAssociation compteTransacionAssociationDebit = new CompteTransactionAssociation();
                    CompteTransaction compteTransactionCredit = compteTransacionsCredits.get(j);
                    compteTransacionAssociationDebit.setCompteTransactionCredit(compteTransactionCredit);
                    compteTransacionAssociationDebit.setCompteTransactionDebit(compteTransactionDebit);
                    compteTransacionAssociationDebit.setMontantTotal(montantTotal);
                    compteTransacionAssociationDebit.setNumTransaction(compteTransactionDebit.getNumTransaction());
                    create(compteTransacionAssociationDebit);
                }

            }
        } else {
            for (int i = 0; i < compteTransacionsDebits.size(); i++) {

                CompteTransaction compteTransactionDebit = compteTransacionsDebits.get(i);
                for (int j = 0; j < compteTransacionsCredits.size(); j++) {
                    CompteTransactionAssociation compteTransacionAssociationDebit = new CompteTransactionAssociation();
                    CompteTransaction compteTransactionCredit = compteTransacionsCredits.get(j);
                    compteTransacionAssociationDebit.setCompteTransactionCredit(compteTransactionCredit);
                    compteTransacionAssociationDebit.setCompteTransactionDebit(compteTransactionDebit);
                    compteTransacionAssociationDebit.setMontantTotal(montantTotal);
                    compteTransacionAssociationDebit.setNumTransaction(compteTransactionDebit.getNumTransaction());
                    create(compteTransacionAssociationDebit);
                }

            }
        }
        return 1;
    }

    public int delete(Long id) {
        CompteTransactionAssociation compteTransacionAssociation = find(id);
        if (compteTransacionAssociation == null) {
            return -1;
        }
        remove(compteTransacionAssociation);
        return 1;
    }

    public int deleteByCompteTransaction(CompteTransaction compteTransaction) {
        if (compteTransaction == null) {
            return -1;
        }
        List<CompteTransactionAssociation> compteTransactionAssociations = getEntityManager().createQuery("SELECT c FROM CompteTransactionAssociation c WHERE c.compteTransactionDebit.id ='"
                + compteTransaction.getId() + "'").getResultList();
        for (int i = 0; i < compteTransactionAssociations.size(); i++) {
            CompteTransactionAssociation compteTransactionAssociation = compteTransactionAssociations.get(i);
            remove(compteTransactionAssociation);
        }
        return 1;
    }

}
