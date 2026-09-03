package com.example.pgsqldemo.test;

import lombok.Data;

@Data
public class TeacherKu implements MyTeacherRun {

    private ArgumentTest.MyStudent myStudent;

    private String [] args;

    /*public TeacherKu(){}


    public TeacherKu(ArgumentTest.MyStudent myStudent){
        System.out.println("TeacherKu(MyStudent myStudent)");
        this.myStudent = myStudent;
    }*/

    public TeacherKu(ArgumentTest.MyStudent myStudent, String [] args){
        System.out.println("TeacherKu(MyStudent myStudent,String [] args)");
        this.myStudent = myStudent;
        this.args = args;
    }


    @Override
    public void printRun() {
        System.out.println(this.getClass().getName()+"="+myStudent.name);
    }
}
