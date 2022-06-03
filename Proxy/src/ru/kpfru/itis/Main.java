package ru.kpfru.itis;

public class Main {

    public static void main(String[] args) {
        Container context = new Container();
        String result = context.getModule(false).processString("Abc");
        System.out.println(result);
    }
}
