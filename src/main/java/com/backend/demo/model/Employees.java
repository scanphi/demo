package com.backend.demo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {
    /********************************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employees_id")
    private long employeesId;

    @JoinColumn(name = "genders_id", referencedColumnName = "genders_id")
    @ManyToOne(optional = false)
    private Genders gendersId;

    @JoinColumn(name = "jobs_id", referencedColumnName = "jobs_id")
    @ManyToOne(optional = false)
    private Jobs jobsId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Basic(optional = false)
    @Column(name = "birthdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    /********************************************************************************************/
    @OneToMany(mappedBy = "employeesId")
    private Collection<EmployeeWorkedHours> employeeWorkedHoursCollection;
    /********************************************************************************************/
    public Employees() {
    }

    public Employees(long employeesId, Genders gendersId, Jobs jobsId, String name, String last_name, Date birthdate) {
        this.employeesId = employeesId;
        this.gendersId = gendersId;
        //this.jobsId = jobsId;
        this.name = name;
        this.last_name = last_name;
        this.birthdate = birthdate;
    }
    /********************************************************************************************/
    public long getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(long employeesId) {
        this.employeesId = employeesId;
    }

    public Genders getGendersId() {
        return gendersId;
    }

    public void setGendersId(Genders gendersId) {
        this.gendersId = gendersId;
    }

    public Jobs getJobsId() {
        return jobsId;
    }

    public void setJobsId(Jobs jobsId) {
        this.jobsId = jobsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    /********************************************************************************************/
    @Override
    public String toString() {
        return "Employees{" +
                "employeesId=" + employeesId +
                ", gendersId=" + gendersId +
//                ", jobsId=" + jobsId +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
    /********************************************************************************************/
}
