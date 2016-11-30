package myextends;
/**
 * autour: 夏奇顶
 * date: 2016-11-30 11:41
 * update: 2016-11-30
 */
public class Test {

    public static void main(String[] args) {
        Mouse mouse=new Mouse();
        mouse.name="老鼠";
        mouse.id=1001;
        mouse.eat();
        mouse.sleep();
        mouse.introduction();

        Tiger tiger=new Tiger();
        tiger.name="老虎";
        tiger.id=10101;
        tiger.eat();
        tiger.sleep();
        tiger.introduction();
    }
}
