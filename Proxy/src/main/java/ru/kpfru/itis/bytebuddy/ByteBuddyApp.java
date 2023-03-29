package ru.kpfru.itis.bytebuddy;

public class ByteBuddyApp {

    public static void main(String[] args) {
        Container context = new Container();
        Module m = context.getModule(false);
        System.out.println(m.getClass());
        System.out.println(m.processString("Abc"));
    }
}
