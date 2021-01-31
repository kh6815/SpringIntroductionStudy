package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;
    
    public static void main(String[] args){
       HelloLombok helloLombok = new HelloLombok();
       helloLombok.setName("강현");
       
       String name = helloLombok.getName();
        System.out.println("helloLombok = " + helloLombok);
    }
}
