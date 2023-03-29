package ru.kpfru.itis.java;

import ru.kpfru.itis.bytebuddy.Module;

public class JavaApp {

    public static void main(String[] args) {
        Container context = new Container();
        IModule m = context.getModule(false);
        System.out.println(m.getClass());
        System.out.println(m.processString("Abc"));
    }
}
