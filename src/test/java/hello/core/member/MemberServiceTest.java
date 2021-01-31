package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //각 Test실행전에 먼저 동작하는 에노테이션
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given - 이러이런게 주어졌을 때
        Member member = new Member(1L, "최강현", Grade.VIP);

        //when - 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then - 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
