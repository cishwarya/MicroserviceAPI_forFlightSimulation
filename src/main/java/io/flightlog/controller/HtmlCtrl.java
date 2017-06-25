package io.flightlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlCtrl {

  @RequestMapping("/")
  public String index() {
    return "index.html";
  }

  @RequestMapping("/consume")
  public String consumeApi() {
    return "consume-api.html";
  }

  @RequestMapping("/deploy")
  public String deployAll() {
    return "deploy-all.html";
  }
}
