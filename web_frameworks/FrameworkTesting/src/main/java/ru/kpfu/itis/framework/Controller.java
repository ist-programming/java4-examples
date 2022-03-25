package ru.kpfu.itis.framework;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
    ModelAndView doAction(HttpServletRequest req);
}
