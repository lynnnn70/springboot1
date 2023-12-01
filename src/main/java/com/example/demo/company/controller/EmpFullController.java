package com.example.demo.company.controller;

import com.example.demo.company.dto.EmpDto;
import com.example.demo.company.entity.EmpFull;
import com.example.demo.company.repository.EmpFullRepository;
import com.example.demo.company.service.EmpFullService;
import com.example.demo.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("api")
public class EmpFullController {
    @Autowired
    private EmpFullRepository empFullRepository;
    @Autowired
    private EmpFullService empFullService;
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

    //以部門名稱&職位查詢相對應的員工
    @GetMapping("listAllEmpByDeptNameAndJob/{deptName}/{job}")
    public List<EmpFull> listAllEmpByDeptNameAndJob(@PathVariable String deptName, @PathVariable String job){
        return empFullRepository.findEmpFullByDeptNameAndJob(deptName, job);
    }

    //新增
    @PostMapping("addEmp")
    public ResponseEntity<EmpFull> addNewEmp(@RequestBody EmpDto empDto){

        if(!validDto(empDto)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        EmpFull empFull ;
        try{
            empFull = empFullService.addNewEmp(empDto);
            if(empFull == null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(empFull, HttpStatus.CREATED);
    }


    private boolean validDto(EmpDto empDto) {

        String hireDate = empDto.getHireDate();
        String sal = empDto.getSal();
        String comm = empDto.getComm();
        try{
            convertDate(hireDate);
            new BigDecimal(sal);
            new BigDecimal(comm);
        }catch ( DateTimeParseException | NumberFormatException  e){
            return false;
        }

        return true;

    }

    private LocalDate convertDate(String hireDate) {
        //yyyyMMdd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(hireDate , formatter);
    }




}
