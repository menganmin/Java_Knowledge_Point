package com.mam.pattern.iterator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 迭代器模式
 **/
public class Client {
    public static void main(String[] args) {
        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("小白","1"));
        studentAggregate.addStudent(new Student("小红","2"));
        studentAggregate.addStudent(new Student("小蓝","3"));
        studentAggregate.addStudent(new Student("小老弟","4"));

        //获取迭代器
        StudentIterator iterator = studentAggregate.getStudentIterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
