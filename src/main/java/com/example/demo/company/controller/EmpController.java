package com.example.demo.company.controller;

import com.example.demo.company.entity.Emp;
import com.example.demo.company.service.EmpService;
import net.bytebuddy.dynamic.DynamicType;
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
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Emp> listOne(@PathVariable Integer empNo){
//        return new ResponseEntity<>(empService.listOne(empNo),HttpStatus.BAD_REQUEST);
        //1
//        Optional<Emp> emp = empService.listOne(empNo);
//        if(emp.isPresent()){
//            Emp emp1 = emp.get();
//            return new ResponseEntity<>(emp1 , HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
//        }
        // 2
//        Emp emp = empService.listOne1(empNo);
//        if(emp == null){
//            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
//        }else{
//            return new ResponseEntity<>(emp , HttpStatus.OK);
//        }

        // 3
        return  empService.listOne(empNo)
                .map(emp -> new ResponseEntity<>(emp , HttpStatus.OK))
                .orElse( new ResponseEntity<>(null , HttpStatus.NOT_FOUND));


    }

    //controller職責
    // 輸入參數的驗證
    // 請求的轉發(service) => null
    // 請求結果的包裝
    // 回傳請求結果

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


    public Object test(Object object){
        return object;
    }


}
