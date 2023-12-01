package com.example.demo.company.dto;



public class EmpDto {

    private String empName;
    private String job;
    private String hireDate;
    private String sal;
    private String comm;
    private int deptNo;

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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{empName:'").append(empName).append('\'');
        sb.append(", job:'").append(job).append('\'');
        sb.append(", hireDate:").append(hireDate);
        sb.append(", sal:'").append(sal).append('\'');
        sb.append(", comm:'").append(comm).append('\'');
        sb.append(", deptNo:").append(deptNo);
        sb.append("}");
        return sb.toString();
    }
}

