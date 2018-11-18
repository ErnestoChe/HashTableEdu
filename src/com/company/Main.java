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
    boolean[] arrBool;
    int[] arr;
    public HashTable(){
        size = 23;
        stepLength = 3;
        int[] arr = new int[92];
        boolean[] arrBool = new boolean[92];
        for(int i = 0; i<arrBool.length; i++){
            arrBool[i] = false;
        }
    }
    public int hashFun(int value){
        int index = value % size;
        while(index<92){
            if(arrBool[index] == true){
                index = index + size;
            }
        }
        return index;
    }
    public int seekSlot(int value){
        int index = value % size;
        while(index<92){
            if(arrBool[index] == true)
            index = index + size;
        }
        return index;
    }
    public void put(int value){
        int index = seekSlot(value);
        arr[index] = value;
        arrBool[index] = true;
    }
    public int find(int value){
        int index = seekSlot(value);
        if(index > 92){
            return -1;
        }else{
            return arr[index];
        }
    }
}
