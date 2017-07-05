package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問17
1列目の文字列の種類（異なる文字列の集合）を求めよ
 */
public class question17 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        List<String> list;
        list = textset(filepath);

        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
    public static List<String> textset(String filepath){
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            line = br.readLine();

            while(line != null){
                String[] linelist = line.split("\t");

                if(list.contains(linelist[0])){

                }else {
                    list.add(linelist[0]);
                }

                line = br.readLine();
            }

            br.close();
            //pw.close();

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }

        return list;
    }
}
