package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //자동으로 등록하는 빈 중 뺄거를 지정
)
public class AutoAppConfig {
//스프링 빈이 컴포넌트 스캔으로 등록돼있는데 수동으로 또 등록하려다 보니 CoreApplicationTests에서 오류가 남
//    @Bean
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
