package chapter2;

import java.io.*;

/**
 * Created by yuta on 2017/07/04.
 */
/*
問11
タブ1文字につきスペース1文字に置換せよ
 */
public class question11 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        String outfilepath="res/hightemp2.txt";

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            File file = new File(outfilepath);
            file.createNewFile();
            //FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(file);
            String line;
            line = br.readLine();

            while(line != null){
                //line.replace("\t"," ");
                pw.println(line.replace("\t"," "));
                line = br.readLine();
            }


            br.close();
            pw.close();

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }


    }
}
