package xyz.tong2.leetcode.recursion;

import java.util.*;

public class FindOrder_no210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int index = 0;
        boolean[] notStudy = new boolean[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] preArray : prerequisites) {
            notStudy[preArray[0]] = true;
            if (!map.containsKey(preArray[0]))
                map.put(preArray[0], new LinkedList<>());
            List<Integer> pre = map.get(preArray[0]);
            pre.add(preArray[1]);
        }

        for (int i = 0; i < notStudy.length; i++) {
            if (!notStudy[i])
                ans[index++]=i;
        }
        Stack<Integer> s = new Stack<>();
        for (Integer course : map.keySet()) {
            if (notStudy[course]) {
                s.push(course);
                while (!s.empty()){
                    int currentC = s.peek();
                    boolean  allPre = true;
                    for (int preC:map.get(currentC)){
                        if(notStudy[preC]) {
                            if(s.contains(preC))
                                return new int[0];
                            s.push(preC);
                            allPre = false;
                            break;
                        }
                    }
                    if(allPre) {
                        ans[index++] = currentC;
                        notStudy[s.pop()] = false;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindOrder_no210 solution = new FindOrder_no210();
        int[][] prerequisites= {{1,0}, {0,3} , {0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        System.out.println(Arrays.toString(solution.findOrder(7, prerequisites)));
    }
}
