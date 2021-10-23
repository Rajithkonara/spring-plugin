package com.rkdevblog.plugin;

import org.springframework.plugin.core.Plugin;

public interface PaymentPlugin extends Plugin<PaymentMethod> {

  void pay(int paymentAmount);

}
