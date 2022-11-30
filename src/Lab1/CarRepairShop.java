package Lab1;

import java.util.Set;
import  Lab1.vehicles.*;

public class CarRepairShop {
    Set<Car> carsInShop;
    int x;
    int y;
    int capacity;
    public CarRepairShop(int x, int y, int capacity) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    public void loadCar(Car car) {
        carsInShop.add(car);
    }

    public void unloadCar(Car car) {
        carsInShop.remove(car);
    }
}