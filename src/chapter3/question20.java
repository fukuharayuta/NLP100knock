package chapter3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.tools.ant.Info;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Map;

import org.json.JSONException;


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
        String outfilepath="res/jawiki-uk.json";
        String regex="イギリス";


        jsoncountrysearch(filepath,outfilepath,regex);


    }


    public static void jsoncountrysearch(String filepath,String outfilepath,String regex){
        ObjectMapper mapper = new ObjectMapper();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            File file = new File(outfilepath);
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);

            String line;
            line = br.readLine();

            while(line != null){
                JsonNode root = mapper.readTree(line);

                if(root.get("title").asText().equals(regex)){

                    System.out.println(root.get("text").asText());
                    pw.println(line);

                }
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
