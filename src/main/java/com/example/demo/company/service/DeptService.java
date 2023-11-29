package com.example.demo.company.service;

import com.example.demo.company.entity.Dept;
import com.example.demo.company.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;


    //顯示部門列表
    public List<Dept> listAll(){
        List<Dept> deptList = deptRepository.findAll();
        return deptList;
    }

    //用部門編號查單筆
    public Optional<Dept> listOne(Integer deptNo){
        return deptRepository.findById(deptNo);
    }

    //新增部門
    public Dept add(Dept dept){
        if(!checkDeptName(dept)){
            return deptRepository.save(dept);
        }
        return null;
    }

    //刪除部門
    public void delete(Integer deptNo){
        deptRepository.deleteById(deptNo);
    }

    //修改部門資料
    public Dept update(Dept dept){
        if(checkDeptNo(dept)){
            dept.setDeptName(dept.getDeptName());
            dept.setLoc(dept.getLoc());
            return deptRepository.save(dept);
        }
        return null;
    }


    public boolean checkDeptNo(Dept dept){
        Optional<Dept> existingDept = deptRepository.findByDeptNo(dept.getDeptNo());
        // 如果存在，返回true，否则返回false
        return existingDept.isPresent();
        }

    public boolean checkDeptName(Dept dept) {
        Optional<Dept> existingDept = deptRepository.findByDeptName(dept.getDeptName());
        return existingDept.isPresent();
    }
}
