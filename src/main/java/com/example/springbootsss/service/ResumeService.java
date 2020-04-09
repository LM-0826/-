package com.example.springbootsss.service;

import com.example.springbootsss.pojo.Resume;
import java.util.List;

public interface ResumeService {
    List<Resume> queryResumeList() throws Exception;

    Resume updateEntity(Resume resume);

    void deleteEntity(Long id);
}
