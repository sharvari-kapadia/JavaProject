package com.mindsmapped.hw1;


public class Q2VariableScope extends Q2TestProtected {
    public Q2VariableScope() {
        System.out.println(rollno);
        printRollNo();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Q2VariableScope obj = new Q2VariableScope();
        // System.out.println(obj.rollno);
        // obj.printRollNo();

        Q2TestProtected obj1 = new Q2TestProtected();
        // System.out.println(obj1.rollno);
        // obj1.printRollNo();
    }

}

/*
 * instance variable rollNo and method printRollNo() of obj and obj1 - both are
 * protected so cannot be accessed directly (commented lines 10, 11, 14, 15) The
 * output prints "hello" two times - one from sysout of VariableScope
 * constructor of obj1 and another by accessing printRollNo() method in obj1
 * constructor
 */
