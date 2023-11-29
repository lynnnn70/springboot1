package com.example.demo.company.service;

import com.example.demo.company.entity.Dept;
import com.example.demo.company.entity.Emp;
import com.example.demo.company.repository.DeptRepository;
import com.example.demo.company.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    //查詢員工
    public List<Emp> listAll(){
        return empRepository.findAll();
    }

    //查詢單一員工
    public Optional<Emp> listOne(Integer empNo){
        return empRepository.findById(empNo);
    }

    //新增員工
    public Emp add(Emp emp){
        Optional<Dept> deptOptional = deptRepository.findByDeptNo(emp.getDeptNo());
        if(!deptOptional.isPresent()){
            return null;
        }
        return empRepository.save(emp);
    }

    //刪除員工
    public void delete(Integer empNo){
        empRepository.deleteById(empNo);
    }

    //修改員工資訊
    public Emp update(Emp emp){
        Optional<Emp> empOptional = empRepository.findByEmpNo(emp.getEmpNo());
        if(!empOptional.isPresent()){
           return null;
        }
        Emp dbemp = empOptional.get();
        dbemp.setEmpName(emp.getEmpName());
        dbemp.setJob(emp.getJob());
        dbemp.setHireDate(emp.getHireDate());
        dbemp.setSal(emp.getSal());
        dbemp.setComm(emp.getComm());
        dbemp.setDeptNo(emp.getDeptNo());
        return empRepository.save(emp);
    }



}
