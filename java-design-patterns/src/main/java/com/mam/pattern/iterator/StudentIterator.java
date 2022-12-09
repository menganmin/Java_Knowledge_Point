package com.mam.pattern.iterator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 抽象迭代器角色
 **/
public interface StudentIterator {

    //判断是否还有元素
    public boolean hasNext();
    //获取下一个元素
    public Student next();
}
