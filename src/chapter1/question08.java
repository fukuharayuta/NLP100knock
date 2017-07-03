package chapter1;

import java.io.UnsupportedEncodingException;

/**
 * Created by yuta on 2017/07/03.
 */
/*
問8
与えられた文字列の各文字を，以下の仕様で変換する関数cipherを実装せよ．
英小文字ならば(219 - 文字コード)の文字に置換
その他の文字はそのまま出力
この関数を用い，英語のメッセージを暗号化・復号化せよ．
 */
public class question08 {
    public static void main(String[] args) {
        String message = "Message";
        String newmessage;

        /*暗号化*/
        newmessage = cipher(message);
        System.out.println("暗号化:" + newmessage);

        /*復号化*/
        newmessage = cipher(newmessage);
        System.out.println("復号化:" + newmessage);
    }

    public static String cipher(String message){
        int code;
        char newchar;
        StringBuffer sb = new StringBuffer();
        sb.append(message);

        for(int i=0; i < message.length(); i++){

            if(Character.isLowerCase(sb.charAt(i))){
                //System.out.println("char=" + sb.charAt(i));
                code = sb.codePointAt(i);
                code = 219 - code;
                newchar = (char)code;
                //System.out.println("newchar=" + newchar);
                sb.deleteCharAt(i);
                sb.insert(i,newchar);
            }else{

            }

        }

        return sb.toString();
    }
}
