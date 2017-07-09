package chapter4;

import org.chasen.mecab.MeCab;

import java.io.File;

/**
 * Created by yuta on 2017/07/08.
 */
/*
問30
形態素解析結果（neko.txt.mecab）を読み込むプログラムを実装せよ．
ただし，各形態素は表層形（surface），基本形（base），品詞（pos），品詞細分類1（pos1）をキーとするマッピング型に格納し，
1文を形態素（マッピング型）のリストとして表現せよ
 */
public class question30 {
    public static void main(String[] args) {
        String filepath = "res/jawiki-country.json";
        //mecabtext();
        System.out.println(MeCab.VERSION);

    }
    public static void mecabtext(){
        try {
            System.loadLibrary("MeCab");

        }catch (UnsatisfiedLinkError e){
            System.err.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
            System.exit(1);

        }




    }

}
