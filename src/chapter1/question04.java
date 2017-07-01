package chapter1;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuta on 2017/06/30.
 */
/*
問4:"Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can."
という文を単語に分解し，1, 5, 6, 7, 8, 9, 15, 16, 19番目の単語は先頭の1文字，それ以外の単語は先頭に2文字を取り出し，
取り出した文字列から単語の位置（先頭から何番目の単語か）への連想配列（辞書型もしくはマップ型）を作成せよ
*/
public class question04 {
    public static void main(String[] args) {
        String str ="Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can.";
        str.replace(".","");
        String[] strlist = str.split(" ");
        String[] numlist ={"1","5","6","7","8","9","15","16","19"};
        String word;
        StringBuffer sb = new StringBuffer();

        for(int i=0; i < strlist.length; i++){
            if(i ==0 || i==4 || i==5 || i==6 || i==7 || i== 8 || i==14 ||
                    i == 15 || i==18)
            {
                word = strlist[i];
                sb.append(word.substring(0,1));
            }
            else{
                word = strlist[i];
                sb.append(word.substring(0,2));


            }
        }
        System.out.println(sb.toString());
    }


}
