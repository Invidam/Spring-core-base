package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public  void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "hsp", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Pizza", 17000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1700);


        Long memberId2 = 2L;
        Member member2 = new Member(memberId2, "jsj", Grade.BASIC);

        memberService.join(member2);

        Order order2 = orderService.createOrder(memberId2, "Chicken", 21000);

        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
    }
}