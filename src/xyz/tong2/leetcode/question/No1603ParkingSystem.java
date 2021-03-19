package xyz.tong2.leetcode.question;

/**
 * @author liwei04
 * @time 2021年03月19日 09:24
 */
public class No1603ParkingSystem {
    private final int[] parkArray = new int[4];

    public No1603ParkingSystem(int big, int medium, int small) {
        parkArray[1] = big;
        parkArray[2] = medium;
        parkArray[3] = small;
    }

    public boolean addCar(int carType) {
        return (--parkArray[carType])>=0;
    }
}
