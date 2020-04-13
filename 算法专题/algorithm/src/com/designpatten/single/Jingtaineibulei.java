package com.designpatten.single;

public class Jingtaineibulei {
    public static class Singleton3{
        private final static Jingtaineibulei jingtaineibulei = new Jingtaineibulei();
    }
    public Jingtaineibulei getInstance(){
        return Singleton3.jingtaineibulei;
    }
}
