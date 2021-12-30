package xyz.tong2.leetcode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年12月16日 10:37
 */
public class No1610VisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int ans = 0;
        List<List<Integer>> pos = points.stream().filter(integers -> {
            integers.set(0, integers.get(0) - location.get(0));
            integers.set(1, integers.get(1) - location.get(1));
            return integers.get(0) != 0 || integers.get(1) != 0;
        }).collect(Collectors.toList());
        double angleD = Math.PI * angle / 180;

        ans += (points.size() - pos.size());

        double[] posAngle = pos.stream().mapToDouble(value -> {
            Object[] arr1 =  value.toArray();
            int x = (int) arr1[0];
            int y = (int) arr1[1];
            double a = Math.atan2(y,x);
            if (y >= 0)
                return a;
            return Math.PI * 2 - a;
        }).toArray();

        Arrays.sort(posAngle);
        int curMaxCount = 0;
        int first = 0;
        int last = 0;
        double EQUALS_MIN = 0.0000000000001;
        for (; last < posAngle.length; first++) {
            while (last < posAngle.length&&(posAngle[last] < posAngle[first] + angleD||Math.abs(posAngle[first] + angleD -posAngle[last])< EQUALS_MIN)) {
                last++;
            }
            curMaxCount = Math.max(curMaxCount, last - first);
        }
        last = 0;
        for (; first < posAngle.length; first++) {
            double angleLeft = angleD - Math.PI * 2 - posAngle[first];
            if (angleLeft >= 0) {
                while (posAngle[last] < angleLeft||Math.abs(angleLeft-posAngle[last])< EQUALS_MIN) {
                    last++;
                }
            }
            curMaxCount = Math.max(curMaxCount, (posAngle.length - first + last));
        }
        return curMaxCount + ans;
    }

    public static void main(String[] args) {
        No1610VisiblePoints visiblePoints = new No1610VisiblePoints();
        List<List<Integer>> poss = new ArrayList<>();
        poss.add(Arrays.asList(60,61));
        poss.add(Arrays.asList(58,47));
        poss.add(Arrays.asList(17,26));
        poss.add(Arrays.asList(87,97));
        poss.add(Arrays.asList(63,63));
        poss.add(Arrays.asList(26,50));
        poss.add(Arrays.asList(70,21));
        poss.add(Arrays.asList(3,89));
        poss.add(Arrays.asList(51,24));
        poss.add(Arrays.asList(55,14));
        poss.add(Arrays.asList(6,51));
        poss.add(Arrays.asList(64,21));
        poss.add(Arrays.asList(66,33));
        poss.add(Arrays.asList(54,35));
        poss.add(Arrays.asList(87,38));
        poss.add(Arrays.asList(30,0));
        poss.add(Arrays.asList(37,92));
        poss.add(Arrays.asList(92,12));
        poss.add(Arrays.asList(60,73));
        poss.add(Arrays.asList(75,98));
        poss.add(Arrays.asList(1,11));
        poss.add(Arrays.asList(88,24));
        poss.add(Arrays.asList(82,92));
        System.out.println(visiblePoints.visiblePoints(poss,40,Arrays.asList(15,50)));
    }
}
