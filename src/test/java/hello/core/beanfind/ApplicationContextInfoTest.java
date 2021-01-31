package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링 컨테이너에 저장되어있는 스프링 빈(객체)의 이름 즉, key값을 모두 가져온다

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // getBean할때 두번째 인자로 타입을 정하지 않았기 때문에 Object 형식으로 가져온다.
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("내가 설정한 애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링 컨테이너에 저장되어있는 스프링 빈(객체)의 이름 즉, key값을 모두 가져온다

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // BeanDefinition - 스프링 빈 하나하나에 대한 메타데이터 정보들

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { //스프링이 내부적으로 등록한 빈이 아니라 내가 애플리케이션을 주로 개발하기 위해서 등록한 빈을 찾는 것
                Object bean = ac.getBean(beanDefinitionName); // getBean할때 두번째 인자로 타입을 정하지 않았기 때문에 Object 형식으로 가져온다.
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
