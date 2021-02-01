package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        //ConfigurableApplicationContext는 AnnotationConfigApplicationContext의 상위 인터페이스
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class); //컨테이너에 만들어진 스프링빈을 가져온다.
        ac.close(); //ac를 닫는다.
    }

    @Configuration
    static class LifeCycleConfig{

        /*
        @Bean(initMethod = "init", destroyMethod = "close") //<-이렇게 초기화 하면 더 편함. initMethod - 의존관계 주입완료시 init메서드 동작
        //destroyMethod 테스트코드, 즉 클라이언트에서 ac.close로 이 bean이 설정정보와 함께 파괴될 때  close메서드 동작
        //라이브러리는 대부분 close, shutdown이라는 종료메서드를 사용한다.
        // destroyMethod의 기본값(디폴트)이 (inferred)추론으로 등록되어 있어 close, shutdown라는 이름의 메서드를 자동 호출해줌.*/

        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient; //<-의존관계 주입 완료
        }
    }
}
