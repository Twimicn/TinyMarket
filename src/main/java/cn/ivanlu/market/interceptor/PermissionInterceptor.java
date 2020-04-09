package cn.ivanlu.market.interceptor;

import cn.ivanlu.market.annotation.Permission;
import cn.ivanlu.market.model.User;
import cn.ivanlu.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Permission permission = handlerMethod.getMethod().getAnnotation(Permission.class);
            if (permission == null) {
                permission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Permission.class);
            }
            if (permission != null && !StringUtils.isEmptyOrWhitespace(permission.value())) {
                if (permission.value().equals("login") || permission.value().equals("admin")) {
                    String token = request.getParameter("token");
                    if (StringUtils.isEmpty(token)) {
                        sendError(2003, "非法的Token", response);
                        return false;
                    }
                    User user = userService.getUserByToken(token);
                    if (user == null) {
                        sendError(2003, "非法的Token", response);
                        return false;
                    }
                    if (permission.value().equals("admin") && user.getRoleId() != 1) {
                        sendError(2002, "需要管理员权限", response);
                        return false;
                    }
                    request.setAttribute("curUser", user);
                }
            }
        }
        return true;
    }

    private void sendError(int code, String msg, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("{\"status\":" + code + ",\"msg\":\"" + msg + "\"}");
        printWriter.close();
    }
}
