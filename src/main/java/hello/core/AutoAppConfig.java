package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//ComponentScan - 컴포넌트 스캔은 이름 그대로 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.

        basePackages = "hello.core" ,//basePackages는 해당 패키지를 포함해서 하위 패키지 안에서 component를 찾을 수 있게함. , 패키지 수를 두가지 이상 줄 수 도 있음
        basePackageClasses = AutoAppConfig.class, //basePackageClasses는 AutoAppConfig.class가 포함된 hello.core부터 component를 찾게 한다.
        //basePackages, basePackageClasses를 지정하지 않은 디폴트 상태일 때는 ComponentScan를 붙인 클래스가 포함된 패키지부터 스캔한다.(즉 AutoAppConfig면 hello.core부터 )

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //빈을 등록시키지 않고 싶은거 거를 때
        //type = FilterType.ANNOTATION -> 스프링이 자동으로 컨테이너에 등록하는거 말고 내가 생성해서 등록하는것
        // classes = Configuration.class -> AppConfig.java 파일이나 Test파일이 @Configuration이 등록되어 있어 자동으로 componentScan의 대상으로 되기 때문에 일단 제외 시키기 위함.
)
public class AutoAppConfig {

    /*
    //수동으로 빈을 등록한게 자동으로 등록된 빈을 오버라이딩 한다.
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/ //근데 스프링 부트는 안된다고 오류 낸다.
}
