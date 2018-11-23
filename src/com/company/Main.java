package com.company;

public class Main {

    public static void main(String[] args) {
        HashTable ht = new HashTable(23, 3, 92);
        for(int i = 0; i< 27; i++){
            ht.put(5 + i * 23);
        }
        ht.put(5 + 28 * 23);
        ht.put(5 + 29 * 23);
        System.out.println(ht.find(5));
        System.out.println(ht.find(28));
        System.out.println(ht.find(51));
    }
}
class HashTable{
    private int size;
    private int stepLength;
    private boolean[] tableBool;
    private int[] table;

     HashTable(int scnsize, int step, int s){
        size = scnsize;
        stepLength = step;
        this.table = new int[s];
        this.tableBool = new boolean[s];
    }
    int hashFun(int value){
        int hash = value % size;
        return hash;
    }
    int seekSlot(int value){
        int hash = hashFun(value);
        int h = hash;
        int q = 0;
        while(tableBool[hash] && table[hash]!=value){
            hash = h + stepLength * q;
            if(hash >= table.length){
                hash = -1;
                break;
            }
            q++;
        }
        return hash;
    }
    void put(int value){
        int ind = seekSlot(value);
        if(seekSlot(value) == -1){
            System.out.println("failed to add");
        }else{
            tableBool[ind] = true;
            table[ind] = value;
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
