package chapter4;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/07/08.
 */
/*
問32
動詞の原形をすべて抽出せよ
 */
public class question32 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";
        verbsbaseoutput(filepath);

    }

    public static void verbsbaseoutput(String filepath) {
        ArrayList<Dictionary> arrayList;
        question30 q30 = new question30();
        arrayList = q30.mecabreader(filepath);
        String pos;
        for (int i = 0; i < arrayList.size(); i++) {
            pos = arrayList.get(i).pos;
            //System.out.println(pos);
            if (pos.equals("動詞")) {
                System.out.println("原形:" + arrayList.get(i).base);
            } else {

            }
        }
    }
}
