package com.example.demo.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "dept2")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPTNO")
    private Integer deptNo;

    @Column(name = "DNAME")
    private String deptName;

    @Column(name ="LOC")
    private String loc;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getdDeptName() {
        return deptName;
    }

    public void setdDeptName(String dName) {
        this.deptName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{deptNo:").append(deptNo);
        sb.append(", dName:'").append(deptName).append('\'');
        sb.append(", loc:'").append(loc).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
