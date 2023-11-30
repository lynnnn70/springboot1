package com.example.demo.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

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
   @OneToMany(mappedBy = "dept")
   // @JsonManagedReference
    private List<EmpFull> emps;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String dName) {
        this.deptName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<EmpFull> getEmps() {
        return emps;
    }

    public void setEmps(List<EmpFull> emps) {
        this.emps = emps;
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
