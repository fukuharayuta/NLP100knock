package chapter4;

import org.chasen.mecab.MeCab;

import java.io.*;
import java.util.ArrayList;

import org.chasen.mecab.Tagger;
import org.chasen.mecab.Model;
import org.chasen.mecab.Lattice;
import org.chasen.mecab.Node;
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
        String filepath = "res/neko.txt";
        String outfilepath1="res/neko.txt.mecab";
        String outfilepath2="res/neko2.txt.mecab";
        //mecabtextcreate(filepath,outfilepath);
        //mecabtest();
        mecabreader(outfilepath2);
        //filesplit(outfilepath1,outfilepath2);
    }

    public static ArrayList<Dictionary> mecabreader(String filepath) {

        Dictionary dic;
        ArrayList<Dictionary> arrayList = new ArrayList<>();

        try {

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();

            while (line != null) {
                if(! line.equals("EOS")){

                    dic = new Dictionary();
                    line = line.replace("\t",",");
                    String[] linelist = line.split(",");
                    dic.surface = linelist[0];
                    dic.base = linelist[7];
                    dic.pos = linelist[1];
                    dic.pos1 = linelist[2];

//                    System.out.println("表層形:" + dic.surface);
//                    System.out.println("基本形:" + dic.base);
//                    System.out.println("品詞:" + dic.pos);
//                    System.out.println("品詞細分:" + dic.pos1);
//                    System.out.println();

                    arrayList.add(dic);
                    line = br.readLine();
                }
            }

            br.close();

            }catch(FileNotFoundException e){
                System.out.println(e);

            }catch(IOException e){
                System.out.println(e);
            }

        return arrayList;
    }
    public static void filesplit(String filepath,String outfilepath){

        int counter=0;

        try {

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            File file = new File(outfilepath);
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            String line;
            line = br.readLine();

            while (line != null) {
                if(counter < 10000){
                    counter++;
                    pw.println(line);

                }else {
                    break;
                }
                line = br.readLine();
            }
            pw.close();
            br.close();

        }catch(FileNotFoundException e){
            System.out.println(e);

        }catch(IOException e){
            System.out.println(e);
        }

    }

    public static void mecablink() {
        try {
            String filepath = "/usr/local/lib/mecab-java/libMeCab.so";
            File f = new File(filepath);
            System.load(f.toString());
            //System.loadLibrary("MeCab");

        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
            System.exit(1);
        }
    }
    public static void mecabtextcreate(String filepath,String outfilepath){


        mecablink();
        //StringBuilder sb = new StringBuilder();
        Tagger tagger = new Tagger();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            File file = new File(outfilepath);
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            String line;
            line = br.readLine();

            while(line != null){
                line = br.readLine();
                tagger.parse(line);
                Node node = tagger.parseToNode(line);

                for (; node != null; node = node.getNext()) {
                    pw.println(node.getSurface() + "\t" + node.getFeature());

                }
            }
            pw.close();
            br.close();

        }catch (FileNotFoundException e){
            System.out.println(e);

        }catch (IOException e){
            System.out.println(e);
        }


    }

    public static void mecabtest() {

        mecablink();
        System.out.println(MeCab.VERSION);
        Tagger tagger = new Tagger();
        String str = "太郎は二郎にこの本を渡した。";

        System.out.println(tagger.parse(str));
        Node node = tagger.parseToNode(str);
        for (; node != null; node = node.getNext()) {
            System.out.println(node.getSurface() + "\t" + node.getFeature());
        }
        System.out.println("EOS\n");

        Model model = new Model();
        Tagger tagger2 = model.createTagger();
        System.out.println(tagger2.parse(str));

        Lattice lattice = model.createLattice();
        System.out.println(str);
        lattice.set_sentence(str);
        if (tagger2.parse(lattice)) {
            System.out.println(lattice.toString());
            for (node = lattice.bos_node(); node != null; node = node.getNext()) {
                System.out.println(node.getSurface() + "\t" + node.getFeature());
            }
            System.out.println("EOS\n");
        }

        lattice.add_request_type(MeCab.MECAB_NBEST);
        lattice.set_sentence(str);
        tagger2.parse(lattice);

        for (int i = 0; i < 10; ++i) {
            if (lattice.next()) {
                System.out.println("nbest:" + i + "\n" + lattice.toString());
            }
        }
    }
}

class Dictionary{
    String surface;
    String base;
    String pos;
    String pos1;

}
