package hello.core.scan;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  @DisplayName("Component 및 Autowired 테스트")
  void basicBean() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(
        AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);

    OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
    MemberRepository memberRepository = bean.getMemberRepository();
    System.out.println("memberRepository = " + memberRepository);
  }

}
