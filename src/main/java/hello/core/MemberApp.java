package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();


        //ApplicationContext -> 스프링 컨테이너라고 생각하면 된다. //@Bean 등록되어 있는 객체들을 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 기본적으로 name은 메서드 이름이 등록된다. / 두번째는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member1 = new Member(1L,"최강현", Grade.VIP);
        Member member2 = new Member(2L,"최성현", Grade.BASIC);

        memberService.join(member1);
        memberService.join(member2);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member1.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
