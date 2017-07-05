package chapter2;

import java.io.*;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問14
自然数Nをコマンドライン引数などの手段で受け取り，入力のうち先頭のN行だけを表示せよ
 */
public class question14 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        //String outfilepath = "res/question14.txt";
        int argument = Integer.valueOf(args[0]);
        headprint(filepath,argument);


    }

    public static void headprint(String filepath,int argument){

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String newline;
            line = br.readLine();

            while(line != null){
                newline = line.substring(0,argument);
                System.out.println(newline);
                //pw.println(newline);
                line = br.readLine();
            }

            br.close();

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }


    }

}
