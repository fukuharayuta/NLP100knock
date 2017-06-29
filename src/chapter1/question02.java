package chapter1;

import java.util.ArrayList;

/**
 * Created by yuta on 2017/06/29.
 */
public class question02 {
    public static void main(String[] args) {
        String str = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics.";
        StringBuffer sb = new StringBuffer();
        String newstr = str.replace(",","").replace(".", "");
        String[] strlist = newstr.split(" ");

        for(int i=0; i < strlist.length; i++){
            sb.append(strlist[i].length());
        }
       System.out.println(sb.toString());
    }
}
