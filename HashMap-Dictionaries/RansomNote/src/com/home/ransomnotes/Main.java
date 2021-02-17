package com.home.ransomnotes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String mn[] = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];
        String[] ransomNote = new String[n];

        magazine = scanner.nextLine().split(" ");
        ransomNote = scanner.nextLine().split(" ");

        checkMagazine(magazine, ransomNote);

        scanner.close();
    }

    private static void checkMagazine(String[] magazine, String[] ransomNote) {

        HashMap hashMap = new HashMap<String, Integer>();

        for (int i = 0; i < magazine.length; i++) {

            if (hashMap.containsKey(magazine[i])){
                hashMap.put(magazine[i], (Integer)hashMap.get(magazine[i])+1);
            }else {
                hashMap.put(magazine[i], 1);
            }
        }

        /*
        Iterator hashMapIterator = hashMap.entrySet().iterator();

        while (hashMapIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hashMapIterator.next();
            String key = (String) mapElement.getKey();
            Integer value = (Integer) mapElement.getValue();

            System.out.println("key : " + key + ", value: " + value);
        }
        */

        for (int i = 0; i < ransomNote.length; i++) {

            if (hashMap.containsKey(ransomNote[i])){

                if( (Integer) hashMap.get(ransomNote[i]) - 1 == 0){
                    hashMap.remove(ransomNote[i]);
                }else {
                    hashMap.put(ransomNote[i], (Integer) hashMap.get(ransomNote[i]) - 1);
                }
            }else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
