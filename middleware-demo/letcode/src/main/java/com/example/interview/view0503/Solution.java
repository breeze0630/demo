package com.example.interview.view0503;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1775));
        System.out.println(new Solution().reverseBits(0));
        System.out.println(new Solution().reverseBits(6));
        System.out.println(new Solution().reverseBits(2147483647));

    }

    public int reverseBits(int num) {

        List<Integer> list = new LinkedList<>();
        while (num > 0) {
            int tmp = num % 2;
            list.add(tmp);
            num = num / 2;
        }

        //存1 连串的坐标
        int[][] data = new int[][]{{0, 0}, {0, 0}};

        boolean isAdd = false;
        int res = 0;
        if (list.size() == 0) {
            return 1;
        }
        while (list.size() % 4 != 0) {
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {

                if (!isAdd) {
                    data[1][0] = i;
                    isAdd = true;
                } else {
                    data[1][1] = i;
                }
            } else {
                isAdd = false;

                if (data[1][0] - data[0][1] > 2) {
                    int tmp = Math.max(data[0][1] - data[0][0] + 2, data[1][1] - data[1][0] + 2);
                    res = Math.max(tmp, res);
                } else if (data[1][0] - data[0][1] >= 0) {
                    res = Math.max(res, data[1][1] - data[0][0] + 1);
                } else if (data[1][1] - data[0][0] == 0) {
                    res = 1;
                }

                if (data[1][1] != 0) {
                    data[0][0] = data[1][0];
                    data[0][1] = data[1][1];
                    data[1][0] = 0;
                    data[1][1] = 0;
                }

            }
        }

        if (data[1][1] != 0) {
            if (data[1][0] - data[0][1] > 2) {
                int tmp = Math.max(data[0][1] - data[0][0] + 2, data[1][1] - data[1][0] + 2);
                res = Math.max(tmp, res);
            } else if (data[1][0] - data[0][1] >= 0) {
                res = Math.max(res, data[1][1] - data[0][0] + 1);
            } else if (data[1][1] - data[0][0] == 0) {
                res = 1;
            }
        }


        return res;
    }
}
