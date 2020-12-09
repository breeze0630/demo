package com.example.springlearndemo.function;

import com.example.springlearndemo.jdk.UserDto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
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
        BufferedReaderDemo();
        SplitAsStreamDemo();

        //对流的操作
        FilterStreamDemo();
        MapStreamDemo();
        FlatMapStreamDemo();

    }

    /**
     * 映射
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * */
    private static void FlatMapStreamDemo() {
        System.out.println("---------------------FlatMapStreamDemo START----------------------------");
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        Stream stream = list.stream().flatMap(s->{return Arrays.stream(s.split(",").clone());});

        stream.forEach(System.out::println);

    }

    /**
     * 映射
     * 接收一个函数作为参数，将函数应用到每个元素上，并将其映射成一个新的元素
     * */
    private static void MapStreamDemo() {
        System.out.println("---------------------MapStreamDemo START----------------------------");


        List<String> list = Arrays.asList("a,b,c", "1,2,3");

        //将每个元素转成一个新的且不带逗号的元素
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",",""));
        s1.forEach(System.out::println);
    }

    /**
     * filter：过滤流中的某些元素
     *  limit(n)：获取n个元素
     *  skip(n)：跳过n元素，配合limit(n)可实现分页
     *  distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
     * */
    private static void FilterStreamDemo() {
        System.out.println("---------------------FilterStreamDemo START----------------------------");
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);

        Stream<Integer> newStream = stream.filter(s -> s > 5) // 符合大于5 ==> 6 6 7 9 8 10 12 14 14
                .distinct() //去重 ==> 6 7 9 8 10 12 14
                .skip(2) //跳过前两个 ==> 9 8 10 12 14
                .limit(2); // 截取前两个9 8
        newStream.forEach(System.out::println);
    }

    /**
     * 使用 Pattern.splitAsStream() 方法，将字符串分隔成流
     * */
    private static void SplitAsStreamDemo() {
        System.out.println("---------------------SplitAsStreamDemo START----------------------------");

//        String str = "fasdfadsf,fdsfasdfsdl,fsdfadsdsf,fsdfasdfdsf,fdsfdasfasdresfesgsdcnsfsdfs,3123123qd,21543215412343,,fsdtrsdfrwnchn";
        String str = "";
        Pattern pattern = Pattern.compile(",");
        pattern.splitAsStream(str).forEach(System.out::println);
    }

    /**
     * 使用 BufferedReader.lines() 方法，将每行内容转成流
     * */
    private static void BufferedReaderDemo() {
        System.out.println("---------------------BufferedReaderDemo START----------------------------");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\dev\\github\\demo\\middleware-demo\\spring-learn-demo\\other\\src\\main\\resources\\static\\buffered.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);
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
