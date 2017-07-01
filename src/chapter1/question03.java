package chapter1;

/**
 * Created by yuta on 2017/06/29.
 */

/*
問3:Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics.""
        "という文を単語に分解し，各単語の（アルファベットの）文字数を先頭から出現順に並べたリストを作成せよ
*/

public class question03 {
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
