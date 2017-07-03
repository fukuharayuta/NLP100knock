package chapter1;

import java.util.*;

/**
 * Created by yuta on 2017/07/03.
 */
/*
問9
スペースで区切られた単語列に対して，各単語の先頭と末尾の文字は残し，それ以外の文字の順序をランダムに並び替えるプログラムを作成せよ．
ただし，長さが４以下の単語は並び替えないこととする．
適当な英語の文（例えば"I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind ."）を与え，
その実行結果を確認せよ．
 */
public class question09 {
    public static void main(String[] args) {
        String message="I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind .";
        String str;
        str = Ramdomsort(message);
        System.out.println(str);
    }

    public static String Ramdomsort(String message){
        String str = message.replace(":","").replace(".","").replace("  "," ");
        String[] strlist = str.split(" ");
        char charFirst;
        char charLast;
        StringBuffer sb = new StringBuffer();
        StringBuffer sb_new = new StringBuffer();


        for(int i=0; i < strlist.length; i++){

            if( 4 < strlist[i].length()){
                sb.append(strlist[i]);
                charFirst = sb.charAt(0);
                charLast = sb.charAt(sb.length()-1);

                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);


                List<Character> list = new ArrayList<>();

                for(int j=0; j < sb.length(); j++){
                    list.add(sb.charAt(j));
                }

                Collections.shuffle(list);
                sb.delete(0,sb.length());

                for (int k=0; k < list.size(); k++){
                    sb.append(list.get(k));
                }

                sb.insert(0,charFirst);
                sb.insert(sb.length(),charLast);

                sb_new.append(sb.toString()).append(" ");
                sb.delete(0,sb.length());


            }else{
                sb_new.append(strlist[i]).append(" ");

            }

        }

        sb_new.deleteCharAt(sb_new.length()-1);

        return sb_new.toString();
    }
}
