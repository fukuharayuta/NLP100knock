package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問16
自然数Nをコマンドライン引数などの手段で受け取り，入力のファイルを行単位でN分割せよ
 */
public class question16 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        int argument = Integer.valueOf(args[0]);

        argumentsplit(filepath,argument);

    }
    public static void argumentsplit(String filepath,int argument){
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] newlinelist ={""};
            int textlength;
            int splitnumber;
            int counter=0;
            line = br.readLine();

            while(line != null){
                textlength = line.length();
                splitnumber = textlength / argument;

                //System.out.println(splitnumber);

                for(int i=0; i < textlength; i = i + splitnumber){
                    System.out.println(line.substring(i,Math.min(textlength,i + splitnumber)));
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

    }
}
