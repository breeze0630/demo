package com.example.springlearndemo.test;

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
    }


}

class Person implements Cloneable{

    private String name;

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
}
