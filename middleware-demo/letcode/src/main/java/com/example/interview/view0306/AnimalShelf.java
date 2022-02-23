package com.example.interview.view0306;

import java.util.LinkedList;

public class AnimalShelf {

    LinkedList<int[]> list = new LinkedList<>();

    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        list.add(animal);
    }

    public int[] dequeueAny() {

        int[] animal = {-1,-1};
        if(list.size() > 0) animal = list.removeFirst();
        return animal;
    }

    public int[] dequeueDog() {
        int[] tmp = {-1,-1};
        for( int i = 0; i < list.size() ; i++)
        {
            if(list.get(i)[1] == 1){
                tmp = list.remove(i);
                break;
            }
        }
        return tmp;
    }

    public int[] dequeueCat() {
        int[] tmp = {-1,-1};
        for( int i = 0; i < list.size() ; i++)
        {
            if(list.get(i)[1] == 0){
                tmp = list.remove(i);
                break;
            }
        }

        return tmp;
    }


}
