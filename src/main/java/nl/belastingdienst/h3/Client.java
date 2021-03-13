package nl.belastingdienst.h3;

public class Client {
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Client(String name){
        this.name = name;
    }
}
