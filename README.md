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

스프링 핵심 원리 이해1 - 예제 만들기 

- 스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성 : https://start.spring.io
  - 현업에서 요즘은 프로젝트는 Gradle로 사용
     ![캡처](https://user-images.githubusercontent.com/62634760/106376380-30ef3180-63d8-11eb-92e4-5efe3d0f694a.PNG)
