package com.example.springlearndemo.kaoshi;

import java.util.*;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int listNumInsert = scanner.nextInt();
        List<Integer> list = new ArrayList<>(listNumInsert);
        if(listNumInsert <= 0){
            System.out.println("数组长度为0.");
            scanner.close();
            return;
        }
        //准备数组数据
        Random random = new Random();
        for (int index = 0 ; index < listNumInsert ; index++){
            int num = random.nextInt(50)+1;
            list.add(num);
        }
        //查找并排序
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int index = 0 ; index < list.size() ; index++){
            if(list.get(index) % 2 == 0 &&  countMap.get(list.get(index)) == null ){
                countMap.put(list.get(index),1);
            }else if(list.get(index) % 2 == 0){
                countMap.put(list.get(index),countMap.get(list.get(index))+1);
            }
        }
        if(countMap.size() <= 0) {
            System.out.println("无正常结果数据");
            scanner.close();
            return;
        }
        List<Map.Entry<Integer,Integer>> sortList = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            sortList.add(entry);
        }
        sortList.sort(new SortByValue());
        for (int index = 0 ; index < sortList.size(); index++){
            System.out.printf("偶数 %s 次数 : %s\n",sortList.get(index).getKey(),sortList.get(index).getValue());
        }
        scanner.close();
    }

}
class SortByValue implements Comparator<Map.Entry<Integer,Integer>>{

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

        return o2.getValue().compareTo(o1.getValue());
    }
}
