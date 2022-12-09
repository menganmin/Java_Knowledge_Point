package com.mam.pattern.iterator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 抽象聚合角色
 **/
public interface StudentAggregate {

    //添加学生功能
    public void addStudent(Student student);

    //删除学生功能
    public void removeStudent(Student student);

    //创建遍历器对象
    StudentIterator getStudentIterator();
}
