package chapter1;

import java.text.Format;
import java.text.MessageFormat;

/**
 * Created by yuta on 2017/07/02.
 */
/*
問7:引数x, y, zを受け取り「x時のyはz」という文字列を返す関数を実装せよ．
さらに，x=12, y="気温", z=22.4として，実行結果を確認せよ．
 */
public class question07 {
    public static void main(String[] args) {
        String message;
        String[] strlist = {"12","気温","22.4"};
        message = sentenceFormat(strlist);
        System.out.println(message);
    }

    public static String sentenceFormat(String[] strlist){
        String message;
        String str="{0}時の{1}は{2}";
        Format sentenceformat= new MessageFormat(str);
        message = sentenceformat.format(strlist);

        return message;
    }
}
