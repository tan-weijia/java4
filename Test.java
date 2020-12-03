
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Scanner;

public class Test {


    public static void main(String args[])throws Exception{

        File file = new File("B.txt");
        FileInputStream fis = new FileInputStream(file);
        ByteOutputStream bos = new ByteOutputStream();


        try{                            //查找字符出现次数
                int len;
                byte[] data = null;
                byte[] buffer = new byte[(int) file.length()];

                while ((len=fis.read(buffer))!=-1){
                    bos.write(buffer,0,len);
                }

                data = bos.toByteArray();
                String str = new String(data);

                int count=0;
                Scanner sc = new Scanner(System.in);
                System.out.println("输入你要查找的字或词：");
                char o = sc.next().charAt(0);
                char[] ch =str.toCharArray();
                for(int i=0;i<ch.length;i++){
                    if(o==ch[i]){
                        count++;
                    }

                }

                System.out.println("你输入的字或词在诗中出现过"+count+"次。");
                System.out.println("");
                    fis.close();
                    bos.close();
        }catch (Exception e){
            System.out.println("错误");
        }finally {
                    fis.close();
                    bos.close();
        }

            FileReader in = new FileReader(file);
            FileWriter out = new FileWriter("A.txt");


        try {
            Student st = new Student();
            char[] b = st.x().toCharArray();
            out.write(b);                   //输出学生信息到文件
            out.write("\n");

            char[] c = new char[(int) file.length()];

            in.read(c);

            for (int i=7,x=0; i<=14*17;i+=7,x+=7) { //输出诗句到文件

                if (i % 2 == 0) {
                    for (int j = x; j < i; j++) {
                        out.write(c[j]);
                    }
                    out.write("。\n");

                } else {
                    for (int j = x; j < i; j++) {
                        out.write(c[j]);
                    }
                    out.write(",");

                }
            }
        }catch (IOException e){
            System.out.println("错误");
        }finally {

                in.close();
                out.close();
        }

    }

}

