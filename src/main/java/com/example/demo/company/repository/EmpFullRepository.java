package com.example.demo.company.repository;

import com.example.demo.company.entity.EmpFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpFullRepository extends JpaRepository<EmpFull,Integer> {

    @Query("SELECT e FROM EmpFull  e WHERE e.comm < :inputComm")
    List<EmpFull> queryEmpFullByCommLessThan(@Param("inputComm") BigDecimal inputComm);

    //查COMM小於傳入值的員工
    @Query(value = "SELECT * FROM emp2 e WHERE e.COMM < :inputComm", nativeQuery = true)
    List<EmpFull> findByCommLessThan(@Param("inputComm") BigDecimal inputComm);

    //查SAL大於傳入值的員工
    @Query(value = "SELECT * FROM emp2 e WHERE e.SAL > :inputSal", nativeQuery = true)
    List<EmpFull> findBySalGreaterThan(@Param("inputSal") BigDecimal inputSal);

    //查包含傳入值的員工
    List<EmpFull> findByEmpNameContaining(String empName);

    //查不包含傳入值的員工
    List<EmpFull> findByEmpNameIsNotContaining(String empName);

    //查入值日期在傳入值之前
    List<EmpFull> findByHireDateBefore(LocalDate hiredate);

    //查入值日期在傳入值之後
    List<EmpFull> findByHireDateAfter(LocalDate hiredate);

//    List<T> findAll(Specification<T> spec);

}