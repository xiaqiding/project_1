package myabstract;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 13:42
 * update: 2016-11-30
 */

public class Test {

    public static void main(String[] args) {
        //用Cat对象调用show
        show(new Cat());
        show(new Dog());

        Animal a = new Cat();
        a.eat();
        Cat c = (Cat) a;
        c.work();
    }

    //展示方法
    public static void show(Animal a) {
        a.eat();
        //判断动物类型
        if (a instanceof Cat) {
            //猫的工作
            Cat c = (Cat) a;
            c.work();
        } else if (a instanceof Dog) {
            //狗的工作
            Dog c = (Dog) a;
            c.work();
        }
    }
}
    //抽象类
    abstract class Animal{
        abstract void eat();
    }
    //继承抽象类
    class Cat extends Animal{
        @Override
       public void eat() {
            System.out.println("爱吃鱼");
        }

        public void work(){
            System.out.println("抓老鼠");
        }
    }
    class Dog extends Animal{
        @Override
        public void eat() {
            System.out.println("爱骨头");
        }
        public void work(){
            System.out.println("会看家");
        }
    }


