package com.haeny.lec13.java;

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    private static class LivingRoom {

        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
    }
}
