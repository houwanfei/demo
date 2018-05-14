//package com.example.demo.test;

/**
 * @auther houwanfei
 * @create 2018-05-14 下午2:07
 *
 *
 * java -Xmx3G -Xmn2G -server -XX:-DoEscapeAnalysis JVM 关闭逃逸分析优化
 * java -Xmx3G -Xmn2G -server -XX:-TieredCompilation JVM 关闭分层编译
 * java -Xmx3G -Xmn2G -server -XX:CompileThreshold=5000 设置编译阈值
 * java -Xmx3G -Xmn2G -server -XX:CompileThreshold=1 -XX:-TieredCompilation -XX:-BackgroundCompilation JVM 开启同步编译
 */
public class JVM {
    private static int fn(int i){
        User user = new User(i);
        return user.getAge();
    }

    public static void main(String[] args) throws Exception {
        int sum = 0;
        int count = 1000000;

        for (int i = 0; i < count; i++){
            sum += fn(i);
        }

        Thread.sleep(500);

        for (int i = 0; i < count; i++){
            sum += fn(i);
        }
        System.in.read();
    }
}

class User{
    private final int age;

    public User(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}

class Age{
    private final int age1;

    private final int age2;

    public Age(int age){
        this.age1 = age;
        this.age2 = age;
    }

    public int getAge1(){
        return this.age1;
    }

    public int getAge2(){
        return this.age2;
    }
}
