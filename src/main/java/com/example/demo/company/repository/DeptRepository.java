package com.example.demo.company.repository;

import com.example.demo.company.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
    Optional<Dept> findByDeptNo(Integer deptNo);

    Optional<Dept> findByDeptName(String deptName);
}
