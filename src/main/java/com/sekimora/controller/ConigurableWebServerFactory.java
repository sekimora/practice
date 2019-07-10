package com.sekimora.controller;

import org.springframework.boot.web.server.WebServerFactory;

public interface ConigurableWebServerFactory extends WebServerFactory {
    void setPort(int i);
}
