package ru.kpfu.itis.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.site.MainConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private final String VIEWS_PREFIX = "/WEB-INF/jsp/";
    private final String VIEWS_SUFFIX = ".jsp";

    private ApplicationContext context;
    private Map<String, String> controllers = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new AnnotationConfigApplicationContext(MainConfig.class);

        controllers.put("/news", "newsController");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getRequestURI();
        String cleanRequestPath = requestPath.substring(req.getContextPath().length());
        if (controllers.containsKey(cleanRequestPath)) {
            Controller controller = (Controller) context.getBean(controllers.get(cleanRequestPath));
            ModelAndView mav = controller.doAction(req);
            loadView(mav, req, resp);
        } else {
            resp.getWriter().println("Page not found");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void loadView(ModelAndView mav, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Map.Entry<String, Object> entry : mav.getModel().entrySet()) {
            req.setAttribute(entry.getKey(), entry.getValue());
        }
        getServletContext().getRequestDispatcher(VIEWS_PREFIX + mav.getViewName() + VIEWS_SUFFIX).forward(req, resp);
    }
}
