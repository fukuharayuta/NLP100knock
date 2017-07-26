package chapter3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.prism.impl.shape.NativePiscesRasterizer;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuta on 2017/07/07.
 */
/*
問21
記事中でカテゴリ名を宣言している行を抽出せよ
 */
public class question21 {
    public static void main(String[] args) {

        String filepath = "res/jawiki-uk.json";
        String regex ="(.+Category:.+)";
        jsoncategorysearch(filepath,regex);
    }

    public static void jsoncategorysearch(String filepath,String regex){
        ObjectMapper mapper = new ObjectMapper();
        Pattern p = Pattern.compile(regex);
        Matcher matcher;

        try {
            JsonNode root = mapper.readTree(new File(filepath));
            matcher = p.matcher(root.get("text").asText());
            while (matcher.find()){
                System.out.println(matcher.group());
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
