package chapter2;

import java.io.*;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問12
各行の1列目だけを抜き出したものをcol1.txtに，2列目だけを抜き出したものをcol2.txtとしてファイルに保存せよ．
 */
public class question12 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        String outfilepath1 = "res/col1.txt";
        String outfilepath2 = "res/col2.txt";
       // System.out.println(count);

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            File outfile1 = new File(outfilepath1);
            File outfile2 = new File(outfilepath2);
            outfile1.createNewFile();
            outfile2.createNewFile();
            PrintWriter pw1 = new PrintWriter(outfile1);
            PrintWriter pw2 = new PrintWriter(outfile2);
            String line;


            line = br.readLine();

            while(line != null){
                String[] linelist = line.split("\t");
                pw1.println(linelist[0]);
                pw2.println(linelist[1]);
                line = br.readLine();
            }

            pw1.close();
            pw2.close();
            br.close();


        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
