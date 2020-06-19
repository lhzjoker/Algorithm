package com.lhz.Algorithm;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/17 12:11
 * Comparable接口，测试对象类型比较
 */
public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student that) {
        if (this.score < that.score) {
            return -1;
        } else if (this.score > that.score) {
            return 1;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}
