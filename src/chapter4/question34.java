package chapter4;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/07/10.
 */
/*
問34
2つの名詞が「の」で連結されている名詞句を抽出せよ
 */
public class question34 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";

    }
    public static void A_connect_B(String filepath) {
        ArrayList<Dictionary> arrayList;
        question30 q30 = new question30();
        arrayList = q30.mecabreader(filepath);
        StringBuilder sb = new StringBuilder();
        String pos;

        for (int i = 0; i < arrayList.size(); i++) {
            pos = arrayList.get(i).pos;
            //System.out.println(pos);
            if (pos.equals("名詞")) {

                
                System.out.println("表層形:" + arrayList.get(i).surface);
            }else {
            }
        }
    }
}
