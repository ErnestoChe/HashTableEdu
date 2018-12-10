package com.company;

public class Main {

    public static void main(String[] args) {
        Test.testHash();
        Test.testSeekSlot();
        Test.testPut();
        Test.testFind();
    }
}
class HashTable{
    private int size;
    private int stepLength;
    boolean[] tableBool;
    int[] table;

    HashTable(int scnsize, int step, int s){
        size = scnsize;
        stepLength = step;
        this.table = new int[s];
        this.tableBool = new boolean[s];
    }
    public int[] getTable(){
        return this.table;
    }
    public boolean[] getTableBool(){
        return this.tableBool;
    }
    int hashFun(int value){
        return value % size;
    }
    int seekSlot(int value){
        int hash = hashFun(value);
        int h = hash;
        while(tableBool[hash] && table[hash]!=value){
            hash += stepLength;
            if(h - hash > stepLength){
                hash = -1;
                break;
            }
            if(hash >= table.length){
                int dif = hash - table.length;
                hash = dif;
            }
        }
        return hash;
    }
    boolean put(int value){
        int ind = seekSlot(value);
        if(seekSlot(value) == -1){
            return false;
        }else{
            tableBool[ind] = true;
            table[ind] = value;
            return true;
        }
    }
    int find(int value){
        int ind = seekSlot(value);
        if(!tableBool[ind]){
            ind = -1;
        }
        return ind;
    }
}
class NativeDic{
    Object[] table;
    HashTable ht;
    NativeDic(int size){
        this.table = new Object[size];
        this.ht = new HashTable(23, 3, size);
    }
    public void put(Object key, int value){
        int ind = ht.seekSlot(value);
        ht.put(value);
        this.table[ind] = key;
    }
}