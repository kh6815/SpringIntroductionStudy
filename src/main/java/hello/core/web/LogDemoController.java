package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor //자동 생성자 의존관계 주입
public class LogDemoController {

    /* //ObjectProvider 사용할 때
    private final LogDemoService logDemoService;
    //private final MyLogger myLogger; //현재 여기서 오류가 나는 이유는 MyLogger는 자동으로 컨테이너에서 의존관계 주입을 받아야하는데
    //MyLogger의 scope(value = request)이기 때문에 웹(클라이언트)에서 HTTP요청이 있을 때만 생성되고 나갈 때 삭제된다
    //그러므로 컨테이너가 생성되고 의존관계 주입이 일어날 때, MyLogger는 컨테이너에 생성되지 않아서 오류가 발생한다.
    //이럴 때 provider를 쓰면 해결된다.

    //ObjectProvider 사용
    private final ObjectProvider<MyLogger> myLoggerProvider; // ObjectProvider를 사용하면 MyLogger를 주입받는게 아니라,
    // MyLogger를 찾을 수 있는(DL)이 주입이 된다. //myLoggerProvider.getObject();를 호출하는 시점까지 request scope 빈의 생성을 지연할 수 있다.
    // 즉 컨테이너에 요청하는 걸 지연할 수 있다.


    @RequestMapping("log-demo") //HTTP 요청이 "log-demo"로 오면 이쪽으로 들어옴.
    @ResponseBody
    public String logDemo(HttpServletRequest request){ //HttpServletRequest를 통해서 요청 URL을 받는다.
        String requestURL = request.getRequestURI().toString();
        //ObjectProvider 사용하여 내가 필요한 시점에 의존관계를 주입받는다.
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);// 이렇게 받은 requestURL 값을 myLogger에 저장해둔다.
        //myLogger는 @Scope(value = "request")덕분에 HTTP 요청 당 각각 구분되므로 다른 HTTP 요청 때문에 값이 섞이는 걱정은 하지 않아도 된다.

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }
     */

    //proxy사용할 때
    private final LogDemoService logDemoService;
    private final MyLogger myLogger; //proxy를 사용하면 의존관계 주입시 가짜인 MyLogger를 주입시켜놓는다.
    // 그리고 클라이언트가 myLogger.log을 호출하면 사실은 가짜 프록시 객체의 메서드를 호출한 것이다.
    // 가짜 프록시 객체는 request스코프의 진짜 myLogger.log를 호출한다.


    @RequestMapping("log-demo") //HTTP 요청이 "log-demo"로 오면 이쪽으로 들어옴.
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURI().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL); //가짜 myLogger.setRequestURL를 호출함 -> request스코프의 진짜 myLogger.setRequestURL를 호출출

       myLogger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }
}
