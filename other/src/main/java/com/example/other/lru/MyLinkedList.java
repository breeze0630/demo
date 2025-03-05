package com.example.other.lru;

/**
 * 用链表完成LRU算法，最近最少使用，
 * 尾插法，需要清理时，从头部开始清理
 * @auther: liubiao
 * @date: 2025-03-02
 */
public class MyLinkedList {

    private Node first ;

    private Node end;

    public boolean addNode(String key,String value){
        Node node = new Node(key,value);
        if(end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end  = node;
        if(first == null){
            first = node;
        }
        return true;
    }

    public boolean refreshNode(String key){
        removeNode(key,null);
        addNode(key, null);
        return true;
    }


    public boolean removeFirst(){
        Node current = first;
        if(current != null && current.next != null){
            //删除当前节点，后置节点前移
            Node currentNext = current.next;
            Node currentPre = current.pre;
            currentNext = current.next.next;
            currentPre = current.next.pre;
        }else if(current != null && current.next == null){
            first = null;
            end = null;
        }
        return true;
    }
    public boolean removeNode(String key,String value){
        Node current = first;
        while (current != null){
            if(current.key.equals(key)){
                //删除当前节点，后置节点前移
                Node preNode = current.pre;
                preNode.next = current.next;
                return true;
            }
            current = current.next;
        }
        return true;
    }
    public String toString() {
        Node current = first;

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        while (current != null){
            stringBuffer.append(current.key).append(",");
            current = current.next;
        }
        if(stringBuffer.toString().endsWith(","))
        {
            stringBuffer.deleteCharAt(stringBuffer.toString().length()-1);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();

    }

    class Node{

        Node pre;
        Node next;

        String key;
        String value;

        public Node(){}

        public Node(String key,String value){
            this.key = key;
            this.value = value;
        }
    }
}
