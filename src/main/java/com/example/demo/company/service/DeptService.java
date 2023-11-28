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
    public List<Dept> listAllDept(){
        List<Dept> deptList = deptRepository.findAll();
        return deptList;
    }

    //用部門編號查單筆
    public Optional<Dept> listOne(Integer deptNo){
        return deptRepository.findById(deptNo);
    }

    //新增部門

    //刪除部門

    //修改部門資料


}
