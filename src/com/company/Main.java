package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashTable ht = new HashTable();
        ht.put(5);
    }
}
class HashTable{
    int size;
    int stepLength;
    boolean[] tableBool;
    int[] table;
    int ms = 92;
    public HashTable(){
        size = 23;
        stepLength = 3;
        int[] table = new int[92];
        boolean[] tableBool = new boolean[92];
        for(int i = 0; i<tableBool.length; i++){
            tableBool[i] = false;
        }
    }
    public int hashFun(int value){
        int hash = value % size;
        /*while(tableBool[hash] != false && table[hash]!=value){
            hash = (hash+1) % size;
        }*/
        return hash;
    }
    public int seekSlot(int value){
        /*int ind = hashFun(value);
        if(tableBool[ind] == false){
            return -1;
        }else return table[ind];*/
        int hash = hashFun(value);
        while(tableBool[hash] != false && table[hash]!=value){
            hash = (hash+1) % size;
        }
        return hash;
    }
    public void put(int value){
        int ind = seekSlot(value);
        tableBool[ind] = true;
        table[ind] = value;
    }
    public int find(int value){
        int ind = hashFun(value);
        return -1;
    }
}
