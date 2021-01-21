package com.techm.mj.receipe.Receipe.Manager;

import java.util.Date;
import java.util.List;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="receipes_master")
public class Receipe extends AuditModel{


	private Long receipe_id;
    private String name;
    private String type;


    private List <ReceipeIngredients> receipeIngredients;

    public Receipe(Long receipe_id, String name, String type, String receipe_detail, Long persons_served) {
        this.receipe_id = receipe_id;
        this.name = name;
        this.type = type;
        this.receipe_detail = receipe_detail;
        this.persons_served = persons_served;
    }

    @OneToMany(mappedBy = "receipes_master", cascade = {CascadeType.ALL})
    public List<ReceipeIngredients> getReceipeIngredients() {
        return receipeIngredients;
    }

    public void setReceipeIngredients(List<ReceipeIngredients> receipeIngredients) {
        this.receipeIngredients = receipeIngredients;
    }
    //private String ingredients;
    @Column(name = "receipe_detail")
    private String receipe_detail;
    private Long persons_served;

  /*  @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable = false, updatable = false)
    private Date created_at;*/

    public Long getPersons_served() {
        return persons_served;
    }

    public void setPersons_served(Long persons_served) {
        this.persons_served = persons_served;
    }

    /*public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }*/

    public Receipe() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getReceipe_id() {
        return receipe_id;
    }

    public void setReceipe_id(Long id) {
        this.receipe_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   /* public String getIngredients() {
        return ingredients;
    }

    //public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }*/

    public String getReceipe_detail() {
        return receipe_detail;
    }

    public void setReceipe_detail(String receipedetail) {
        this.receipe_detail = receipedetail;
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipe)) return false;
        Receipe receipe = (Receipe) o;
        return getReceipe_id().equals(receipe.getReceipe_id()) && getName().equals(receipe.getName()) && getType().equals(receipe.getType()) && Objects.equals(getIngredients(), receipe.getIngredients()) && Objects.equals(getReceipe_detail(), receipe.getReceipe_detail()) && Objects.equals(getPersons_served(), receipe.getPersons_served()) && Objects.equals(getCreated_date(), receipe.getCreated_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredients(), getReceipe_detail(), getPersons_served(), getCreated_date());
    }*/

   /* @Override
    public String toString() {
        return "Receipe{" +
                "receipe_id=" + receipe_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", receipe_detail='" + receipe_detail + '\'' +
                ", persons_served=" + persons_served +
                ", created_date=" + created_date +
                '}';
    }*/
}
