package com.example.demo.company.controller;

import com.example.demo.company.service.DeptService;
import com.example.demo.company.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("test")
    public String test(){
        return "TEST";
    }

    //顯示部門列表
    @GetMapping("listAll")
    public ResponseEntity<List<Dept>> listAll(){
        return new ResponseEntity(deptService.listAllDept(), HttpStatus.OK);
    }

    //用部門編號查單筆
    @GetMapping("listOne/{deptNo}")
    public ResponseEntity<Optional<Dept>> listOne(@PathVariable Integer deptNo){
        return new ResponseEntity<>(deptService.listOne(deptNo), HttpStatus.OK);
    }

    //新增部門

    //刪除部門

    //修改部門資料
}
