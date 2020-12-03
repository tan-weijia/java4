# java4
实验五

计G202--2020322101谭唯佳
# 阅读程序
## 实验目的
```
1.掌握字符串String及其方法的使用； 
2.掌握文件的读取/写入方法；
3.掌握异常处理结构。
```
## 实验要求
```
1.设计学生类;
2.采用交互式方式实例化某学生；
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。
```
## 实验内容
```
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
文件A包括两部分内容：
一是学生的基本信息；
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”。
2.允许提供输入参数，统计古诗中某个字或词出现的次数。
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A。
4.考虑操作中可能出现的异常，在程序中设计异常处理程序。
文件B：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池
温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳
丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处
闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行
```
## 核心代码

1.读取文本
```
File file = new File("B.txt");    //读取文本
        FileInputStream fis = new FileInputStream(file);
        ByteOutputStream bos = new ByteOutputStream();
```
2.写入文本
```
FileReader in = new FileReader(file);  
            FileWriter out = new FileWriter("A.txt");
            
Student st = new Student();
            char[] b = st.x().toCharArray();
            out.write(b);                   //输出学生信息到文件
            out.write("\n");
            char[] c = new char[(int) file.length()];
            in.read(c);
            for (int i=7,x=0; i<=14*17;i+=7,x+=7) { //添加标点符号，输出诗句到文件
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
```
4.统计字符出现次数和异常处理
```
try{                                        //查找字符出现次数
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
        }catch (Exception e){                         //异常处理
            System.out.println("错误");
        }finally {
                    fis.close();
                    bos.close();
        }
```
## 实验结果

![image](https://github.com/tan-weijia/java4/blob/main/Java%E5%AE%9E%E9%AA%8C5.png)

## 实验感想
```
在本次实验中，掌握了字符串String及其方法的使用和文件的读取/写入方法。同时由于前边尝试使用过异常处理结构，这次也更加熟悉了异常处理结构的编写。
在本次实验中最大的难题是文件的写入，尝试多次后依旧不成功，最后在同学的帮助下成功完成了文件写入。实验过程中学习到很多也收获了很多，在接下来的学
习中会更加努力。
```
