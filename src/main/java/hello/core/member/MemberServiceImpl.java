package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 기존에 AppConfig에서는 new memoryMemberRepository를 생성하여 의존관계를 주입해주었지만,
    // @Component를 통해 자동으로 클래스를 스프링빈에 등록시킴으로 의존 관계 주입도 자동으로 해주는 Autowired를 사용할 수 있다.
    //ac.getBean(MemberRepository.class) 처럼 동작한다고 이해하면된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
