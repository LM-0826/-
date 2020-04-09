package com.example.springbootsss.dao;

import com.example.springbootsss.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: 李明
 * @create: 2020-03-25 9:38
 * @Description:
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor {

}
