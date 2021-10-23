package com.rkdevblog.plugin;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PluginApplication {

  public static void main(String[] args) {
    SpringApplication.run(PluginApplication.class, args);
  }

    @Bean
    ApplicationRunner runner(PaymentService paymentService) {
      return args -> {
        PaymentPlugin paymentPlugin = paymentService.choosePaymentMethod(PaymentMethod.PAYPAL);

        paymentPlugin.pay(10);
      };
    }
}
