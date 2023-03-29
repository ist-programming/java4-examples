package ru.kpfru.itis.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Container {
    public Module getModule(boolean getProxy){
        if(getProxy) {
            try {
                DynamicType.Unloaded<? extends Module> type = new ByteBuddy()
                        .subclass(Module.class)
                        .method(net.bytebuddy.matcher.ElementMatchers.named("processString"))
                        .intercept(MethodDelegation.to(MethodDelegatorTarget.class))
                        .make();
                Class<? extends Module> newClass = type
                        .load(Module.class.getClassLoader())
                        .getLoaded()
                        ;
                return newClass.newInstance();
            } catch (Throwable ex) {//Bad idea but whatever
                throw new IllegalArgumentException(ex.getMessage());
            }
        } else{
            return new Module();
        }
    }

    public static class MethodDelegatorTarget{

        public static String processString(String str){
            return str.toUpperCase();
        }
    }
}
