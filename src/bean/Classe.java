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
import javax.persistence.OneToMany;

/**
 *
 * @author ushiho
 */
@Entity
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int num;
    private String libelle;
    @OneToMany(mappedBy = "classe")
    private List<Categorie> categories;

    public Classe(Long id, int num, String libelle) {
        this.id = id;
        this.num = num;
        this.libelle = libelle;
    }

    public Classe(int num, String libelle) {
        this.num = num;
        this.libelle = libelle;
    }

    public Classe(Long idBD) {
        this.id = idBD;
    }

    public Classe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Categorie> getCategories() {
        if (categories == null) {
            categories = new ArrayList();
        }
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        if (categories == null) {
            categories = new ArrayList();
        }
        this.categories = categories;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Classe other = (Classe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", num=" + num + ", libelle=" + libelle + '}';
    }

}
