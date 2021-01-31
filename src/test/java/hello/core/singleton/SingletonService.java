package hello.core.singleton;

public class SingletonService {

    //jvm을 통해 자바가 딱 뜰때 static이 붙어 있으면 내부적으로 실행을 해서 자기 자신의 객체를 생성해서 instance에 넣어놓는다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() { //이렇게 생성자를 private를 막아서 외부에서 아무나 생성할 수 없게 하고 싱글톤을 사용하여 하나의 객체를 공유하게 만든다.

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
