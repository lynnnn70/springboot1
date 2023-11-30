package com.example.demo.company.web;

import com.example.demo.company.entity.Emp;
import com.example.demo.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("web/emp")
public class EmpWebController {

    @Autowired
    private EmpService empService;

    @GetMapping("listAll")
    public String listAllEmp(Model model){

        List<Emp> emps = empService.listAll();
        model.addAttribute("emps", emps);

        return "company/empListAll";

    }

    @PostMapping ("getOneForUpdate")
    public String getOneForUpdate(Model model, Integer empNo){
        Optional<Emp> empOptional = empService.listOne(empNo);
        if(empOptional.isPresent()){
            Emp emp = empOptional.get();
            model.addAttribute("emp", emp);
        }
        return "company/empUpdate";
    }

}

