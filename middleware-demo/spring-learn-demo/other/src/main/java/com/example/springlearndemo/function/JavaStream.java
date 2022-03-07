package com.example.springlearndemo.function;

import com.example.springlearndemo.jdk.UserDto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args) {
        ListMatchStreamDemo();
        FlatMapStreamDemo();
/*        initStreamDemo();
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
        SortStreamDemo();
        
        PeekStreamDemo();

        MatchStreamDemo();

        ReduceStreamDemo();

        CollectStreamDemo();

        MapComputeDemo();

        ListToMapStreamDemo();

        GroupingStreamDemo();

        ArrayToListStreamDemo();
        */

    }
    private static void ListMatchStreamDemo() {
        System.out.println("---------------------ListMatchStreamDemo START----------------------------");

        List<String> all = Arrays.asList("a","b","c");
        List<String> check = Arrays.asList("b");
        System.out.println(" anyMatch:  " + all.stream().anyMatch(check::contains));
        System.out.println(" allMatch:  " + all.stream().allMatch(check::contains));


    }
    /**
     * 测试asList 函数
     */
    private static void ArrayToListStreamDemo(){
        System.out.println("---------------------ArrayToListStreamDemo START----------------------------");

        System.out.println(Arrays.asList(new int[]{1,2}));
        System.out.println(Arrays.asList(new Integer[]{1,2}));
        List<Integer> list = Stream.of(new Integer[]{1,2}).collect(Collectors.toList());
        list.add(4);
        System.out.println(list);

        System.out.println("---------------------ArrayToListStreamDemo END----------------------------");

    }

    private static void GroupingStreamDemo() {
        System.out.println("---------------------GroupingStreamDemo START----------------------------");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"aa",20));
        students.add(new Student(2,"ab",20));
        students.add(new Student(3,"bb",25));
        students.add(new Student(4,"bc",18));
        students.add(new Student(5,"bc",32));
        students.add(new Student(6,"abc",32));

        //按年龄分组

        Map<Integer,List<Student>> listMap = students.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(listMap);

        System.out.println("---------------------GroupingStreamDemo END----------------------------");
    }

    private static void ListToMapStreamDemo(){
        System.out.println("---------------------ListToMapStreamDemo START----------------------------");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"aa",1));
        students.add(new Student(2,"ab",2));
        students.add(new Student(3,"bb",3));
        students.add(new Student(4,"bc",1));
        students.add(new Student(5,"bc",2));
        students.add(new Student(5,"abc",3));
        //后面的 (k1,k2) -> k2)  ： 重复时，后面的覆盖前面 , 或者在 {} 中重新定义也可以
        Map<Integer,Student> studentMap = students.stream().collect(Collectors.toMap(Student::getId, Function.identity(),(k1,k2) -> {
            Student student= new Student(k1.getId(),"",0);
            student.setName( k1.getName() + k2.getName());
            student.setAge(k1.getAge()+ k2.getAge());
            return student;
        }));
        System.out.println(studentMap);

        System.out.println("---------------------ListToMapStreamDemo END----------------------------");
    }

    private static void MapComputeDemo() {
        System.out.println("---------------------MapComputeDemo START----------------------------");

        List<String> list = Arrays.asList("1","2","3","1","5","2","10","2","6","23","1");
        HashMap<String,Integer> hashMap = new HashMap();
        for (String s : list ){
            hashMap.compute(s,(k,v) -> {return v ==null ? 1 : ++v ;});
        }

        System.out.println(hashMap);
    }

    private static void CollectStreamDemo() {
        System.out.println("---------------------CollectStreamDemo START----------------------------");

    }

    /**
     * reduce
     * 适用于求和，累加
     * reduce 累加过程中需要判断的，判断第二个参数，第一个参数是上一次执行的结果
     *
     * */
    private static void ReduceStreamDemo() {
        System.out.println("---------------------ReduceStreamDemo START----------------------------");

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = list1.stream().reduce(0,(a,b) -> {return  a+b;});
        System.out.println("sum :  " + sum);

        List<Student> students = new ArrayList<>();
        students.add(new Student("aa",1));
        students.add(new Student("ab",2));
        students.add(new Student("bb",3));
        students.add(new Student("bc",1));
        students.add(new Student("bc",2));
        students.add(new Student("abc",3));

        Student sumAeg = students.stream().reduce(new Student("bb",0),(a,b) -> {
            if(b.getName().contains("a")) {
                a.setAge(a.getAge() + b.getAge());
            }
            return  a;});

        System.out.println("sumAeg :  " + sumAeg.getAge());

        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6);

        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);   // 300

        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println(v1);  //310

        Integer v2 = list.stream().reduce(0,
                (x1, x2) -> {
                    System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v2); // -300

        Integer v3 = list.parallelStream().reduce(0,
                (x1, x2) -> {
                    System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 + x2;
                },
                (x1, x2) -> {
                    // 这个函数中的2个参数是上个BiFunction 中的处理结果,各结果处理顺序是乱的，因为是通过 fock join 多线程处理的
                    System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v3); //21

    }

    private static void MatchStreamDemo() {
        System.out.println("---------------------MatchStreamDemo START----------------------------");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list.stream().allMatch(e ->
            e > 3 || e<2
        ); //false
        boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list.stream().findFirst().get(); //1
        Integer findAny = list.stream().findAny().get(); //1

        long count = list.stream().count(); //5
        Integer max = list.stream().max(Integer::compareTo).get(); //5
        Integer min = list.stream().min(Integer::compareTo).get(); //1

        System.out.printf("allMatch:%s ; noneMatch:%s ; anyMatch:%s ; findFirst:%s ; findAny:%s ;count:%s ; max:%s ;  min:%s ; \n",
                allMatch,noneMatch,anyMatch,findFirst,findAny,count,max,min);

        List<Student> students = new ArrayList<>();
        students.add(new Student("aa",10));
        students.add(new Student("ab",32));
        students.add(new Student("bb",51));
        students.add(new Student("bc",33));
        students.add(new Student("bc",32));
        students.add(new Student("abc",21));

        System.out.printf("是否都小于30岁：%s \n",students.stream().allMatch( o -> o.getAge()<30));
        System.out.printf("是否年龄都在20-30岁之间：%s \n",students.stream().allMatch( o -> o.getAge()<30 && o.getAge()> 20));
        System.out.printf("是否名字里都没有D：%s \n",students.stream().noneMatch( o -> o.getName().contains("d")));
        System.out.printf("是否有叫aa并且在30岁以上的人：%s \n",students.stream().anyMatch( o -> o.getName().equals("aa") && o.getAge()> 30));


        System.out.printf("找出第一个人：%s \n",students.stream().findFirst());
        System.out.printf("随机抽一个人：%s \n",students.stream().findAny());
        System.out.printf("随机抽一个人：%s \n",students.stream().findAny());
        System.out.printf("随机抽一个人：%s \n",students.stream().findAny());


    }

    /**
     *
     *消费
     * peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
     *
     * peek 流会直接修改数据信息
     * */
    private static void PeekStreamDemo() {
        System.out.println("---------------------PeekStreamDemo START----------------------------");
        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        List<Student> studentList = Arrays.asList(s1, s2);
        // peek 流会直接修改数据信息
        studentList.stream()
                .peek(o -> {
                    if(o.getAge() >= 20)
                    {
                        o.setName(o.getName()+"1");
                    }
                }).forEach(System.out::println);

        List<Student> students = studentList.stream()
                .peek(o -> {
                    if(o.getAge() >= 20)
                    {
                        o.setName(o.getName()+o.getAge());
                    }
                }).collect(Collectors.toList());
        System.out.println("studentList:" + studentList);

        System.out.println("students:" +students);

    }

    /**
     * 排序
     * sorted() 自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：定制排序，自定义 Comparator 排序器
     * */
    private static void SortStreamDemo() {
        System.out.println("---------------------SortStreamDemo START----------------------------");

        List<String> sourceList = Arrays.asList("aa","ab","bb","bc","ac","abc");
        sourceList.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------先按姓名升序，姓名相同则按年龄升序 START----------------------------");
        //自定义排序：先按姓名升序，姓名相同则按年龄升序
        List<Student> students = new ArrayList<>();
        students.add(new Student("aa",10));
        students.add(new Student("ab",32));
        students.add(new Student("bb",51));
        students.add(new Student("bc",33));
        students.add(new Student("bc",32));
        students.add(new Student("abc",21));

        students.stream().sorted((o1,o2)->{
            if(o1.getName().equals(o2.getName())){
                return o1.getAge() - o2.getAge();
            }else {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(System.out::println);

        System.out.println("---------------------按姓名升序 START----------------------------");
        //自定义排序：按姓名升序
        students.stream().sorted((o1,o2)->{
            return o1.getName().compareTo(o2.getName());
        }).forEach(System.out::println);
        System.out.println("---------------------按年龄升序 START----------------------------");
        //自定义排序：按年龄升序
        students.stream().sorted((o1,o2)->{
            return o1.getAge()-o2.getAge();
        }).forEach(System.out::println);

        System.out.println("---------------------按年龄升序(不使用lambada表达式) START----------------------------");
        //自定义排序：按年龄升序
        students.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()- o2.getAge();
            }
        }).forEach(System.out::println);
    }

    /**
     * 映射
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * */
    private static void FlatMapStreamDemo() {
        System.out.println("---------------------FlatMapStreamDemo START----------------------------");
        List<String> list = Arrays.asList("a,b,c,4", "1,2,3,a");
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
