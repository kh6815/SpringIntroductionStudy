package hello.core.autowired.allbean;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class); //둘다 스프링 빈에 등록함.

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);

        int dicountprice = discountService.dicount(member, 10000, "fixDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(dicountprice).isEqualTo(1000);

        int rateDicountprice = discountService.dicount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDicountprice).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired //-> 위의 테스트 코드에서 new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class)로
                   //DiscountService를 스프링 빈에 등록하기 때문에 생성자가 하나이니까 Autowired를 생략해도 의존관계 주입이 가능하다.
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            //윗줄 -> map, list는 스프링빈에 등록되어 있지 않아도 스프링 빈에 등록되어 있는 타입을 모두 가져온다.
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int dicount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode); //현재 "fixDiscountPolicy"가 들어가 있기 때문에 Map에서 fixDiscountPolicy가 나온다.
            return discountPolicy.discount(member, price);
        }
    }
}
