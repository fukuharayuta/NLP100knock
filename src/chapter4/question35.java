package chapter4;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/07/10.
 */
/*
問36
名詞の連接（連続して出現する名詞）を最長一致で抽出せよ
 */
public class question35 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";
        nounlongenst(filepath);

    }

    public static void nounlongenst(String filepath) {
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

            if (flag == 0 && pos.equals("名詞")) {
                //System.out.println("通りました");
                flag=1;
                sb.append(surface);
            }
            else if (flag >= 1 && pos.equals("名詞")){
                //System.out.println("通りました");
                flag=2;
                sb.append(surface);
            }
            else if(flag == 2 && ! pos.equals("名詞")){
                //System.out.println(pos);
                //System.out.println(flag);
                System.out.println("名詞最長連続:" + sb.toString());
                flag=0;
                sb.delete(0,sb.length());
            }
            else {
                flag=0;
                sb.delete(0,sb.length());
            }

        }
    }
}
