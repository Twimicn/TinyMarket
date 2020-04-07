package cn.ivanlu.market.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @RequestMapping(value = {"/", "/index"})
    @ResponseBody
    public String index() {
        return dbUrl;
    }
}
