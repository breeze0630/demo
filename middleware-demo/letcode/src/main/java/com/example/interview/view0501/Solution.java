package com.example.interview.view0501;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().insertBits(1024, 19, 2, 6));
        System.out.println(new Solution().insertBits(0, 31, 0, 4));

    }

    public int insertBits(int N, int M, int i, int j) {
        List<Integer> NBit = getBits(N);
        List<Integer> MBit = getBits(M);
        int[] tmp = new int[j - i + 1];
        for (int k = 0; k < tmp.length; k++) {
            if (MBit.size() <= k ) {
                tmp[k] = 0;
            } else {
                tmp[k] = MBit.get(k);
            }
        }

        for (int k = 0; k < tmp.length; k++) {
            int tmpK = i + k;
            if (NBit.size()  <= tmpK ) {
                NBit.add(tmp[k]);
            } else {
                NBit.set(tmpK, tmp[k]);
            }
        }

        int sum = 0;
        for (int k = 0; k < NBit.size() ; k++) {
            sum = sum + NBit.get(k) * mul(k);
        }
        return sum;
    }
    public int mul(int count){
        return count == 0 ? 1 :  2 * mul(count-1);
    }

    public List<Integer> getBits(int i) {
        List<Integer> list = new LinkedList<>();
        while (i > 0) {
            int remainder = i % 2;
            list.add(remainder);
            i = i / 2;
        }
        return list;
    }


}
