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
問22
記事のカテゴリ名を（行単位ではなく名前で）抽出せよ
 */
public class question22 {
    public static void main(String[] args) {
        String filepath = "res/jawiki-uk.json";
        String regex =".*\\[\\[Category:(.*?)(?:\\|.*)?\\]\\].*";
        jsoncategorynamesearch(filepath,regex);
    }
    public static void jsoncategorynamesearch(String filepath,String regex){
        ObjectMapper mapper = new ObjectMapper();
        Pattern p = Pattern.compile(regex);
        Matcher matcher;

        try {
            JsonNode root = mapper.readTree(new File(filepath));
            matcher = p.matcher(root.get("text").asText());
            while (matcher.find()){
                System.out.println(matcher.group(1));
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
