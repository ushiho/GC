/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ushiho
 */
@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int num;
    private String libelle;
    @ManyToOne
    private Classe classe;
    @OneToMany(mappedBy = "categorie")
    private List<Compte> comptes;

    public Categorie(int num, String libelle) {
        this.num = num;
        this.libelle = libelle;
    }

    public Categorie(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Categorie(Long idDB) {
        this.id = idDB;
    }

    public Categorie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Classe getClasse() {
        if (classe == null) {
            Classe classe = new Classe();
        }
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Compte> getComptes() {
        if (comptes == null) {
            comptes = new ArrayList();
        }
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        if (comptes == null) {
            comptes = new ArrayList();
        }
        this.comptes = comptes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", num=" + num + ", libelle=" + libelle + '}';
    }

}
