package com.sekimora.controller;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;

public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConigurableWebServerFactory> {
    @Override
    public void customize(ConigurableWebServerFactory factory) {
        factory.setPort(8086);
    }
}
