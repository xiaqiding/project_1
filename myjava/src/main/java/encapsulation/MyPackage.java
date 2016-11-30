package encapsulation;
/**
 * autour: 夏奇顶
 * date: 2016-11-30 11:24
 * update: 2016-11-30
 */

public class MyPackage {
    public static void main(String[] args) {
        //实例化对象
        Person person=new Person();
        //赋值
        person.setName("wujing");
        person.setAge(35);
        person.setIdNum("8341");
        //输出
        System.out.println("名称："+person.getName()+"年龄："+person.getAge()+"岁");
    }
}
