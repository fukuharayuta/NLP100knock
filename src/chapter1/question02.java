package chapter1;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/06/29.
 */
/*問3：「パトカー」＋「タクシー」の文字を先頭から交互に連結して文字列「パタトクカシーー」を得よ*/

public class question02 {
    public static void main(String[] args) {
        String str1 = "パトカー";
        String str2 = "タクシー";
        StringBuffer sb = new StringBuffer();

        for(int i=0; i < str1.length(); i++){
            sb.append(str1.substring(i,i+1));
            sb.append(str2.substring(i,i+1));
        }
        System.out.println(sb.toString());
    }
}
