package chapter1;

/**
 * Created by yuta on 2017/06/29.
 */
public class question03 {
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
