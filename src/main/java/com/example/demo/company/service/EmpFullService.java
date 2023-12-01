package com.example.demo.company.service;

import com.example.demo.company.dto.EmpDto;
import com.example.demo.company.entity.Dept;
import com.example.demo.company.entity.EmpFull;
import com.example.demo.company.repository.DeptRepository;
import com.example.demo.company.repository.EmpFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class EmpFullService {
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private EmpFullRepository empFullRepository;

    //新增
    public EmpFull addNewEmp(EmpDto empDto){
        int deptNo = empDto.getDeptNo();
        Optional<Dept> deptOptional = deptRepository.findByDeptNo(deptNo);
        if(!deptOptional.isPresent()){
            return null;
        }
        Dept dept = deptOptional.get();
        EmpFull empDb = convertEmpDtoToVo(empDto);
        empDb.setDept(dept);

        return empFullRepository.save(empDb);
    }

    private EmpFull convertEmpDtoToVo(EmpDto empDto) {
        EmpFull empFull = new EmpFull();
        empFull.setEmpName(empDto.getEmpName());
        empFull.setHireDate(convertDate(empDto.getHireDate()));
        empFull.setComm(new BigDecimal(empDto.getComm()));
        empFull.setSal(new BigDecimal(empDto.getSal()));
        empFull.setJob(empDto.getJob());


        return empFull;
    }

    private LocalDate convertDate(String hireDate) {
        //yyyyMMdd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(hireDate , formatter);
    }


}
