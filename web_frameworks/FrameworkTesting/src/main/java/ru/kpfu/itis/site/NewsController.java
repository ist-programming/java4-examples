package ru.kpfu.itis.site;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.framework.Controller;
import ru.kpfu.itis.framework.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsController implements Controller {
    @Override
    public ModelAndView doAction(HttpServletRequest req) {
        List<String> newsList = new ArrayList<>();
        ModelAndView mav = new ModelAndView("news");
        mav.addData("news", newsList);
        return mav;
    }
}
