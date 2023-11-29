package com.example.demo.company.repository;

import com.example.demo.company.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

    Optional<Emp> findByDeptNo(Integer deptNo);

    Optional<Emp> findByEmpNo(Integer empNo);

}
