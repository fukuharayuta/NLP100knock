package chapter3;

import com.oracle.javafx.jmx.json.JSONException;

import com.oracle.javafx.jmx.json.JSONFactory;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuta on 2017/07/07.
 */
/*
問20
Wikipedia記事のJSONファイルを読み込み，「イギリス」に関する記事本文を表示せよ
 */
public class question20 {
    public static void main(String[] args) {
        String filepath = "res/jawiki-country.json";
        String json;
        json = fileread(filepath);
       // System.out.println(json);

    }
    public static void jsonparse(String json){

        //JSONFactory jsonFactory = new JSONFactory();

        try {
            //JSONObject jsonObject = new JSONObject();
            //JSONArray jsonArary = new JSONArray();

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static String fileread(String filepath){
        String json ="";

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            line = br.readLine();

            while(line != null){
                json = json + line;
                line = br.readLine();
            }
            br.close();


        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }
        return json;
    }
}
