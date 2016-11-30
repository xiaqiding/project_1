package myextends;

/**
 * 作用:
 * 作者:
 * 时间:
 */

public class Animals {
    public String name;
    public int id;

    public void eat(){
        System.out.println(name+"正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction() {
        System.out.println("大家好！我是"         + id + "号" + name + ".");
    }
}
