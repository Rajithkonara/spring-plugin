package com.rkdevblog.plugin;

import java.util.Optional;

import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@EnablePluginRegistries(PaymentPlugin.class)
@RequiredArgsConstructor
public class PaymentService {

  private final PluginRegistry<PaymentPlugin, PaymentMethod> plugins;

  public PaymentPlugin choosePaymentMethod(PaymentMethod paymentMethod) {

    Optional<PaymentPlugin> pluginFor = plugins.getPluginFor(paymentMethod);

    if (pluginFor.isPresent()) {
      return pluginFor.get();
    }

    throw new UnsupportedOperationException("No such payment method");
  }
}
