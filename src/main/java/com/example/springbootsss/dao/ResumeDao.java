package com.example.springbootsss.dao;

import com.example.springbootsss.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 李明
 * @create: 2020-03-24 16:25
 * @Description:
 */
@Repository
public interface ResumeDao extends JpaRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {

    @Query("from Resume where id = ?1 and naem = ?2")
    public List<Resume> findByJpql(Long id, String name);


    @Query(value = "select * from tb_resume where name like ?1 and address like ?2 ", nativeQuery = true)
    public List<Resume> findBySql(String name, String address);


    public List<Resume> findByNameLikeAndAddress(String name, String address);

}
