package chapter1;

/**
 * Created by yuta on 2017/06/29.
 */
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
