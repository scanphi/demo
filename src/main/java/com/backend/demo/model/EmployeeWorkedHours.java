package com.backend.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee_worked_hours")
public class EmployeeWorkedHours {
    /********************************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_worked_hours_id")
    private long employeeWorkedHoursId;

    @JoinColumn(name = "employees_id", referencedColumnName = "employees_id")
    @ManyToOne(optional = false)
    private Employees employeesId;

    @Column(name = "worked_hours", nullable = false)
    private BigDecimal workedHours;

    @Basic(optional = false)
    @Column(name = "worked_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workedDate;
    /********************************************************************************************/
    public EmployeeWorkedHours() {
    }

    public EmployeeWorkedHours(long employeeWorkedHoursId, BigDecimal workedHours, Date workedDate) {
        this.employeeWorkedHoursId = employeeWorkedHoursId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }
    public EmployeeWorkedHours(long employeeWorkedHoursId, Employees employeesId, BigDecimal workedHours, Date workedDate) {
        this.employeeWorkedHoursId = employeeWorkedHoursId;
        this.employeesId = employeesId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }
    /********************************************************************************************/
    public long getEmployeeWorkedHoursId() {
        return employeeWorkedHoursId;
    }

    public void setEmployeeWorkedHoursId(long employeeWorkedHoursId) {
        this.employeeWorkedHoursId = employeeWorkedHoursId;
    }

    public Employees getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Employees employeesId) {
        this.employeesId = employeesId;
    }

    public BigDecimal getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(BigDecimal workedHours) {
        this.workedHours = workedHours;
    }

    public Date getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(Date workedDate) {
        this.workedDate = workedDate;
    }
    /********************************************************************************************/
    @Override
    public String toString() {
        return "EmployeeWorkedHours{" +
                "employeeWorkedHoursId=" + employeeWorkedHoursId +
                ", employeesId=" + employeesId +
                ", workedHours=" + workedHours +
                ", workedDate=" + workedDate +
                '}';
    }
    /********************************************************************************************/
}
