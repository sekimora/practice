package com.sekimora.models;

import javax.persistence.*;

@Entity
@Table(name = "cage    ")
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cage;
    @Column
    private Integer width_cage;
    @Column
    private Integer lenght_cage;
    @Column
    private Integer height_cage;

    public Cage() {
    }


    public Integer getId_cage() {
        return id_cage;
    }

    public void setId_cage(Integer id) {
        this.id_cage = id;
    }

    public Integer getWidth_cage() {
        return width_cage;
    }

    public void setWidth_cage(Integer w) {
        this.width_cage = w;
    }

    public Integer getLenght_cage() {
        return lenght_cage;
    }

    public void setLenght_cage(Integer l) {
        this.lenght_cage = l;
    }

    public Integer getHeight_cage() {
        return height_cage;
    }

    public void setHeight_cage(Integer h) {
        this.height_cage = h;
    }


}
