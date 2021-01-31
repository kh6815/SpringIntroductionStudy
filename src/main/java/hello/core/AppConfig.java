package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //애플리케이션의 설정정보, 구성정보를 담당하는 것
public class AppConfig { //공연기획자처럼 인터페이스만 연결되어 있는 것을 여기서 구체적인클래스로 연결해준다.
     // 애플리케이션의 실제 동작에 필요한 구현객체를 생성한다.
    // 생성한 객체 인스턴스의 참초(레퍼런스)를 생성자를 통해서 주입(연결)해준다. -> 인젝션(주입)

    @Bean //Bean 애노테이션을 적어주면 이 메서드들이 모두 스프링컨테이너에 등록이 된다.
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
         //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    //스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정 정보로 사용한다. 여기서 Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에
    // 등록한다. 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다.
    // 스프링 빈은 @Bean이 붙은 메서드의 명을 스프링 빈(객체)의 이름으로 사용한다.

}
