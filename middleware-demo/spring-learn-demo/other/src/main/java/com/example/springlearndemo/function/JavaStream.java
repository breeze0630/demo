package com.example.springlearndemo.function;

import com.example.springlearndemo.jdk.UserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args) {
        initStreamDemo();
        StringStreamDemo();
        ObjectStreamDemo();
        ListStreamDemo();
        getStream();
        transferArrayToList();
        StreamStaticMethod();
    }


    /**
     * 通过 Stream () （串行执行） 和 ParallelStream() （并行执行） 获得流
     * */
    private static void getStream(){
        System.out.println("---------------------getStream START----------------------------");

        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        System.out.println( stringStream);
        System.out.println(parallelStream);
    }

    /**
     * Arrays.stream() 装源数组转为流
     * */
    private static void transferArrayToList(){
        System.out.println("---------------------transferArrayToList START----------------------------");

        Integer[] numbers = new  Integer[10];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = i;
        }
        Stream<Integer> stream = Arrays.stream(numbers);
//        System.out.println(stream.collect(Collectors.toList()));
    }

    /**
     * Stream 的 静态方法
     * of() 可用于构建流
     * iterate() 迭代 流
     * */
    private static void StreamStaticMethod(){
        System.out.println("---------------------StreamStaticMethod START----------------------------");

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        System.out.println(stream.collect(Collectors.toList()));

        Stream<Integer> stream2 = Stream.iterate(0,(x) -> (x+2)).limit(6);
        System.out.println(stream2.collect(Collectors.toList()));

    }



    private static void ListStreamDemo() {
        System.out.println("-----------------------ListStreamDemo START--------------------------------------");
        int i = 0 ;
        List<FileClass> fileClasses= new ArrayList<>();
        for( ; i< 10 ; i++){
            FileClass fileClass = new FileClass(i,"name_" + i);
            fileClasses.add(fileClass);
        }

        System.out.println(fileClasses.stream().map(FileClass::getName).collect(Collectors.toList()));
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

    static class FileClass{
        private int id;
        private String name;

        public FileClass() {
        }

        public FileClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
