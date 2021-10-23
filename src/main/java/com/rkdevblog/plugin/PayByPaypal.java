package com.rkdevblog.plugin;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PayByPaypal implements PaymentPlugin {

  @Override
  public void pay(int paymentAmount) {
    log.info("Paid by paypal, amount: " + paymentAmount);
  }

  @Override
  public boolean supports(PaymentMethod paymentMethod) {
    return paymentMethod == PaymentMethod.PAYPAL;
  }
}
