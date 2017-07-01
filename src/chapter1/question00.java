package chapter1;

/**
 * Created by yuta on 2017/06/29.
 */

/*問１：文字列"stressed"の文字を逆に（末尾から先頭に向かって）並べた文字列を得よ*/
public class question00 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("stressed");
        System.out.println(sb.reverse());
    }
}
