/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable_datastructure;

import java.util.ArrayList;

import single_linkedlist.SingleLinkedListNew;

/**
 *
 * @author yasin93
 */
public class HashTable<K, V> {

    private static class Entry<K, V> {

        private K key;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        
    }

    private SingleLinkedListNew<Entry<K, V>>[] table;

    public HashTable(int size) {
        table = new SingleLinkedListNew[size];
    }

    public ArrayList<K> indexValues;

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;

        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedListNew<Entry<K, V>>();
            table[index].add(new Entry<K, V>(key, value));
            return null;
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }

            }
            table[index].add(0, new Entry<K, V>(key, value));
            return null;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }

        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = key.hashCode() % table.length;
        V oldValue;
        if (table[index] == null) {
            return null;
        }
        int j=0;
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                oldValue = e.value;
                if(table[index].get(j).getKey().equals(key)){
                table[index].remove(j);
                return oldValue;
                }
            }
            j++;
        }
        return null;
    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < table.length; i++) {
            str += "[" + i + "]";
            if (table[i] != null) {

                for (Entry<K, V> e : table[i]) {

                    str += " " + e.value.toString() + " key:"
                            + e.key.toString() + " ==> ";

                }
               
            }
            str += "null\n";

        }

        return str;
    }

    public static void main(String[] args) {
        HashTable<String, String> hash = new HashTable<String, String>(10);

        hash.put("5005", "adam");
        hash.put("3003", "fredrik");
        hash.put("8080", "pelle");
        hash.put("1001", "sara");
        hash.put("1002", "melissa");
        hash.put("1003", "hans");
        hash.put("1004", "maria");
        hash.put("1005", "klas");
        hash.put("1006", "martin");
        hash.put("1007", "sofia");
        System.out.println(hash.get("5005") + "\n" + hash.get("3003"));
        System.out.println(hash.toString());

        System.out.println(hash.remove("8080"));
        //System.out.println(hash.get("5005"));
        System.out.println(hash.toString());

    }
}
