package com.mam.pattern.iterator;

import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 具体迭代器角色
 **/
public class StudentIteratorImpl implements StudentIterator{

    private List<Student> list;
    //用来记录遍历时的位置
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        //从集合中获取下标位置
        Student student = list.get(position);
        position++;
        return student;
    }
}
