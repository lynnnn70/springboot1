package company.service;

import company.entity.Dept;
import company.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;


    //顯示部門列表
    public List<Dept> listAll(){
        List<Dept> deptList = deptRepository.findAll();
        return deptList;
    }


    //用部門編號查單筆

    //新增部門

    //刪除部門

    //修改部門資料


}
