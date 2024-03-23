package com.clo.vendors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clo.vendors.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
