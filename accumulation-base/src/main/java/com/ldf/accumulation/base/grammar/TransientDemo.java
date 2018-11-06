package com.ldf.accumulation.base.grammar;


import java.io.*;

/**
 * transient 关键字 测试用例
 * Created by ldf on 2018/11/5.
 */
public class TransientDemo {
    /**
     * 使用transient不序列化某个变量
     */

    private static final String PATH = System.getProperty("user.dir") + "\\files\\UserInfo.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(PATH);
        write();
        read();
    }

    private static void write() throws IOException {
        ObjectOutputStream outputStream = null;
        UserInfo userInfo = null;
        try {
            userInfo = userInfoBuilder();
            System.out.println("--------------------write---------------------");
            userInfo.print();
            outputStream = new ObjectOutputStream(new FileOutputStream(PATH));
            outputStream.writeObject(userInfo);
        }finally {
            if(outputStream != null) outputStream.close();
        }
    }

    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(PATH));
            UserInfo userInfo = (UserInfo) objectInputStream.readObject();
            System.out.println("---------------------read--------------------------");
            userInfo.print();
        }finally {
            if(objectInputStream != null) objectInputStream.close();
        }
    }

    private static UserInfo userInfoBuilder(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("ldf");
        userInfo.setAge(25);
        userInfo.setPassword("123456");
        return userInfo;
    }

    static class UserInfo implements Serializable{
        private String name;
        private int age;
        transient private String password;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        void print(){
            System.out.println("name:" + this.name + "/"
                            + " age:" + this.age + "/"
                            + " password:" + this.password);
        }
    }

}
