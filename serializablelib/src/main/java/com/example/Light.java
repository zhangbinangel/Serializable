package com.example;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/7.
 */
public class Light implements Serializable,Cloneable {
    public static final String TAG = "Light";
    public static void main(String[] args)
    {
        try {
            String light = serialize(new Light());
            System.out.println("light:"+light);

            Light mLight = deSerialization(light);
            System.out.println("light:"+mLight.name+","+mLight.age+","+mLight.sex+","+mLight.weight);


            Light cloneLight = (Light) mLight.clone();
            cloneLight.name = "clone";
            System.out.println(cloneLight.name+","+mLight.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
    public String name = "name";
    public int age = 23;
    public static String sex = "男";
    /*禁止序列化*/
    public transient int weight = 60;


    /*
   * 序列化对象
   * */
    private static String serialize(Light light) throws IOException {
        long startTime = System.currentTimeMillis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                byteArrayOutputStream);
        objectOutputStream.writeObject(light);
        String serStr = byteArrayOutputStream.toString("ISO-8859-1");
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("序列化耗时为:" + (endTime - startTime));
        return serStr;
    }
    /*
    * 反序列化对象
    * */
    private static Light deSerialization(String str) throws IOException,
            ClassNotFoundException {
        long startTime = System.currentTimeMillis();
        String redStr = java.net.URLDecoder.decode(str, "UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                redStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        Light light = (Light) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("反序列化耗时为:" + (endTime - startTime));
        return light;
    }

    /*
    * 克隆
    * */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
