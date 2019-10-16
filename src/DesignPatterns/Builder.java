package DesignPatterns;

class House {
    int door;
    int window;
    int wall;
    int price;


    private House(HouseBuilder houseBuilder) {
        this.door = houseBuilder.door;
        this.window = houseBuilder.window;
        this.wall = houseBuilder.wall;
        this.price = houseBuilder.price;
    }

    static class HouseBuilder {
        private int door;
        private int window;
        private int wall;
        private int price;

        public HouseBuilder setDoor(int door) {
            this.door = door;
            return this;
        }

        public HouseBuilder setWindow(int window) {
            this.window = window;
            return this;

        }

        public HouseBuilder setWall(int wall) {
            this.wall = wall;
            return this;

        }

        public HouseBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

}

public class Builder {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .setDoor(5)
                .setPrice(5)
                .setWall(1)
                .setWindow(4)
                .build();
        System.out.println(house.getClass());

    }


}
