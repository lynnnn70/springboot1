package com.example.demo.company.controller;

import com.example.demo.company.entity.Emp;
import com.example.demo.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    //查詢員工
    @GetMapping("listAll")
    public ResponseEntity<List<Emp>> listAll(){
        return new ResponseEntity<>(empService.listAll(), HttpStatus.OK);
    }

    //查詢單一員工
    @GetMapping("listOne/{empNo}")
    public ResponseEntity<Optional<Emp>> listOne(@PathVariable Integer empNo){
        return new ResponseEntity<>(empService.listOne(empNo),HttpStatus.OK);
    }

    //新增員工
    @PostMapping("add")
    public ResponseEntity<Emp> add(@RequestBody Emp emp){
        return new ResponseEntity<>(empService.add(emp),HttpStatus.CREATED);
    }

    //刪除員工
    @DeleteMapping("delete/{empNo}")
    public ResponseEntity<Emp> delete(@PathVariable Integer empNo){
        empService.delete(empNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //修改員工資訊
    @PutMapping("update")
    public ResponseEntity<Emp> update (@RequestBody Emp emp){
        return new ResponseEntity<>(empService.update(emp),HttpStatus.OK);
    }

}
