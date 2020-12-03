import java.util.Scanner;

class Student {

    String name;
    int stuNum;
    int age;

    public String x() {

        Scanner sc= new Scanner(System.in);

        System.out.println("输入姓名：");
        name=sc.next();

        System.out.println("输入学号：");
        stuNum=sc.nextInt();

        System.out.println("输入年龄：");
        age=sc.nextInt();

        String str="姓名:"+name+" 学号:"+stuNum+" 年龄:"+age;
        return str;


    }

}