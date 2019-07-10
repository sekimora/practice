package com.sekimora.models;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_animal;
    @Column
    private String kind_animal;
    @Column
    private String name_animal;
    @Column
    private String sex_animal;
    @Column
    private Integer weight_animal;
    //@Value("${id_owner:#{null}}")
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_owner")
    private Owner id_owner;
    //@Value("${id_cage:#{null}}")
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cage")
    private Cage id_cage;

    public Animal() {
    }

    public Animal(String kind, String name, String sex, Integer weight) {
        this.kind_animal = kind;
        this.name_animal = name;
        this.sex_animal = sex;
        this.weight_animal = weight;

    }

    public Integer getId_animal() {
        return id_animal;
    }

    public void setId_animal(Integer id_animal) {
        this.id_animal = id_animal;
    }

    public String getKind_animal() {
        return kind_animal;
    }

    public void setKind_animal(String kind) {
        this.kind_animal = kind;
    }

    public String getName_animal() {
        return name_animal;
    }

    public void setName_animal(String n) {
        this.name_animal = n;
    }

    public String getSex_animal() {
        return sex_animal;
    }

    public void setSex_animal(String s) {
        this.sex_animal = s;
    }

    public Owner getOwner_animal() {
        return id_owner;
    }

    public void setOwner_animal(Owner id_owner) {
        this.id_owner = id_owner;
    }

    public Cage getCage_animal() {
        return id_cage;
    }

    public void setCage_animal(Cage id_cage) {
        this.id_cage = id_cage;
    }


    public Integer getWeight_animal() {
        return weight_animal;
    }

    public void setWeight_animal(Integer w) {
        this.weight_animal = w;
    }


}
