package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);//->TestBean.class를 자동으로 스프링 빈에 등록함.
    }

    static class TestBean{

        @Autowired(required = false) //(required = false) - 의존관계가 없으면 메서드 자체가 아예 호출이 안됨.
        public void setNoBean1(Member noBean1){ //Member는 스프링이 관리하는 빈이 아님
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired //null 호출
        public void setNoBean2(@Nullable Member noBean2){ //Member는 스프링이 관리하는 빈이 아님
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired //Optional.empty 호출
        public void setNoBean3(Optional<Member> noBean3){ //Member는 스프링이 관리하는 빈이 아님
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
