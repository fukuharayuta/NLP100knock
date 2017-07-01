package chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuta on 2017/06/30.
 */
/*
問5:与えられたシーケンス（文字列やリストなど）からn-gramを作る関数を作成せよ．
この関数を用い，"I am an NLPer"という文から単語bi-gram，文字bi-gramを得よ
 */
public class question05 {
    public static void main(String[] args) {
        String str="I am an NLPer";
        int number=2;
        Map<String,Integer> nGramMap = new HashMap<String, Integer>();

        //nGramMap=wordNgram(number,str);
        nGramMap=charNgram(number,str);

        Set<String> keys = nGramMap.keySet();
        for(int i=0; i < keys.size(); i ++){
            String key = keys.toArray(new String[0])[i];
            System.out.println(key + ":" + nGramMap.get(key));
        }
    }

    static Map<String,Integer> wordNgram(int number, String str){
        String[] strlist = str.split(" ",0);
        StringBuffer sb = new StringBuffer();
        Map<String,Integer> wordNgramMap = new HashMap<String, Integer>();
        int numberNgram= strlist.length - number + 1;

        for(int i=0;i < numberNgram; i++){

            for(int j=i; j < i + number; j++){
                sb.append(strlist[j]).append(" ");
            }

            sb.deleteCharAt(sb.length()-1);
            String word = sb.toString();
            sb.delete(0,sb.length());

            if(wordNgramMap.containsKey(word)){
                wordNgramMap.put(word,wordNgramMap.get(word)+1);

            }else{
                wordNgramMap.put(word,1);

            }
        }

        return wordNgramMap;
    }
    static Map<String,Integer> charNgram(int number,String str){
        String charstr=str.replace(" ","");
        StringBuffer sb = new StringBuffer();
        Map<String,Integer> charNgramMap = new HashMap<String, Integer>();
        int charNgramNumber = charstr.length() -number +1;
        //System.out.println(charstr);
        for(int i=0; i < charNgramNumber ; i++){

            //System.out.println(charstr.substring(i,i+number));
            sb.append(charstr.substring(i,i+number));
            String charword = sb.toString();
            sb.delete(0,sb.length());

            if(charNgramMap.containsKey(charword)){
                charNgramMap.put(charword,charNgramMap.get(charword)+1);
            }else {
                charNgramMap.put(charword,1);
            }

        }

        return charNgramMap;
    }
}
