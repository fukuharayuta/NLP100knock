package chapter3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuta on 2017/07/07.
 */
/*
問25
記事中に含まれる「基礎情報」テンプレートのフィールド名と値を抽出し，辞書オブジェクトとして格納せよ
 */
public class question25 {
    public static void main(String[] args) {
        Map<String,String> dictionary = new HashMap<>();
        String filepath = "res/jawiki-uk.json";
        String regex ="\\{\\{基礎情報.*([\\s\\S]*?)\\}\\}\\n";
        String regexdata="\\|(.*?)\\s*(=)\\s*(.*?)(?:(?=\\n\\|)|(?=\\n))";
        dictionary = templatesearch(filepath,regex,regexdata);

        for(Map.Entry<String,String> entry: dictionary.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public static Map<String,String> templatesearch(String filepath, String regex, String regexdata){
        Map<String,String> dictionary = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Pattern p = Pattern.compile(regex);
        Pattern p2 = Pattern.compile(regexdata);
        Matcher matcher;

        try {
            JsonNode root = mapper.readTree(new File(filepath));
            matcher = p.matcher(root.get("text").asText());

            while (matcher.find()) {
                //System.out.println(matcher.group(1));
                matcher = p2.matcher(matcher.group(1));

                while(matcher.find()){
                    dictionary.put(matcher.group(1),matcher.group(3));
                    //System.out.println(matcher.group(1) + " = "  + matcher.group(3));
                }
            }


        }catch (IOException e){
            e.printStackTrace();
        }

        return dictionary;

    }
}
