package com.mam.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 具体聚合角色
 **/
public class StudentAggregateImpl implements StudentAggregate{

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
