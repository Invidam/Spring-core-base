package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP이면, 할인율 10% 적용.")
    void vio_o() {
        //given
        Member vipMember = new Member(1L, "vipMember", Grade.VIP);
        //when
        int discount = discountPolicy.discount(vipMember, 13000);
        //then
        assertThat(discount).isEqualTo(1300);
    }

    @Test
    @DisplayName("VIP가 아니면, 할인율 0% 적용.")
    void vio_x() {
        //given
        Member basicMember = new Member(1L, "basicMember", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(basicMember, 13000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}