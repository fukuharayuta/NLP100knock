package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問19
各行の1列目の文字列の出現頻度を求め，その高い順に並べて表示せよ
 */
public class question19 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        frequencysort(filepath);

    }
    public static void frequencysort(String filepath){

        Map<String,Integer> map = new HashMap<>();
        //Map<Map<String,Integer>,String> sortmap = new HashMap<>();
        //List<FrequencySortParameters> list = new ArrayList<>();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String prefecture;
            FrequencySortParameters fsp;
            line = br.readLine();

            while(line != null){
                prefecture = line.split("\t")[0];

                if(map.containsKey(prefecture)){
                    map.put(prefecture,map.get(prefecture)+1);
                }else {
                    map.put(prefecture,1);
                }


                line = br.readLine();
            }


            ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

            //Collections.sort(list);
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return ((Integer)o2.getValue()).compareTo(((Integer) o1.getValue()));
                }
            });


            for(Map.Entry<String,Integer> entry: list){
                System.out.println(entry);
            }



            br.close();
            //pw.close();

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
class FrequencySortParameters implements Comparable<FrequencySortParameters> {

    int counter;
    String prefecture;
    String line;

    public FrequencySortParameters(String line,String prefecture,int counter) {
        //this.Pmap = Pmap;
        this.prefecture = prefecture;
        this.counter = counter;
        this.line = line;
    }

    public int counter() {
        return counter;
    }

    public String prefecture(){
        return prefecture;
    }

    public String line() {
        return line;
    }

    @Override
    public int compareTo(FrequencySortParameters fsp) {
        if (this.counter() >= fsp.counter()) {
            return 1;
        } else if (this.counter() < fsp.counter()) {
            return -1;
        } else {
            return 0;
        }
    }

}
