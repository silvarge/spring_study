package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void setUp() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
//    Long memberId = 1L;
//
//    Member member = new Member(memberId, "memberA", Grade.VIP);
//    memberService.join(member);
//
//    Order order = orderService.createOrder(memberId, "itemA", 10000);
//    Assertions.assertEquals(1000, order.getDiscountPrice());
  }
}
