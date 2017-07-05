package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問15
自然数Nをコマンドライン引数などの手段で受け取り，入力のうち末尾のN行だけを表示せよ
 */
public class question15 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        int argument = Integer.valueOf(args[0]);
        tailprint(filepath,argument);

    }

    public static void tailprint(String filepath,int argument){

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            //File outfile = new File(outfilepath);
            //outfile.createNewFile();
            //PrintWriter pw = new PrintWriter(outfile);
            String line;
            String newline;
            line = br.readLine();

            while(line != null){
                newline = line.substring(line.length() - argument,line.length());
                System.out.println(newline);
                //pw.println(newline);
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
