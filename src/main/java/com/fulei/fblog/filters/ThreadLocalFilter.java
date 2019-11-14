package com.fulei.fblog.filters;


import com.fulei.fblog.dto.UserInfoDto;
import com.fulei.fblog.utils.ThreadLocalUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author fulei
 * @Title: ThreadLocalFilter
 * @ProjectName ferry
 * @Description: ThreadLocalFilter
 * @date 2019/11/5 17:21
 */
public class ThreadLocalFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // 得到区域信息
    fillThreadLocal((HttpServletRequest)servletRequest);
    try {
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      // tomcat线程重用需要删除(其他容器没问题)
      ThreadLocalUtil.clearThreadLocal();
    }
  }

  private void fillThreadLocal(HttpServletRequest request) {
    // 区域信息
    UserInfoDto user = getUserFromSession(request);
    if (user != null) {
      ThreadLocalUtil.setUser(user);
    }
  }

  private UserInfoDto getUserFromSession(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return null;
    }
    // 从session中获取区域信息放到工具类中
    return (UserInfoDto) session.getAttribute(ThreadLocalUtil.KEY_USER);
  }
}
