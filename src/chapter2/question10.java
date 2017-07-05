package chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuta on 2017/07/03.
 */
/*
問10
行数をカウントせよ．確認にはwcコマンドを用いよ
 */
public class question10 {
    public static void main(String[] args) {
        String filepath = "res/hightemp.txt";
        long count = lineCount(filepath);
        System.out.println(count);

    }
    public static long lineCount(String filepath){
        long linecount = 0;

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();

            while(line != null){
                linecount++;
                line = br.readLine();
            }

            br.close();


        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }

        return linecount;
    }
}
