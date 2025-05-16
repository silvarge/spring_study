package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  // @Bean memberService -> new MemoryMemberRepository()
  // @Bean orderService -> new MemoryMemberRepository()
  // 2개 모두 생성한다면 싱글톤이 깨지는 거 아닌가? -> @Configuration 이 싱글톤을 보장해 줌

  // 역할이 잘 드러난다
  @Bean
  public MemberService memberService() {
    System.out.println("AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService(){
    System.out.println("AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }

}