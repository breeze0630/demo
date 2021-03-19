package com.example.springlearndemo.test;

import java.math.BigDecimal;
import java.util.*;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        String s = "name";
        System.out.println(s);
        s = s+ " name";
        System.out.println(s);

        Person person1 = new Person();
        person1.setName("person1‘s name");

        Person person2 = (Person) person1.clone();
        System.out.println( person1+" "+person2);

        System.out.println( person1 == person2 ? "引用相同" : "引用不同");
        System.out.println( person1.getName() == person2.getName() ? "浅引用" : "深引用" );
        System.out.println( person1.getName().equals(person2.getName() )  );


        String name1 = "name";
        String name2 = "name";
        System.out.println( "name == name ? : "+ (name1==name2));

        head :
        for(int i = 0 ; i< 10; i++)
        {
            System.out.println("i = " + i);
            for( int j  = 0 ; j < 10 ; j++)
            {
                System.out.println("    j = "+ j);
                for(int k = 0 ; k < 10;k++){
                    System.out.println("        k = " + k);
                    if(k == 5)
                    {
                        break head;
                    }
                }
            }
        }

        System.out.println("-------------------------------------------------");
        boolean end = true;
        for(int i = 0 ; i< 10 && end; i++)
        {
            System.out.println("i = " + i);
            for( int j  = 0 ; j < 10 && end ; j++)
            {
                System.out.println("    j = "+ j);
                for(int k = 0 ; k < 10 && end;k++){
                    System.out.println("        k = " + k);
                    if(k == 5)
                    {
                        end = false;
                    }
                }

            }
        }

        System.out.println("---------------HASHMAP 排序-------------");
        HashMap<Integer,Person> hashMap = new HashMap<Integer, Person>();
        Random random = new Random();
        for (int i = 0 ; i < 100; i++){
            int inner = random.nextInt(100);
            hashMap.put(i,new Person("name"+i,inner));
        }

        System.out.println("---------------hashMap source-------------");
        System.out.println(hashMap.toString());
        Set<Map.Entry<Integer,Person>> entrySet = hashMap.entrySet();
        List<Map.Entry<Integer,Person>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Person>>() {
            @Override
            public int compare(Map.Entry<Integer, Person> o1, Map.Entry<Integer, Person> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge();
            }
        });

        LinkedHashMap<Integer,Person> linkedHashMap = new LinkedHashMap<Integer, Person>();
        for (Map.Entry<Integer,Person> entry:list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        System.out.println("---------------hashMap dest-------------");

        System.out.println(linkedHashMap.toString());
    }


}

class Person implements Cloneable{

    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
