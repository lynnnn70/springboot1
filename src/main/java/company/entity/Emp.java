package company.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "emp2")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPNO")
    private Integer empNo;

    @Column(name= "ENAME")
    private String eName;

    @Column(name = "JOB")
    private String job;

    @Column(name = "HIREDATE")
    private LocalDate hireDate;

    @Column(name = "SAL")
    private BigDecimal sal;

    @Column(name= "COMM")
    private BigDecimal comm;

    @Column(name = "DEPTNO")
    private Integer deptNo;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
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

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{empNo:").append(empNo);
        sb.append(", eName:'").append(eName).append('\'');
        sb.append(", job:'").append(job).append('\'');
        sb.append(", hireDate:").append(hireDate);
        sb.append(", sal:").append(sal);
        sb.append(", comm:").append(comm);
        sb.append(", deptNo:").append(deptNo);
        sb.append("}");
        return sb.toString();
    }
}
