package com.example.demo.company.controller;

import com.example.demo.company.service.DeptService;
import com.example.demo.company.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(deptService.listAll(), HttpStatus.OK);
    }

    //用部門編號查單筆
    @GetMapping("listOne/{deptNo}")
    public ResponseEntity<Optional<Dept>> listOne(@PathVariable Integer deptNo){
        return new ResponseEntity<>(deptService.listOne(deptNo), HttpStatus.OK);
    }

    //新增部門
    @PostMapping("add")
    public ResponseEntity<Dept> add(@RequestBody Dept dept){
        return new ResponseEntity<>(deptService.add(dept), HttpStatus.OK);
    }

    //刪除部門
    @DeleteMapping("delete/{deptNo}")
    public ResponseEntity<Dept> delete(@PathVariable Integer deptNo){
        deptService.delete(deptNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //修改部門資料
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Dept dept){
        return new ResponseEntity<>(deptService.update(dept),HttpStatus.OK);
    }
}
