package chapter1;
import chapter1.question05;

import java.util.*;

/**
 * Created by yuta on 2017/07/01.
 */
/*
問6:"paraparaparadise"と"paragraph"に含まれる文字bi-gramの集合を，それぞれ, XとYとして求め，XとYの和集合，積集合，差集合を求めよ．
さらに，'se'というbi-gramがXおよびYに含まれるかどうかを調べよ
 */
public class question06 {
    public static void main(String[] args) {
        String str1= "paraparaparadise";
        String str2= "paragraph";
        String str ="se";
        int number=2;
        Set<String> set = new HashSet<>();
        Map<String,Integer> nGramMap1 = new HashMap<>();
        Map<String,Integer> nGramMap2 = new HashMap<>();


        nGramMap1 = question05.charNgram(number,str1);
        nGramMap2 = question05.charNgram(number,str2);

        //set = union(nGramMap1,nGramMap2);
        //set = intersection(nGramMap1,nGramMap2);
        //set = difference(nGramMap1,nGramMap2);
        charSurvey(nGramMap1,nGramMap2,str);

        for(int i=0; i < set.size(); i ++){
            String key = set.toArray(new String[0])[i];
            System.out.println(key);
        }

    }

    static Set<String> union(Map<String,Integer> nGramMap1,Map<String,Integer> nGramMap2){
        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();

        xSet.addAll(nGramMap1.keySet());
        ySet.addAll(nGramMap2.keySet());

        for(int i=0; i < ySet.size(); i ++){
            String key = ySet.toArray(new String[0])[i];
            if(xSet.contains(key)){

            }
            else {
                xSet.add(key);
            }
        }
        return xSet;
    }
    static Set<String> intersection(Map<String,Integer> nGramMap1,Map<String,Integer> nGramMap2){
        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();
        Set<String> set = new HashSet<>();
        xSet.addAll(nGramMap1.keySet());
        ySet.addAll(nGramMap2.keySet());

        for(int i=0; i < ySet.size(); i ++){
            String key = ySet.toArray(new String[0])[i];
            if(xSet.contains(key)){
                set.add(key);
            }
            else {
            }
        }
        return set;
    }

    static Set<String> difference(Map<String,Integer> nGramMap1,Map<String,Integer> nGramMap2){
        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();
        Set<String> set = new HashSet<>();
        xSet.addAll(nGramMap1.keySet());
        ySet.addAll(nGramMap2.keySet());

        if(xSet.size() > ySet.size()){
            for(int i=0; i < xSet.size(); i ++){
                String key = xSet.toArray(new String[0])[i];
                if(ySet.contains(key)){
                }
                else {
                    set.add(key);
                }
            }
        }else if(xSet.size() < ySet.size()){
            for(int i=0; i <= ySet.size(); i ++){
                String key = ySet.toArray(new String[0])[i];
                if(xSet.contains(key)){
                }
                else {
                    set.add(key);
                }
            }
        }else{
        }
        return set;
    }
    static void charSurvey(Map<String,Integer> nGramMap1,Map<String,Integer> nGramMap2,String str){
        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();
        xSet.addAll(nGramMap1.keySet());
        ySet.addAll(nGramMap2.keySet());

        if(xSet.contains(str)){
            System.out.println("Xに含まれています");
        }else if(ySet.contains(str)){
            System.out.println("Yに含まれています");
        }else {
            System.out.println("どちらにもありません");
        }
    }
}
