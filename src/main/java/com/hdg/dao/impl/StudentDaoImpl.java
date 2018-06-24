package com.hdg.dao.impl;

import com.hdg.dao.IStudentDao;
import com.hdg.model.Student;

public class StudentDaoImpl implements IStudentDao{


    @Override
    public void save(Student student) {
        System.out.println("---保存数据---");
        System.out.println(student);
        System.out.println("---保存成功---");
    }
}
