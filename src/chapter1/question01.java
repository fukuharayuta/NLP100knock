package chapter1;

/**
 * Created by yuta on 2017/06/29.
 */
/*問2：「パタトクカシーー」という文字列の1,3,5,7文字目を取り出して連結した文字列を得よ*/

public class question01 {
    public static void main(String[] args) {
        String str ="パタトクカシーー";
        StringBuffer sb = new StringBuffer();

        for(int i=0; i < str.length(); i++){
            if(i % 2 == 0){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
