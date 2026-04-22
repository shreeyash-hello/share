package com.day11.hash;

public class HashMain {

    public static void main(String[] args) {

        HashTable ht = new HashTable(5);

        ht.insert(10);
        ht.insert(20);
        ht.insert(15);
        ht.insert(7);
        ht.insert(12);

        System.out.println("Hash Table:");
        ht.print();

        System.out.println("\nSearch Results:");
        System.out.println("15 found? " + ht.search(15));
        System.out.println("99 found? " + ht.search(99));
    }
}