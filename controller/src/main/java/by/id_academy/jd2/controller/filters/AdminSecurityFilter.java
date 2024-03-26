package by.id_academy.jd2.controller.filters;

import by.id_academy.jd2.dto.Role;
import by.id_academy.jd2.dto.UserDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)) {
            UserDTO user = (UserDTO) session.getAttribute("user");
            if (Role.ADMIN.equals(user.getRole())) {
                chain.doFilter(request, response);
            }
        } else {
            res.sendRedirect(contextPath + "/template/signLogin.jsp");
        }
    }
}

