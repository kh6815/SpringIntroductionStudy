package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service //Service안에 Component가 있음
@RequiredArgsConstructor
public class LogDemoService {
    //private final MyLogger myLogger;

    /*
    //ObjectProvider 사용
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    //ObjectProvider 사용
    public void logic(String id) {
        // controller에서 이미 한번 의존관계를 주입받았기 때문에 같은 객체를 가져온다.
        MyLogger myLogger = myLoggerProvider.getObject(); //ObjectProvider 사용하여 필요한 시점에 의존관계를 주입받음.
        myLogger.log("service id = " + id);
    }*/

    //proxy사용법
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
