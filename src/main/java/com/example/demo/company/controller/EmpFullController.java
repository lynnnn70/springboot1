package com.example.demo.company.controller;

import com.example.demo.company.entity.EmpFull;
import com.example.demo.company.repository.EmpFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class EmpFullController {
    @Autowired
    private EmpFullRepository empFullRepository;
    @GetMapping("listAllByComm/{comm}")
    public List<EmpFull> listAllByComm(@PathVariable BigDecimal comm){

        return empFullRepository.findByCommLessThan(comm);
    }

    @GetMapping("listAllBySal/{sal}")
    public List<EmpFull> listAllBySal(@PathVariable BigDecimal sal){
        return empFullRepository.findBySalGreaterThan(sal);
    }

    @GetMapping("listAllByNameContain/{empName}")
    public List<EmpFull> listAllByNameContain(@PathVariable String empName){
        return empFullRepository.findByEmpNameContaining(empName);
    }

    @GetMapping("lisAllByNameNotContain/{empName}")
    public List<EmpFull> lisAllByNameNotContain(@PathVariable String empName){
        return empFullRepository.findByEmpNameIsNotContaining(empName);
    }

    //在方法參數上直接使用DateTimeFormat指定日期的格式，Spring會將傳遞的字串轉成LocalDate
    @GetMapping("listAllByHireDateBefore")
    public List<EmpFull> listAllByHireDateBefore(@RequestParam("hireDate")
                                                 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hireDate){
        return empFullRepository.findByHireDateBefore(hireDate);
    }

    @GetMapping("listAllByHireDateAfter")
    public List<EmpFull> listAllByHireDateAfter(@RequestParam("hireDate")
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hireDate){
        return empFullRepository.findByHireDateAfter(hireDate);
    }


}
