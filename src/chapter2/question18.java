package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問18
各行を3コラム目の数値の逆順で整列せよ（注意: 各行の内容は変更せずに並び替えよ）
 */
public class question18 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        reversesort(filepath);

    }

    public static void reversesort(String filepath){

        List<Parameters> list = new ArrayList<>();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //String newline;

            line = br.readLine();

            while(line != null){
                String[] linelist = line.split("\t");
                double temperature = Double.parseDouble(linelist[2]);
                list.add(new Parameters(temperature,line));
                line = br.readLine();
            }

            Collections.sort(list);
            br.close();
            //pw.close();

            for(Parameters parameters: list){
                System.out.println(parameters.line);
            }

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

class Parameters implements Comparable<Parameters>{
    String line;
    double temperature;

    public Parameters(double temperature,String line){
        this.line=line;
        this.temperature=temperature;
    }
    public String line(){
        return line;
    }
    public double temperature(){
        return temperature;
    }

    @Override
    public int compareTo(Parameters p){
        if(this.temperature() >= p.temperature()){
            return 1;
        }else if(this.temperature() < p.temperature()){
            return -1;
        }else {
            return 0;
        }

    }


}
