package cn.ivanlu.market.controller;

import cn.ivanlu.market.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/index"})
    @ResponseBody
    public String index() {
        return userService.getById(1).toString();
    }
}
