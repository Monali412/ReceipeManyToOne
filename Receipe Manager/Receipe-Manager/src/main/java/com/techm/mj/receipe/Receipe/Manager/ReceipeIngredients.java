package com.techm.mj.receipe.Receipe.Manager;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.FetchType;

@Entity
@Table(name="receipes_ingredients")
@NamedQueries({
        @NamedQuery(name = "ReceipeIngredients.findByReceiepeId", query = "SELECT r FROM ReceipeIngredients r where r.receipe.receipe_id =1") ,
        @NamedQuery(name = "ReceipeIngredients.findByIdAndReceiepeId", query = "SELECT r FROM ReceipeIngredients r where r.id=1 and  r.receipe.receipe_id = 2 ") })
public class ReceipeIngredients extends AuditModel{

    private Long id;
    private String name;

    //@ManyToOne(cascade = {CascadeType.ALL},mappedBy = "receipes_master")//(optional = true ,fetch = FetchType.LAZY , mappedBy = "receipes_master")
    @ManyToOne
    @JoinColumn(name = "receipe_id", referencedColumnName = "receipe_id")
    public Receipe receipe;

    public ReceipeIngredients(){
    }

    public ReceipeIngredients( String name) {
        this.name = name;
    }

   // @(mappedBy = "receipes_master", cascade = CascadeType.ALL)

    public Receipe getReceipe() {
        return receipe;
    }

    public void setReceipe(Receipe receipe) {
        this.receipe = receipe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredent_id")
    public Long getId() {
        return id;
    }

    public void setId(Long ingredent_id) {
        this.id = ingredent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
