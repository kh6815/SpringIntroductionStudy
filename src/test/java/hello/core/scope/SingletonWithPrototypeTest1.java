package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();

        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype(){
        //ClientBean에서 생성자 주입을 할 때 스프링 컨테이너에서 PrototypeBean의 해당 타입의 객체를 가져오기 때문에 PrototypeBean도 스프링 빈에 등록되어야한다.
        //그래서 AnnotationConfigApplicationContext를 통해 PrototypeBean를 빈에 등록시킨다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton") //안해줘도 되지만 확실히 하자는 의미에서 / 원래 싱글톤이 디폴트이기 때문에 생략가능
    @RequiredArgsConstructor //lombok을 통해서 생성자 의존관계를 생략가능
    static class ClientBean{

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider; //내부적으로 BeanFactory에 넘겨받기 때문에 @Autowired가 필요하다.

        /*
        private final PrototypeBean prototypeBean; //생성시점에 주입

        /* //@RequiredArgsConstructor으로 생성자 생략가능
        @Autowired //이것도 생성자 하나임으로 생략가능
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }*/

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.get(); //이때 내부에서 스프링 컨테이너를 통해 ProtortypeBean(해당하는 빈)을 찾아서 가져온다.
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;
        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct //초기화 <- 프로토타입에서도 동작 됨.
        public void init(){
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
