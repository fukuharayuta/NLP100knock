package chapter4;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/07/08.
 */
/*
問33
サ変接続の名詞をすべて抽出せよ
 */
public class question33 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";
        nounoutput(filepath);

    }
    public static void nounoutput(String filepath) {
        ArrayList<Dictionary> arrayList;
        question30 q30 = new question30();
        arrayList = q30.mecabreader(filepath);
        String pos;
        String pos1;

        for (int i = 0; i < arrayList.size(); i++) {
            pos = arrayList.get(i).pos;
            pos1 = arrayList.get(i).pos1;
            if (pos.equals("名詞") && pos1.equals("サ変接続")) {
                System.out.println("サ変接続名詞:" + arrayList.get(i).surface);
            } else {

            }
        }
    }
}
