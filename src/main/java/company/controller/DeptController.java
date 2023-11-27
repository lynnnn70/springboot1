package company.controller;

import company.entity.Dept;
import company.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //顯示部門列表
    @GetMapping("listAll")
    public ResponseEntity<?> listAll(){
        List<Dept> deptList = deptService.listAll();

        return null;
    }


    //用部門編號查單筆
    @GetMapping("listOne/{deptNo}")
    public ResponseEntity<?> listOne(@PathVariable Integer deptNo){

        return null;
    }

    //新增部門

    //刪除部門

    //修改部門資料
}
