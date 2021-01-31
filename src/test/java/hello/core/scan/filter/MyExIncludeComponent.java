package hello.core.scan.filter;

import java.lang.annotation.*;

//@Component 애노테이션 안에 있는 3가지 속성을 가져와서 스프링빈에 등록할 수 있다.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExIncludeComponent {
}
