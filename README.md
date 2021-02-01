# SpringIntroductionStudy
스프링 입문과정 공부

객체 지향 설계와 스프링 

* 스프링 생태계
  - 필수 : 스프링 프레임워크, 스프링 부트
  - 선택 : 스프링 데이터, 스프링 세션, 스프링 시큐리티, 스프링 Rest Docs, 스프링 배치, 스프링 클라우드

* 스프링 프레임워크
  - 핵심 기술        : 스프링 DI 컨테이너, AOP, 이벤트, 기타
  - 웹 기술          : 스프링 MVC, 스프링 WebFlux
  - 데이터 접근 기술 : 트랜잭션, JDBC, ORM지원, XML 지원 
  - 기술 통합        : 캐시, 이메일, 원격접근, 스케줄링
  - 테스트           : 스프링 기반 테스트 지원
  - 언어             : 코틀린, 그루비
  - 최근에는 스프링 부트를 통해서 스프링 프레임워크의 기술들을 편리하게 사용


* 스프링 부트
  - 스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용
  - Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨.

* 스프링의 진짜 핵심
  - 스프링은 자바 언어 기반의 프레임워크
  - 자바 언어의 가장 큰 특징 : 객체 지향 언어
  - 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
  - 스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크

* 객체 지향 특징
  - 추상화
  - 캡슐화
  - 상속
  - 다형성
    - 역할과 구현 분리 
      - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
      - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
      - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
      - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
   
    - 다형성의 본질
      - 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
      - 다형성의 본질을 이해하려면 협력이라는 객체사이의 관계에서 시작해야함.
      - 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.
   
    - 스프링과 객체 지향
      - 다형성이 가장 중요하다!
      - 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
      - 스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원
    
* 좋은 객체 지향 설계의 5가지 원칙 (SOLID)
  - SRP : 단일 책임 원칙(single responsibility principle)
     - 한 클래스는 하나의 책임만 가져야 한다.
     - 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것

  - OCP : 개방-폐쇄 원칙(Open/closed principle)
     - 스프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다. 즉 인터페이스확장에는 열려있어야하고 클라이언트 변경에는 닫혀 있어야 한다.
     - 다형성 활용

  - LSP : 리스코프 치환 원칙(Liskov subsitution principle)
     - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다. 

  - ISP : 인터페이스 분리 원칙(Interface segregation principle)
     - 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다
     -  자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
     - 인터페이스가 명확해지고, 대체 가능성이 높아진다.

  - DIP : 의존관계 역전 원칙 (Dependency inversion principle)
    - 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." -> 구현클래스에 의존하지 말고 인터페이스에 의존하라는 뜻
    -  역할에 의존하게 해야 한다는 것과 같다.

  - 하지만 다형성 만으로는 OCP, DIP를 지킬 수 없다. 그래서 스프링을 사용하여 다형성 + OCP, DIP를 가능하게 지원
    - DI(Dependency Injection) : 의존관계, 의존성 주입
    - DI 컨테이너 제공
    - 클라이언트 코드의 변경 없이 기능 확장



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Tip
 - IntelliJ Gradle 대신에 자바 직접 실행 
    - 최근 IntelliJ 버전은 Gradle을 통해서 실행 하는 것이 기본 설정이다. 이렇게 하면 실행 속도가 느리다.
    - 그래서 File -> Setting -> Build, Execution, Deployment -> Build Tools에 'Build and run using과 Run tests using' 세팅을 IntelliJ IDEA로 바꿔준다.


 - IntelliJ에서 단축키를 확실하게 검색하는 방법
   - File -> Setting -> keymap을 선택한다.
   - 오른쪽에 있는 검색창에 단축키 이름을 입력한다. 단축키 이름은 위 그림 처럼 영상 하단에 나온다.
   - Refactor This의 윈도우 단축키는 Ctrl + Alt + Shift + T 인 것을 알 수 있다.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

스프링 핵심 원리 이해

- 스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성 : https://start.spring.io
  - 현업에서 요즘은 프로젝트는 Gradle로 사용

     ![캡처](https://user-images.githubusercontent.com/62634760/106376380-30ef3180-63d8-11eb-92e4-5efe3d0f694a.PNG)


- 회원 도메인 설계

    ![캡처](https://user-images.githubusercontent.com/62634760/106376944-cf7d9180-63dc-11eb-8d29-ada781a1d5d7.PNG)
    ![캡처1](https://user-images.githubusercontent.com/62634760/106376945-d0162800-63dc-11eb-894f-5a0f80db3d1c.PNG)
  
  - 회원 등급 enum class

    ![회원 등급](https://user-images.githubusercontent.com/62634760/106377082-ce009900-63dd-11eb-8afa-ef5cdcc4853d.PNG)

  - 회원 엔티티

    ![회원 엔티티](https://user-images.githubusercontent.com/62634760/106377083-ce992f80-63dd-11eb-9de5-2835649ebad0.PNG)

  - 회원 저장소 인터페이스와 메모리 회원 저장소 구현체

    ![회원 저장소 인터페이스](https://user-images.githubusercontent.com/62634760/106377084-cf31c600-63dd-11eb-82fb-3de815592cb9.PNG)
    ![메모리 회원 저장소 구현체](https://user-images.githubusercontent.com/62634760/106377085-cf31c600-63dd-11eb-95ae-07d8d2f51234.PNG)

  - 회원 서비스 인터페이스와 회원 서비스 구현체

    ![회원 서비스 인터페이스](https://user-images.githubusercontent.com/62634760/106377086-cfca5c80-63dd-11eb-96db-6bee56450591.PNG)
    ![회원 서비스 구현체](https://user-images.githubusercontent.com/62634760/106377087-d062f300-63dd-11eb-9abb-1d54742198c4.PNG)

  - 테스트 코드

    ![테스트](https://user-images.githubusercontent.com/62634760/106377088-d0fb8980-63dd-11eb-8a4f-e2fd02482033.PNG)



- 주문과 할인 도메인 설계

  ![캡처](https://user-images.githubusercontent.com/62634760/106377219-005ec600-63df-11eb-9db5-d9a01eb757fa.PNG)
  ![캡처1](https://user-images.githubusercontent.com/62634760/106377220-00f75c80-63df-11eb-878a-00d6d03522f9.PNG)
  ![캡처2](https://user-images.githubusercontent.com/62634760/106377221-018ff300-63df-11eb-83a6-2563f942cb03.PNG)

  - 할인 인터페이스 및 구현객체(정액 할인 정책, 정률 할인 정책)
    
    ![할인 인터페이스](https://user-images.githubusercontent.com/62634760/106377387-0903cc00-63e0-11eb-8eae-6ee1b0e28e4a.PNG)
    ![정액할인 정책](https://user-images.githubusercontent.com/62634760/106377388-099c6280-63e0-11eb-99c7-922621a7718d.PNG)
    ![정률할인 정책](https://user-images.githubusercontent.com/62634760/106377389-0a34f900-63e0-11eb-8eea-6038fb22c1a5.PNG)

  - 주문 엔티티

    ![주문 엔티티](https://user-images.githubusercontent.com/62634760/106377392-0acd8f80-63e0-11eb-86b3-330e9ccc5b04.PNG)

  - 주문 인터페이스 및 구현객체

    ![주문 인터페이스](https://user-images.githubusercontent.com/62634760/106377394-0b662600-63e0-11eb-8e4a-8b4d73961bc5.PNG)
    ![주문 서비스 구현1](https://user-images.githubusercontent.com/62634760/106377395-0bfebc80-63e0-11eb-83f5-98450ceec349.PNG)
    ![주문 서비스 구현 2](https://user-images.githubusercontent.com/62634760/106377396-0c975300-63e0-11eb-9398-10fa8b5644d6.PNG)

  - 테스트
    ![테스트](https://user-images.githubusercontent.com/62634760/106377475-9a733e00-63e0-11eb-832b-9aea7bd04568.PNG)

- 개선해야 될 사항
  - 현재 작성되어진 내용으로는 제대로된 객체지향 프로그래밍이 아니다.
  - 클라이언트가 인터페이스에 의존하지않고 해당 구현 서비스에 직접 접근하고 있다.
  - 때문에 AppCnfig 클래스를 만들어 해당 클래스에서 구현객체들을 설정하고 사용하자.

    ![캡처](https://user-images.githubusercontent.com/62634760/106379199-a31e4100-63ed-11eb-9fc7-4e0e1aab4ad5.PNG)
    ![캡처1](https://user-images.githubusercontent.com/62634760/106379200-a44f6e00-63ed-11eb-8dfb-e11dd0367119.PNG)

  - 테스트 코드에서 @BeforeEach(각 Test 실행전에 먼저 동작) 애노테이션을 사용해서 Appconfig에 등록해놓은 구현 객체를 가져와 사용한다.
  
  - AppConfig에 @Configuration의 애노테이션을 통해 설정정보라고 설정하고, 구현객체 메서드에 @Bean 애노테이션을 달아서 스프링 컨테이너에 등록시킨다.
    - ApplicationContext(스프링 컨테이너)에서 저장된 구현 객체 Bean을 불러와 사용하면 편리한 의존관계 주입을 사용할 수 있다.
    - orderApp, memberApp을 통해 스프링 컨테이너 테스트 해보기
     ![캡처2](https://user-images.githubusercontent.com/62634760/106379482-b205f300-63ef-11eb-86e2-73be34881874.PNG)
     ![캡처3](https://user-images.githubusercontent.com/62634760/106379483-b29e8980-63ef-11eb-9678-1fb246819ddc.PNG)


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

스프링 컨테이너와 스프링 빈

- ApplicationContext를 스프링 컨테이너라 한다. 인터페이스이다.
- new AnnotationConfigApplicationContext(AppConfig.class) ->  이 클래스는 ApplicationContext 인터페이스 구현체이다. 
- 스프링 컨테이너를 생성할 때는 구성 정보를 지정해주어야 하는데 여기서는 AppConfig.class를 구성 정보를 지정했다.

  ![캡처](https://user-images.githubusercontent.com/62634760/106385943-0c19af00-6416-11eb-9ded-f1290e9a4428.PNG)

- 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입(DI)한다.
- 단순히 자바 코드를 호출하는 것이 아니라 싱글톤으로 의존관계를 주입하여 사용할 수 있게 한다.


- 컨테이너에 등록된 모든 빈 조회

  ![캡처](https://user-images.githubusercontent.com/62634760/106386453-5d2aa280-6418-11eb-9161-d4f4fdb7e8d5.PNG)


- 스프링 빈 조회
  - ac.getBean(빈이름, 타입)
  - ac.getBean(타입)

    ![캡처1](https://user-images.githubusercontent.com/62634760/106386455-5e5bcf80-6418-11eb-8799-aa9e15de37e5.PNG)


- 스프링 빈 조회(동일한 타입이 둘 일때)
  ![캡처2](https://user-images.githubusercontent.com/62634760/106386456-5ef46600-6418-11eb-8392-0df66ebb0342.PNG)
  ![캡처2-1](https://user-images.githubusercontent.com/62634760/106386457-5f8cfc80-6418-11eb-9702-453db92c2cd2.PNG)


- ApplicationContext는 BeanFactory의 기능을 상속받는다.
- ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공하기 때문에 BeanFactory를 직접 사용할 일은 거의 없다.
- BeanFactory나 ApplicationContext를 스프링 컨테이너라 한다.

  ![캡처](https://user-images.githubusercontent.com/62634760/106386753-e42c4a80-6419-11eb-8619-995a63f2037f.PNG)




스프링 컨테이너는 다양한 형식의 설정 정보를 받아드릴 수 있게 유연하게 설계되어 있다.
 - xml파일을 설정정보 파일로 설정하여 스프링 컨테이너 사용해보기
 - 기존 AppConfig 설정정보와 비슷하다는 걸 알 수 있다.

   ![캡처1](https://user-images.githubusercontent.com/62634760/106386754-e4c4e100-6419-11eb-914b-e4e7b0c1914d.PNG)
   ![캡처2](https://user-images.githubusercontent.com/62634760/106386755-e55d7780-6419-11eb-9440-b0ca271274d8.PNG)
   ![캡처2-1](https://user-images.githubusercontent.com/62634760/106386756-e5f60e00-6419-11eb-95e4-d29317e9ab32.PNG)
 
 - 스프링이 이런 다양한 설정 형식을 지원하는 이유는? 그 중심에는 BeanDefinition이 있다.
 - 역할과 구현을 개념적으로 나눈 것
 - 스프링 컨테이너는 자바 코드인지, XML인지 몰라도 된다. 오직 BeanDefinition만 알면 된다.
   
   ![캡처](https://user-images.githubusercontent.com/62634760/106388894-ded3fd80-6423-11eb-91e6-482ac3d9f373.PNG)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

싱글톤 컨테이너 

- 스프링을 사용하지 않은 DI 컨테이너인 AppConfig는 요청이 있을 때 마다 객체를 새로 생성하여 반환하기 때문에 메모리 낭비가 심하다.
- 해결방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설계 -> 싱글톤 디자인 패턴
- 싱글톤으로 사용할 클래스를 static을 사용하여 프로그램 시작시 자기자신을 바로 리턴하게 만들고 사용한다 -> 싱글톤

  ![캡처1](https://user-images.githubusercontent.com/62634760/106388897-e0052a80-6423-11eb-9778-591f18299616.PNG)
  ![캡처2](https://user-images.githubusercontent.com/62634760/106388898-e09dc100-6423-11eb-80c2-efe910d8561f.PNG)

- 하지만 이런 싱글톤 패턴의 문제점은
   - 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감.
   - 의존관계상 클라이언트가 구체 클래스에 의존한다. -> DIP를 위반한다.
   - 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
   - 유연성이 떨어진다.
   - 안티패턴으로 불리기도 한다.

그래서 '싱글톤 컨테이너'를 사용한다!!!!!!!!!
 - 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다.
 - 스프링 빈이 바로 싱글톤으로 관리되는 빈이다.
 - 싱글톤 컨테이너
    - 스프링 컨테이너는 싱글턴 패턴을 적용하지 않아도, 객체 인스턴스를 싱글톤으로 관리한다.
    - 스프링 컨테이너의 이런 기능 덕분에 싱글턴 패턴의 모든 단점을 해결하면서 객체를 싱글톤으로 유지할 수 있다.
    - 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 된다.
    - DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용할 수 있다.

 - 싱글톤 설계시 진짜진짜 주의할점!!

  ![캡처3](https://user-images.githubusercontent.com/62634760/106388900-e1365780-6423-11eb-9ba8-5b20b1296f6d.PNG)
  ![캡처3-1](https://user-images.githubusercontent.com/62634760/106388901-e1365780-6423-11eb-9a9d-4693d77e97f2.PNG)
  ![캡처3-2](https://user-images.githubusercontent.com/62634760/106388903-e1ceee00-6423-11eb-9a64-16dc93fb7668.PNG)
  ![캡처3-3](https://user-images.githubusercontent.com/62634760/106388904-e2678480-6423-11eb-8988-75b3eac074f7.PNG)

- 정리 
  - @Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다.
    - memberRepository()처럼 AppConfig에서 의존관계주입이 필요해서 메서드를 직접 호출할 때 싱글톤을 보장하지 않는다.
  - 크게 고민할 것이 없이, 스프링 설정 정보는 항상 @Configuration을 사용하자.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

컴포넌트 스캔

- 지금까지는 AppConfig라는 설정정보파일을 만들어 자바코드의 @Bean등을 통해서 설정 정보에 직접 등록할 스프링 빈을 나열했다.
- 예제는 몇개 안됬지만, 등록해야할 스프링 빈이 많아지면 복잡해진다.
- 그래서 스프링 빈은 설정 정보가 없어서도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.
- 또한 의존관계도 자동으로 주입하는 @Autowired라는 기능도 제공한다.

- 컴포넌트 스캔을 사용하려면 먼저 @ComponentScan을 설정정보에 붙여주기
- 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 필요없다.
  - 참고 : 컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다. 그래서
excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다. 보통 설정 정보를 컴포넌트
스캔 대상에서 제외하지는 않지만, 기존 예제 코드를 최대한 남기고 유지하기 위해서 이 방법을 선택했다.
  
  ![캡처](https://user-images.githubusercontent.com/62634760/106407306-1623c800-647f-11eb-8f7b-8634195cbc43.PNG)


- 컴포넌트 스캔은 이름 그대로 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
- 스프링 빈으로 등록하고싶은 클래스(AppConfig에 Bean으로 등록했던 클래스들)에 @Component를 붙여주고, DI가 필요한 객체에 @Autowired를 해준다.
  
  ![캡처1](https://user-images.githubusercontent.com/62634760/106407311-1754f500-647f-11eb-8486-2e398b86f45e.PNG)




- 컴포넌트 스캔 기본 대상 : 컴포넌트 스캔은 @Component뿐만 아니라 다음과 같은 내용도 추가로 대상에 포함
  - @Component : 컴포넌트 스캔에서 사용
  - @Controller : 스프링 MVC컨트롤러에서 사용, 스프링 MVC 컨트롤러로 인식
  - @Service : 스프링 비즈니스 로직에서 사용, @Service 는 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는데 도움이 된다.
  - @Repository : 스프링 데이터 접근 계층에서 사용, 스프링 데이터 접근 계층으로 인식함.
  - @Configuration : 스프링 설정 정보에서 사용, 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리함.



- 컴포넌트 스캔의 필터기능
  - includeFilters : 컴포넌트 스캔 대상을 추가로 지정
  - excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정

  - 먼저 명확한 인식을 위해 추가, 제외 애노테이션을 만들기
    
    ![캡처2](https://user-images.githubusercontent.com/62634760/106407313-1754f500-647f-11eb-813d-9ab7f82a5686.PNG)
    ![캡처2-1](https://user-images.githubusercontent.com/62634760/106407315-17ed8b80-647f-11eb-893f-fa331025ed02.PNG)

  - 컴포넌트 스캔 대상에 추가할 클래스에 @MyIncludeComponent, 제외할 클래스에 @MyExcludeComponent를 적용
    
    ![캡처2-2](https://user-images.githubusercontent.com/62634760/106407317-17ed8b80-647f-11eb-9ead-e4881b0de744.PNG)
    ![캡처2-3](https://user-images.githubusercontent.com/62634760/106407319-18862200-647f-11eb-904a-c6b433b6430f.PNG)

  - Test부분에서 설정파일을 만들고 만들어둔 애노테이션 클래스를 제외시킨다.

    ![캡처2-4](https://user-images.githubusercontent.com/62634760/106407321-18862200-647f-11eb-93e6-82885e9709d2.PNG)




--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

다양한 의존관계 주입 방법
 - 생성자 주입
   - 생성자 호출 시점에 딱 1번만 호출되는 것이 보장
   - 불변, 필수 의존관계에 사용
   - 중요! : 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. (@Component로 스프링 빈에 등록되어 있을 때)

 - 수정자 주입(setter 주입)
   - setter를 통해 의존관계 주입, 선택 / 변경 가능성이 있는 의존관계에 사용
 
 - 필드 주입
   - 코드가 간결하지만, 외부에서 변경이 불가능해서 테스트하기 힘들다는 단점
   - DI 프레임워크가 없으면 아무것도 할 수 없다.
   - 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용
   - 사용하지 말자
     
     ![캡처](https://user-images.githubusercontent.com/62634760/106408956-d363ef00-6482-11eb-9f72-d22dbf8b4768.PNG)    

 - 일반 메서드 주입
   - 일반 메서드 주입, 잘 사용하지 않음.


옵션처리
 - 주입할 스프링 빈이 없어도 동작해야할 때가 있다.
 - 그런데 @Autowired만 사용하면 required옵션의 기본값이 true로 되어 있어서 자동 주입 대상이 없으면 오류가 발생한다.
   
   ![캡처1](https://user-images.githubusercontent.com/62634760/106408959-d3fc8580-6482-11eb-9073-92264d8c39d3.PNG)



결론
 - 생성자 주입을 선택해서 사용해라
 - 최근에는 스프링을 포함한 DI 프레임워크 대부분이 생성자 주입을 권장 
 - 또한 의존관계 주입이 필요한 객체에 final키워드를 사용해서 생성자에서 혹시라도 값이 설정되지 않는 오류를 컴파일 시점에서 막게하자.

   ![캡처2](https://user-images.githubusercontent.com/62634760/106408960-d4951c00-6482-11eb-911b-40e17e443657.PNG)



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

롬복과 최신 트랜드
 - 롬복의 @RequiedArgsConstructor를 통해 생성자를 생략할 수 있다.
 - 의존관계가 필요한 객체에 final로 자동의존관계 주입이 가능하게 바꿀 수 있다.
   
   ![캡처3](https://user-images.githubusercontent.com/62634760/106408961-d52db280-6482-11eb-922d-b4c11917fed5.PNG)



 -@Autowired를 사용할 때 조회 대상 빈이 2개 이상일 때 해결방법
   - Autowired 필드 명 매칭
     - @Autowired는 타입 매칭을 시도하고, 이때 여러 빈이 있으면 필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭한다.
   
       ![캡처4](https://user-images.githubusercontent.com/62634760/106408962-d52db280-6482-11eb-8f94-89b0bc04b7ac.PNG)

   - Qualifier -> @Qualifier끼리 매칭 -> 빈 이름 매칭
     - 빈 등록시에 @Qualifier를 붙여준다.
     
       ![캡처5](https://user-images.githubusercontent.com/62634760/106408963-d5c64900-6482-11eb-842c-1502cde766a8.PNG)

     - 주입시에 @Qualifier를 붙여주고 등록한 이름을 적어준다.
   
       ![캡처6](https://user-images.githubusercontent.com/62634760/106408964-d5c64900-6482-11eb-90b2-dcd6d79bbc84.PNG)

   - @Primary 사용
     - 빈에 등록할 때 @Primary를 줘서 우선순위를 준다.




