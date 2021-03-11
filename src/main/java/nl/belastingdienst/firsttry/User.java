package nl.belastingdienst.firsttry;

public class User {

    String city = "";
    int age = 0;

    public void setCity(String city){
        this.city = city;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getCity(){
        return this.city;
    }

    public int getAge(){
        return this.age;
    }

    public void introduce(){
        System.out.println("I live in " + this.city );
        System.out.println("I am " + this.age +  " years old" );
    }

}
