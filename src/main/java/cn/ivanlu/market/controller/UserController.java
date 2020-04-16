package cn.ivanlu.market.controller;

import cn.ivanlu.market.annotation.Permission;
import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.model.User;
import cn.ivanlu.market.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<User> apiLogin(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<User> apiRegister(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phone
    ) {
        User user = new User(username, password, email, phone);
        return userService.register(user);
    }

    @Permission("admin")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<List<User>> apiList(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return ApiResponse.<List<User>>builder().status(0).msg("ok").data(userService.getUsersByPage(page, size)).build();
    }

    @Permission("login")
    @RequestMapping(value = "/my_info", method = RequestMethod.POST)
    @ResponseBody
    public User apiMyInfo(HttpServletRequest request) {
        User user = (User) request.getAttribute("curUser");
        return user;
    }
}
