package IO;

import java.io.*;

public class MarkedJs {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\文件\\文件\\java笔记\\java设计模式\\建造者模式builder.md");
        InputStream in = null;
        OutputStream out=null;
        String result="";
        try {
            in = new FileInputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\文件\\文件\\java笔记\\java设计模式\\builderResult.txt")),
                    "UTF-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line=null;
            while ((line = br.readLine()) != null) {
                result+=line+"\n";
                bw.write(line);
                bw.newLine();
            }
//            System.out.println(result);
            in.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void  getFileName(){

    }
}
