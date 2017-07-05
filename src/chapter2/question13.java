package chapter2;

import java.io.*;

/**
 * Created by yuta on 2017/07/05.
 */
/*
問13
12で作ったcol1.txtとcol2.txtを結合し，元のファイルの1列目と2列目をタブ区切りで並べたテキストファイルを作成せよ
 */
public class question13 {
    public static void main(String[] args) {
        String filepath1 = "res/col1.txt";
        String filepath2 = "res/col2.txt";
        String outfilepath = "res/marge_12.txt";

        margetext(filepath1,filepath2,outfilepath);
    }

    public static void margetext(String filepath1,String filepath2,String outfilepath)
    {

        try{
            FileReader fr1 = new FileReader(filepath1);
            FileReader fr2 = new FileReader(filepath2);
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);
            File outfile = new File(outfilepath);
            outfile.createNewFile();
            PrintWriter pw = new PrintWriter(outfile);
            String line1;
            String line2;


            line1 = br1.readLine();
            line2 = br2.readLine();

            while(line1 != null && line2 != null){

                pw.println(line1 + "\t" + line2);
                line1 = br1.readLine();
                line2 = br2.readLine();
            }

            pw.close();
            br1.close();
            br2.close();


        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }


    }

}
