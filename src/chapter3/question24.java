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
問24
記事から参照されているメディアファイルをすべて抜き出せ
 */
public class question24 {
    public static void main(String[] args) {
        String filepath = "res/jawiki-uk.json";
        String regex ="(?:File|ファイル):(.*?)\\|";
        mediafilesearch(filepath,regex);
    }

    public static void mediafilesearch(String filepath,String regex){
        ObjectMapper mapper = new ObjectMapper();
        Pattern p = Pattern.compile(regex);
        Matcher matcher;

        try {
            JsonNode root = mapper.readTree(new File(filepath));
            matcher = p.matcher(root.get("text").asText());

            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
