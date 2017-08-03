package chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuta on 2017/07/07.
 */
/*
問26
25の処理時に，テンプレートの値からMediaWikiの強調マークアップ（弱い強調，強調，強い強調のすべて）を除去してテキストに変換せよ
（参考: マークアップ早見表）
 */
public class question26 {
    public static void main(String[] args) {

        Map<String,String> dictionary = new HashMap<>();
        String filepath = "res/jawiki-uk.json";
        String regex ="\\{\\{基礎情報.*([\\s\\S]*?)\\}\\}\\n";
        String regexdata="\\|(.*?)\\s*(=)\\s*(.*?)(?:(?=\\n\\|)|(?=\\n))";
        String markupregex = "'''";
        dictionary = question25.templatesearch(filepath,regex,regexdata);


    }
    public static void markupdelete(Map<String,String> dictionary,String markupregex){

        for(Map.Entry<String,String> entry: dictionary.entrySet()){

        }
    }
}
