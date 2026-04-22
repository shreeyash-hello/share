package com.day11.hash;

import com.day3.LL.SinglyLL;

public class HashTable {

    private SinglyLL[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new SinglyLL[size];

        for (int i = 0; i < size; i++) {
            table[i] = new SinglyLL();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].addAtEnd(key);
    }

    public boolean search(int key) {
        int index = hash(key);
        SinglyLL bucket = table[index];
        SinglyLL temp = new SinglyLL();
        boolean found = false;

        while (!bucket.isEmpty()) {
            int val = bucket.deleteFirstNode();

            if (val == key) {
                found = true;
            }

            temp.addAtEnd(val);
        }
        while (!temp.isEmpty()) {
            bucket.addAtEnd(temp.deleteFirstNode());
        }
        return found;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            table[i].print();
            System.out.println();
        }
    }
}