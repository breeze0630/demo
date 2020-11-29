package com.example.springlearndemo.jdk;

import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class JavaStream {

    public static void main(String[] args) {
        initStreamDemo();
        StringStreamDemo();
        ObjectStreamDemo();
        listToMap();
    }

    private static void initStreamDemo(){
        System.out.println("-----------initStreamDemo START----------------------");

        IntStream
                .range(2,10)
//                .skip(1) //跳过前5个
                .forEach(System.out::print);
        System.out.println();

       Stream.of(1,4,2,3,5,3).sorted(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1-o2;
           }
       }).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        System.out.println("--------------获取对应的平方数-------------");
        numbers.stream().map( i -> i*i).collect(Collectors.toList()).forEach(System.out::println);

    }

    private static void StringStreamDemo(){
        System.out.println("-----------StringStreamDemo START----------------------");

        Stream.of("Ava","Ave","Aa").sorted().forEach(System.out::println);
    }

    private static void ObjectStreamDemo(){
        System.out.println("-----------ObjectStreamDemo START----------------------");
        Stream.of(new UserDto(1,"name1"),new UserDto(2,"name2"),new UserDto(3,"3"))
                .sorted(new Comparator<UserDto>() {
                    @Override
                    public int compare(UserDto o1, UserDto o2) {
                        return o1.getId() - o2.getId();
                    }
                })
                .skip(1)
                .forEach(System.out::println);

        UserDto[] list = new UserDto[3];
        list[0] = new UserDto(1,"name1")  ;
        list[1] = new UserDto(2,"name2")  ;
        list[2] = new UserDto(3,"3")  ;

        Stream.of(list)
                .sorted(new Comparator<UserDto>() {
                    @Override
                    public int compare(UserDto o1, UserDto o2) {

                        return o1.getId() - o2.getId();
                    }
                })
                .filter(k-> k.getId() == 1)
                .forEach(System.out::println);

    }

    /**
     * list 转 map
     * 多个userDto 可能需要合并的场景，
     * 1、List<UserDto> --> Map<Integer,List<UserDto>
     * */
    private static void listToMap(){
        List<UserDto> userDtos = new ArrayList<>();
        int i = 1;
        while (i <= 100){
            UserDto userDto = new UserDto();
            if(i%2==0){
                userDto.setId(i-1);
            }else {
                userDto.setId(i);
            }
            userDto.setName("name"+i);
            userDtos.add(userDto);
            i++;
        }

        Map<Integer,List<UserDto>> userMap = userDtos.stream().collect(Collectors.toMap(
                UserDto::getId,
                k -> {
                    List<UserDto> userDtoList = new ArrayList<>();
                    userDtoList.add(k);
                    return userDtoList;
                },(List<UserDto> list1,List<UserDto> list2) -> {
                    list1.addAll(list2);
                    return list1;
        }
        ));

        userMap.forEach((k,v) -> {System.out.println("k : "+ k + " , v : " + v);});

    }
    /**
     * list 转 map
     * 不需要合并
     * 2、List<UserDto> --> Map<Integer,UserDto>
     * */
    private static void listToMap2() {
        List<UserDto> userDtos = new ArrayList<>();
        int i = 1;
        while (i <= 100) {
            UserDto userDto = new UserDto();
            userDto.setId(i);
            userDto.setName("name" + i);
            userDtos.add(userDto);
            i++;
        }

        Map<Integer, UserDto> userMap = userDtos.stream().collect(Collectors.toMap(
                UserDto::getId,
                k -> {
                    return k;
                }
        ));

        userMap.forEach((k,v) -> {System.out.println("k : "+ k + " , v : " + v);});
        /**或者
         *
         Map<Integer,UserDto> userMap = userDtos.stream().collect(Collectors.toMap(
         UserDto::getId,
         k->(k)
         ));
        * */


    }
}
