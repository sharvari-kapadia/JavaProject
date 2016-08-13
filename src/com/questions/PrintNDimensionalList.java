package com.questions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 7/19/2016.
 */
public class PrintNDimensionalList {

    public void dumpList(ArrayList<Object> list, String string) {

        _dumpList(list, string, new ArrayList<>());
    }

    private void _dumpList(ArrayList<Object> list, String string, ArrayList<Integer> prefix) {

        for(int i = 0; i < list.size(); i++) {
            prefix.add(i);
            Object object = list.get(i);
            if(object instanceof String) {
                print(string, prefix, (String)object);
            } else if(object instanceof ArrayList) {
                _dumpList((ArrayList) object, string, prefix);
            }
            prefix.remove(prefix.size() - 1);
        }
    }

    private void print(String string, ArrayList<Integer> prefix, String item) {

        StringBuffer toPrint = new StringBuffer(string);
        for(int i : prefix) {
            toPrint.append("." + i);
        }
        toPrint.append(": " + item);
        System.out.println(toPrint);
    }

    public static void main(String[] args) {


        ArrayList<Object> object = new ArrayList<>();
        object.add("a string");
        object.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
        object.add("spam");
        object.add(new ArrayList<>(Arrays.asList("eggs")));

        ArrayList<Object> object2 = new ArrayList<>();
        object2.add(new ArrayList<>(Arrays.asList("a1", "b1", "c1")));
        object2.add(new ArrayList<>(Arrays.asList("a2", "b2", "c2")));

        object.add(object2);

        new PrintNDimensionalList().dumpList(object, "Foo");
    }
}
