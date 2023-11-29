package com.example.demo.company.web;


import com.example.demo.company.entity.Dept;
import com.example.demo.company.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("web/dept")
public class DeptWebController {
    @Autowired
    private DeptService deptService;

    @GetMapping("listAll")
    public String listAllDept(Model model){

        List<Dept> depts = deptService.listAll();
        model.addAttribute("deptDOs" , depts);

        return "company/deptListAll";

    }
}
