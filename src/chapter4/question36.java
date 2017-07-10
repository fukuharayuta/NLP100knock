package chapter4;

import java.util.*;

/**
 * Created by yuta on 2017/07/10.
 */
/*
文章中に出現する単語とその出現頻度を求め，出現頻度の高い順に並べよ
 */
public class question36 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";
        wordfrequency(filepath);

    }
    public static void wordfrequency(String filepath) {
        Map<String,Integer> wordfrequencymap = new HashMap<>();
        ArrayList<Dictionary> arrayList;
        question30 q30 = new question30();
        arrayList = q30.mecabreader(filepath);
        StringBuilder sb = new StringBuilder();
        String pos;
        String surface;
        int flag=0;

        for (int i = 0; i < arrayList.size(); i++) {
            pos = arrayList.get(i).pos;
            surface = arrayList.get(i).surface;

            if(wordfrequencymap.containsKey(surface)){
                wordfrequencymap.put(surface,wordfrequencymap.get(surface) + 1);
            }
            else if(! surface.equals("\\s")){
                wordfrequencymap.put(surface,1);
            }else{

            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(wordfrequencymap.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String,Integer> entry: list_entries){
            System.out.println("word:" + entry.getKey() + "  freqency:" + entry.getValue());
        }
    }
}
