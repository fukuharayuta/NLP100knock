package chapter4;


import java.util.ArrayList;

/**
 * Created by yuta on 2017/07/08.
 */
/*
問31
動詞の表層形をすべて抽出せよ
 */
public class question31 {
    public static void main(String[] args) {
        String filepath = "res/neko2.txt.mecab";
        verbsoutput(filepath);
        // System.out.println(json);

    }
    public static void verbsoutput(String filepath){
        ArrayList<Dictionary> arrayList = new ArrayList<>();
        question30 q30 = new question30();
        arrayList = q30.mecabreader(filepath);
        String pos;

        for (int i =0; i <arrayList.size(); i++){
            pos = arrayList.get(i).pos;
            //System.out.println(pos);
            if(pos.equals("動詞")){
                System.out.println("表層形:" + arrayList.get(i).surface);
            }
            else{

            }
        }
    }
}
