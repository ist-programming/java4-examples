package ru.kpfru.itis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Container {
    public IModule getModule(boolean getProxy){
        if(getProxy) {
            try {
                // Java itself can work with proxies maden by interfaces only.
                // CGLIB and Javassist can do it with classes.
                IModule module = (IModule) Proxy.newProxyInstance(
                        Module.class.getClassLoader(),
                        Module.class.getInterfaces(),
                        new SpecificProxyInvocationHandler());
                //copy state to new instance
                return module;
            } catch (Throwable ex) {//Bad idea but whatever
                throw new IllegalArgumentException(ex.getMessage());
            }
        } else{
            return new Module();
        }
    }

    public static class SpecificProxyInvocationHandler implements InvocationHandler {

        @Override
        public String invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("processString")) {
                String arg = (String)args[0];
                return arg.toUpperCase();
            } else {
                throw new UnsupportedOperationException(
                        "Unsupported method: " + method.getName());
            }
        }
    }
}
