package com.example.other.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 *
 * 一致性哈希算法
 * @auther: liubiao
 * @date: 2025-03-10
 */
public class ConsistentHash {

    // 使用 treemap 存储虚拟节点
    private final SortedMap<Integer,String> treeMap = new TreeMap<>();


    //每个真实节点的虚拟节点数
    private int numberOfReplicas;

    public ConsistentHash(int numberOfReplicas, List<String> nodes){

        this.numberOfReplicas = numberOfReplicas;
        for(String node:nodes){
            addNode(node);
        }

    }

    public void addNode(String node) {
        for(int i= 0 ; i< numberOfReplicas ; i++){
            String vir = node + "&&&" + i;
            treeMap.put(hash(vir),vir);
        }
    }

    public void removeNode(String node){
        for(int i= 0 ; i< numberOfReplicas ; i++){
            String vir = node + "&&&" + i;
            treeMap.remove(hash(vir));
        }
    }

    public String getNode(String key){
        if(treeMap.isEmpty()){
            return null;
        }
        int hashKey = hash(key) ;
        SortedMap<Integer,String> tailMap = treeMap.tailMap(hashKey);
        Integer nodeHash  = tailMap.isEmpty()? treeMap.firstKey() : tailMap.firstKey();
        return treeMap.get(nodeHash);
    }

    public int hash(String key){

        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(key.getBytes());
            byte[] digest = messageDigest.digest();
            return Math.abs(digest[0]) +
                    ((digest[1] & 0xFF)<<8) +( (digest[2] & 0xFF)<<16) + ((digest[3] & 0xFF)<<24);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
