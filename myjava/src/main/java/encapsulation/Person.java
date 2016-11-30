package encapsulation;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 11:24 
 * update: 2016-11-30
 */
//对私有属性进行封装
public class Person {
    //属性
    private String name;
    private String idNum;
    private int age;
    //封装
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String getIdNum(){
        return idNum;
    }

    public void setAge( int newAge){
        age = newAge;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setIdNum( String newId){
        idNum = newId;
    }
}
