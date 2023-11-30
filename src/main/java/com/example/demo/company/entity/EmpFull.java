package com.example.demo.company.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emp2")
@JsonIgnoreProperties("dept")
public class EmpFull {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPNO")
    private Integer empNo;

    @Column(name= "ENAME")
    private String empName;

    @Column(name = "JOB")
    private String job;

    @Column(name = "HIREDATE")
    private LocalDate hireDate;

    @Column(name = "SAL")
    private BigDecimal sal;

    @Column(name= "COMM")
    private BigDecimal comm;

    @ManyToOne
    @JoinColumn(name = "DEPTNO")
    //@JsonBackReference
    private Dept dept;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept deptNo) {
        this.dept = deptNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{empNo:").append(empNo);
        sb.append(", empName:'").append(empName).append('\'');
        sb.append(", job:'").append(job).append('\'');
        sb.append(", hireDate:").append(hireDate);
        sb.append(", sal:").append(sal);
        sb.append(", comm:").append(comm);
        sb.append(", deptNo:").append(dept);
        sb.append("}");
        return sb.toString();
    }
}
