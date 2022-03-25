package ru.kpfu.itis.framework;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private Map<String, Object> model;
    private String viewName;

    public ModelAndView(String viewName) {
        this(new HashMap<String, Object>(), viewName);
    }

    public ModelAndView(Map<String, Object> model, String viewName) {
        this.model = model;
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void addData(String key, Object data) {
        model.put(key, data);
    }
}
