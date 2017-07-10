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
        nounconnect(filepath);

    }
    public static void nounconnect(String filepath) {
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

            if (flag==0 && pos.equals("名詞")) {
                flag=1;
                sb.append(surface);
            }
            else if (flag==1 && surface.equals("の")){
                flag=2;
                sb.append(surface);
            }else if(flag==2 && pos.equals("名詞")){
                sb.append(surface);
                System.out.println("AのB:" + sb.toString());
                flag=0;
                sb.delete(0,sb.length());
            }else {
                flag=0;
                sb.delete(0,sb.length());
            }

        }
    }
}
