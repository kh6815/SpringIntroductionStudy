package hello.core.lifecycle;

import javax.annotation.PostConstruct; //javax는 스프링에 종속적인 기술이 아니라, 자바 진영에서 공식적으로 지원해주는 것(자바표준이다)
import javax.annotation.PreDestroy;

public class NetworkClient //implements InitializingBean, DisposableBean {
{
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url" + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " messge = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    //@PostConstruct, @PreDestroy를 사용할 때 / 가장 권장하는 방법
    @PostConstruct
    public void init(){
        System.out.println(" NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }


    /* // @Bean(initMethod = "init", destroyMethod = "close")를 사용할 때
    public void init(){
        System.out.println(" NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }*/

    ////implements InitializingBean, DisposableBean로 값을 초기화하는 것은 초창기 스프링 방식이라 잘 사용하지 않는다.
    /*
    @Override
    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나면 호출하는 메서드
        System.out.println(" NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception { //destroy는 이 bean이 종료될 때 호출된다.
        System.out.println("NetworkClient.destory");
        disconnect();
    }*/
}
