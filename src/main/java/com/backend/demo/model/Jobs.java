package com.backend.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "jobs")
public class Jobs {
    /********************************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobs_id")
    private long jobsId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    /********************************************************************************************/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobsId")
    private Collection<Employees> employeesCollection;
    /********************************************************************************************/
    public Jobs() {
    }

    public Jobs(long jobsId, String name, BigDecimal salary) {
        this.jobsId = jobsId;
        this.name = name;
        this.salary = salary;
    }
    /********************************************************************************************/
    public long getJobsId() {
        return jobsId;
    }

    public void setJobsId(long jobsId) {
        this.jobsId = jobsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    /********************************************************************************************/
    @Override
    public String toString() {
        return "Jobs{" +
                "jobsId=" + jobsId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    /********************************************************************************************/
}
