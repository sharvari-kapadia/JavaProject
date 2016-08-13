/*
* input = {pots, car, stop, god, dog, bare, door, bear, balm, lamb, looped, man,poodle}
  output = {{pots, stop}, {dog, god}, {bare, bear}, {balm, lamb}, {looped, poodle}
* */

package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SKapadia on 7/20/2016.
 */
public class Anagrams {

    public ArrayList<ArrayList<String>> getAnagramsList(ArrayList<String> list) {

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ArrayList<String> tempList;
        String tempString;
        for(String string : list) {
            char[] stringAsCharArray = string.toCharArray();
            Arrays.sort(stringAsCharArray);
            tempString = new String(stringAsCharArray);
            if(hashMap.containsKey(tempString)) {
                tempList = hashMap.get(tempString);
                tempList.add(string);
                hashMap.put(tempString, tempList);
            } else {
                hashMap.put(tempString, new ArrayList<>(Arrays.asList(string)));
            }
        }

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        for(ArrayList<String> arrayList: hashMap.values()) {
            if(arrayList.size() > 1) {
                resultList.add(arrayList);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> resultList = new Anagrams().getAnagramsList(new ArrayList<>(Arrays.asList(
            "pots", "car", "stop", "god", "dog", "bare", "door", "bear", "balm", "lamb", "looped", "man", "poodle")));
        System.out.println(resultList.toString());
    }
}
