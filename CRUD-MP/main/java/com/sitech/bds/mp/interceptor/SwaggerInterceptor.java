package com.sitech.bds.mp.interceptor;


import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SwaggerInterceptor extends HandlerInterceptorAdapter {
    private String username;
    private String password;
    public SwaggerInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        boolean isAuthSuccess = httpBasicAuth(authorization);
        if (!isAuthSuccess) {
            response.setCharacterEncoding("utf-8");
            response.setStatus(401);
//            response.setStatus(401,"Unauthorized");
            response.setHeader("WWW-authenticate", "Basic realm=\"Realm\"");
            try (PrintWriter writer = response.getWriter()) {
                writer.print("Forbidden, unauthorized user");
            }
        }
        return isAuthSuccess;
    }
    public boolean httpBasicAuth(String authorization) throws IOException {
        if (authorization != null && authorization.split(" ").length == 2) {
            String userAndPass = new String(new BASE64Decoder().decodeBuffer(authorization.split(" ")[1]));
            String username = userAndPass.split(":").length == 2 ? userAndPass.split(":")[0] : null;
            String password = userAndPass.split(":").length == 2 ? userAndPass.split(":")[1] : null;
            if (this.username.equals(username) && this.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        if (!pathMatcher.match("/swagger-ui.html", uri) && !pathMatcher.match("/webjars/**", uri)) {
            response.setStatus(404);
            return;
        }
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/META-INF/resources" + uri);
        if (resources != null && resources.length > 0) {
            FileCopyUtils.copy(resources[0].getInputStream(), response.getOutputStream());
        } else {
            response.setStatus(404);
        }
    }

}