package com.backend.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genders")
public class Genders {
    /********************************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genders_id")
    private long gendersId;

    @Column(name = "name", nullable = false)
    private String name;
    /********************************************************************************************/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gendersId")
    private Collection<Employees> employeesCollection;
    /********************************************************************************************/
    public Genders() {
    }

    public Genders(long gendersId, String name) {
        this.gendersId = gendersId;
        this.name = name;
    }
    /********************************************************************************************/
    public long getGendersId() {
        return gendersId;
    }

    public void setGendersId(long gendersId) {
        this.gendersId = gendersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /********************************************************************************************/
    @Override
    public String toString() {
        return "Genders{" +
                "gendersId=" + gendersId +
                ", name='" + name + '\'' +
                '}';
    }
    /********************************************************************************************/
}
