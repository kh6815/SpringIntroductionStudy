package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
//ObjectProvider를 사용할 때
//@Scope(value = "request") //동시에 여러 HTTP 요청이 오면 정확히 어떤 요청이 남긴 로그인지 구분하기 어렵다. 이럴때 사용하기 딱 좋은 것이 request스코프이다.
//스프링 컨테이너에 요청하는 시점에 이 빈은 HTTP 요청 당 하나씩 생성되고, HTTP 요청이 끝나는 시점에 소멸된다.
//예를 들어 클라이언트 A,B 가 각각 HTTP request 요청을 하면 controller로 요청이 들어오고 -> myLogger로 요청이 들어가서 각각 A전용인 request scope와
// B전용인 request scope를 만들어준다. 그래서 service에서 다시 myLogger를 요청해도 같은 객체가 들어간다.





//ObjectProvider보다 더 편하게 사용하는 proxy 사용할 때
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//proxyMode는 적용대상이 (즉 여기서는 MyLogger클래스) 인터페이스가 아닌 클래스면 TARGET_CLASS를 선택
// proxyMode는 적용대상이 인터페이스면 INTERFACES를 선택
// 이렇게 proxyMode를 사용하면 MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP request와 상관 없이 가짜 프록시 클래스를 다른 빈에 미리 주입해 둘 수 있다.
// 가짜 프록시 객체는 실제 request scope와는 관계가 없다. 그냥 가짜이고, 내부에 단순한 위임 로직만 있고, 싱글톤처럼 동작한다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);

    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();//자바 문법에 있는 UUID.randomUUID.toString을 하면 글로벌하게 유니크한 아이디가 생성된다. 절대 겹치지 않는다.
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
