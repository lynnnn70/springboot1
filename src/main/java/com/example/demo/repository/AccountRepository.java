package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    //email是否重複
     Optional<Account> findByEmail(String email);

     Optional<Account>findByUserAccount(String userAccount);
}
