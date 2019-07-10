package com.sekimora.models;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_owner;
    @Column
    private String firstname;
    @Column
    private String secondname;
    @Column
    private String adr_owner;


    public Owner() {
    }

    public Owner(String fn, String sn, String adr/*, Animal an*/) {
        this.firstname = fn;
        this.secondname = sn;
        this.adr_owner = adr;
        // this.animal=an;
    }

    public Integer getId_owner() {
        return id_owner;
    }

    public void setId_owner(Integer id) {
        this.id_owner = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fn) {
        this.firstname = fn;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String sn) {
        this.secondname = sn;
    }

    public String getAdr_owner() {
        return adr_owner;
    }

    public void setAdr_owner(String adr) {
        this.adr_owner = adr;
    }

}
