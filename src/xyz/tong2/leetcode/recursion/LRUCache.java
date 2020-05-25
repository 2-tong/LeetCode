package xyz.tong2.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetCode-146题：LRU缓存
 *
 * */
public class LRUCache {
    Node head;
    Node tail;
    Map<Integer,Node> nodeMap;
    final int capacity;
    int count=0;
    private static class Node{
        private Node pre;
        private Node next;
        int key;
        int val;

        public Node(int key,int val){
            this.val=val;
            this.key=key;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        nodeMap = new HashMap<>();
    }

    private void rePosToTail(Node node){
        if(count!=1&&node!=tail){
            if(node==head)
                head=node.next;
            else
                node.pre.next=node.next;
            node.next.pre=node.pre;
            node.pre=tail;
            node.next=null;
            tail.next=node;
            tail=node;
        }
    }

    private void removeFirst(){
        nodeMap.remove(head.key);
        head=head.next;
        if(head!=null)
            head.pre=null;
        count--;
    }

    private void addToTail(Node node){
        if(count==capacity)
            removeFirst();
        if(count==0){
            head=tail=node;
        }
        else {
            tail.next = node;
            node.pre=tail;
            tail=node;
        }
        nodeMap.put(node.key,node);
        count++;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node==null)
            return -1;
        rePosToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(!nodeMap.containsKey(key))
            addToTail(new Node(key,value));
        else {
            Node node = nodeMap.get(key);
            node.val=value;
            rePosToTail(node);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p  =  head;
        while (p!=null) {
            sb.append(p.val);
            p=p.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5,5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }
}
