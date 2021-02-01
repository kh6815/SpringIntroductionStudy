package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor  //생성자 주입이 좋긴 하지만 개발코드가 길기 때문에 롬복이라는 적용하여 간편하게 만들 수 있다.
                        //-> lombok의 기능으로써 클래스 내부에 final이 붙은 객체, 변수를 가지고 생성자를 만들어 준다.
                        //그래서 따로 생성자를 만들필요없고 생성자가 하나면 Autowired도 생략가능함으로 간편한 의존관계 주입이 가능하다.
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /*
    //필드 주입 - 코드가 간결하지만 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인 단점이 있다.-> 스프링 프레임워크말고 수순 자바 코드로 테스트 할때 문제가 생김
    @Autowired private DiscountPolicy discountPolicy; //구체화에 의존하지 않고 추상화에만 의존하고 있다. 잘된 설
    @Autowired private MemberRepository memberRepository; //final은 무조건 값이 있어야한다. 지금은 생성자에서 값을 넣어주고 있다.*/

    private final DiscountPolicy discountPolicy; //구체화에 의존하지 않고 추상화에만 의존하고 있다. 잘된 설계
    private final MemberRepository memberRepository;

    /*
    //그래서 생성자나 수정자 하나만 사용하면 됨.
    //수정자 주입 - 스프링빈에 등록절차가 끝난다음 싸이클로 의존관계 주입이 일어난다.
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/


    //생성자 주입 - 스프링빈에 등록할 때 자동으로 의존관계 주입이 일어남.
    @Autowired //생성자가 하나 일때는 Autowired를 안써도 자동으로 의존관계 주입을 해준다. 요즘에는 안쓰는게 유행.
    public OrderServiceImpl(@MainDiscountPolicy DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        System.out.println(" 1. OrderServiceImpl.OrderServiceImpl");
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
