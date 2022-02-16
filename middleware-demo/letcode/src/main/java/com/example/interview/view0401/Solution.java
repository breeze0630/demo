package com.example.interview.view0401;

import java.util.*;

public class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < graph.length ; i++){
            if(map.containsKey(graph[i][0])){
                    map.get(graph[i][0]).add(graph[i][1]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(graph[i][1]);
                map.put(graph[i][0],list);
            }
        }


        return hasPath(n,map,start,target);
    }

    public boolean hasPath(int n, Map<Integer, List<Integer>> graph, int start, int target){

        LinkedList<Integer> deque = new LinkedList<>();
        deque.add(start);
        boolean[] v = new boolean[n];

        while (!deque.isEmpty()){
            int current = deque.pop();
            List<Integer> graphList = graph.get(current);
            if(graphList == null){
                continue;
            }
            for(Integer cTar : graphList){
                if(cTar == target){
                    return true;
                }
                if(v[cTar]){
                    continue;
                }
                v[cTar] = true;
                deque.add(cTar);
            }
        }

        return false;
    }


}
