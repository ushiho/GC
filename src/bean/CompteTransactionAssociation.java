/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ushiho
 */
@Entity
public class CompteTransactionAssociation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long numTransaction ;
    private double montantTotal;
    @ManyToOne
    private CompteTransaction compteTransactionDebit;
    @ManyToOne
    private CompteTransaction compteTransactionCredit;

    
    public CompteTransactionAssociation() {
    }

    public CompteTransactionAssociation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(long numTransaction) {
        this.numTransaction = numTransaction;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public CompteTransaction getCompteTransactionDebit() {
        if (compteTransactionDebit == null) {
            compteTransactionDebit = new CompteTransaction();
        }
        return compteTransactionDebit;
    }

    public void setCompteTransactionDebit(CompteTransaction compteTransactionDebit) {
        this.compteTransactionDebit = compteTransactionDebit;
    }

    public CompteTransaction getCompteTransactionCredit() {
        if (compteTransactionCredit == null) {
            compteTransactionCredit = new CompteTransaction();
        }
        return compteTransactionCredit;
    }

    public void setCompteTransactionCredit(CompteTransaction compteTransactionCredit) {
        this.compteTransactionCredit = compteTransactionCredit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteTransactionAssociation)) {
            return false;
        }
        CompteTransactionAssociation other = (CompteTransactionAssociation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompteTransacionAssociation{" + "id=" + id + '}';
    }

}
