package com.company;

public class Test {
    public static void testHash(){
        int h = 23;
        HashTable ht = new HashTable(h, 3, 92);
        int t = 10, t2 = 24;
        int eq = t % h;
        int eq2 = t2 % h;
        if(ht.hashFun(t) == eq){
            System.out.println("hash test1 passed");
        }else System.out.println("hash test1 failed");
        if(ht.hashFun(t2) == eq2){
            System.out.println("hash test2 passed");
        }else System.out.println("hash test2 failed");
        System.out.println();
    }
    public static void testSeekSlot(){
        int h = 23;
        int step = 3;
        HashTable ht = new HashTable(h, step, 92);
        int hash1 = ht.seekSlot(5);
        ht.put(5);
        int hash2 = ht.seekSlot(28);
        ht.put(28);
        if(hash1 + 3 == hash2){
            System.out.println("seek test1 passed");
        }else System.out.println("seek test1 failed");
        int hash3 = ht.seekSlot(51);
        if(hash2 + 3 == hash3){
            System.out.println("seek test2 passed");
        }else System.out.println("seek test2 failed");
        System.out.println();
    }
    public static void testPut(){
        int h = 23;
        int step = 3;
        HashTable ht = new HashTable(h, step, 92);
        int t1 = 5, t2 = 28;
        ht.put(t1);
        if(ht.tableBool[t1 % h] && ht.table[t1 % h] == t1){
            System.out.println("put test1 passed");
        }else System.out.println("put test1 failed");
        ht.put(t2);
        if(ht.tableBool[t2 % h + step] && ht.table[t2 % h + step] == t2){
            System.out.println("put test2 passed");
        }else System.out.println("put test2 failed");
        System.out.println();
    }
    public static void testFind(){
        int h = 23;
        int step = 3;
        HashTable ht = new HashTable(h, step, 92);
        int t1 = 5, t2 = 28;
        ht.put(t1);
        ht.put(t2);
        if(ht.find(t1) == t1 % h){
            System.out.println("find test1 passed");
        }else System.out.println("find test1 failed");
        if(ht.find(t2) == t2 % h + step){
            System.out.println("find test2 passed");
        }else System.out.println("find test2 failed");
    }
}
