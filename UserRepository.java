package com.vcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcd.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
