package com.company;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);

    public static String encrypt(String text, int key) {
        char c;
        int v,subKey=key;
        String s="";
        StringBuilder stb = new StringBuilder(text);
        for (int i = 0; i < stb.length(); i++) {
            key=subKey;
            if (stb.charAt(i) <= 'Z') {
                c = stb.charAt(i);
                while (c + key > 'Z') {
                    v ='Z' - c;
                    key -= v;
                    key-=1;
                    c = 'A';
                }
                c += key;
                s+=c;
            } else {
                c = stb.charAt(i);
                while (c + key > 'z') {
                    v ='z' - c;
                    key -= v;
                    key-=1;
                    c = 'a';
                }
                c += key;
                s+=c;
            }
        }
        return s;
    }
    public static String decrypt(String text,int key)
    {
        char c;
        int v,subKey=key;
        String s="";
        StringBuilder stb = new StringBuilder(text);
        for (int i = 0; i < stb.length(); i++) {
            key=subKey;
            if (stb.charAt(i) <= 'Z') {
                c = stb.charAt(i);
                while (c - key < 'A') {
                    v =c-'A';
                    key -= v;
                    key-=1;
                    c = 'Z';
                }
                c -= key;
                s+=c;
            } else {
                c = stb.charAt(i);
                while (c - key < 'a') {
                    v =c-'a';
                    key -= v;
                    key-=1;
                    c = 'z';
                }
                c -= key;
                s+=c;
            }
        }
        return s;
    }


    public static void main(String[] args) {
        String s1="abcdefghijklmnopqrstuvwxyz",s2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        s1=encrypt(s1,8);
        s2=encrypt(s2,5);
        System.out.println(s1);
        System.out.println(s2);
        s1=decrypt(s1,8);
        s2=decrypt(s2,5);
        System.out.println(s1);
        System.out.println(s2);
    }
}
