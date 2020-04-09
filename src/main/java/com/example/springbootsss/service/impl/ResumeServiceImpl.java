package com.example.springbootsss.service.impl;


import com.example.springbootsss.dao.ResumeDao;
import com.example.springbootsss.pojo.Resume;
import com.example.springbootsss.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 李明
 * @create: 2020-03-25 9:51
 * @Description:
 */
@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> queryResumeList() throws Exception {
        return resumeDao.findAll();
    }

    @Override
    public Resume updateEntity(Resume resume) {
        resume = resumeDao.save(resume);
        return resume;
    }

    @Override
    public void deleteEntity(Long id) {
        resumeDao.deleteById(id);
    }
}
