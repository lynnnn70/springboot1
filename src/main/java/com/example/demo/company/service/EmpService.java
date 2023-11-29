package com.example.demo.company.service;

import com.example.demo.company.entity.Emp;
import com.example.demo.company.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

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
        if(checkEmpNo(emp)){
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
        Optional<Emp> empOptional = empRepository.findById(emp.getEmpNo());
        if(!empOptional.isPresent()){
           return null;
        }
        Emp dbemp = empOptional.get();
        dbemp.seteEmpName(dbemp.geteEmpName());
        dbemp.setJob(dbemp.getJob());
        dbemp.setHireDate(dbemp.getHireDate());
        dbemp.setSal(dbemp.getSal());
        dbemp.setDeptNo(dbemp.getDeptNo());
        return empRepository.save(dbemp);
    }

    public boolean checkEmpNo(Emp emp){
        Optional<Emp> existingEmpNo = empRepository.findById(emp.getEmpNo());
        return existingEmpNo.isPresent();
    }

}
