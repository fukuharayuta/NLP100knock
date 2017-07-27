package chapter3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuta on 2017/07/07.
 */
/*
問23
記事中に含まれるセクション名とそのレベル（例えば"== セクション名 =="なら1）を表示せよ
 */
public class question23 {
    public static void main(String[] args) {
        String filepath = "res/jawiki-uk.json";
        String regex ="(={2,})\\s*(.*?)\\1";
        //String match="=";
        char match = '=';
        //String regex ="(={2,})\\s*(.+?)\\s*\1.*";
        jsonsectionsearch(filepath,regex,match);
    }
    public static void jsonsectionsearch(String filepath,String regex,char match){
        ObjectMapper mapper = new ObjectMapper();
        Pattern p = Pattern.compile(regex);
        Matcher matcher;
        int counter=0;

        try {
            JsonNode root = mapper.readTree(new File(filepath));
            matcher = p.matcher(root.get("text").asText());

            while (matcher.find()){
                String line = matcher.group();
                for(char x: line.toCharArray()){
                    if(x == match){
                        counter++;
                    }
                }

                System.out.println("section:" + matcher.group(2) + " level:" + ((counter/2)-1));
                counter=0;
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
