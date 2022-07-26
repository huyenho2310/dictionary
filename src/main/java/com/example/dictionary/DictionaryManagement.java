package com.example.dictionary;

import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class DictionaryManagement {
    // mang tu
    //public static List<Word> dictionary = new ArrayList<>();

    public static LinkedList<Word> dictionary = new LinkedList<>();

    // nhap tu man hinh
    public void insertFromCommandLine() {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String word_target = sc.nextLine();
            String word_explain = sc.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionary.add(word);
        }
    }

    // nhap tu file txt
    // link file txt : http://www.denisowski.org/Vietnamese/vnedict.txt
    public LinkedList<Word> insertFromFile() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("./src/main/dictionary/dictionaries.txt"));
            String line;
            String[] words;
            String[] wordsTarget;

            while (true) {
                line = buf.readLine();
                if (line == null) {
                    break;
                } else {
                    words = line.split(" : ");
                    String wordExplain = words[0];
                    if(words.length > 1){
                        wordsTarget = words[1].split(", ");
                        for(String i : wordsTarget) {
                            Word newWord = new Word(i, wordExplain);
                            dictionary.add(newWord);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dictionary;

    }

    // tim kiem bang dong lenh
    /*public void dictionaryLookup() {
        String wordtarget;
        Scanner sc = new Scanner(System.in);
        wordtarget = sc.nextLine();

        for (Word word : dictionary){
            if (word.getWord_target().equals(wordtarget)) {
                System.out.println(word.getWord_target());
            }
        }
    }*/

    public void dictionaryLookup(LinkedList<Word> dictionary, String word_target){
        for(Word word : dictionary){
            if(word_target.equals(word.getWord_target())){
                System.out.println(word.getWord_explain());
            }
        }
    }



    /*public List<Word> dictionarySearcher() {
        ArrayList<Word> words = new ArrayList<>();

        String w;
        Scanner sc = new Scanner(System.in);
        w = sc.nextLine();

        for (Word i : dictionaryManagement.dictionary) {
            if (i.getWord_target().startsWith(w)) {
                words.add(i);
            }
        }

        return words;
    }*/

    public LinkedList<Word> dictionarySearcher(LinkedList<Word> dictionary, String word) {
        LinkedList<Word> words = new LinkedList<>();

        for (Word i : dictionary) {
            if (i.getWord_target().startsWith(word)) {
                words.add(i);
            }
        }

        return words;
    }

    /*public static void dictionaryExportToFile() {
        try {
            File file = new File("./src/dictionary/dictionaries.txt");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Word i : dictionary) {
                bw.write(i.getWord_target() + "\t" + i.getWord_explain());
                bw.newLine();
            }

            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException var7) {
            System.out.println("An error occurred.");
            var7.printStackTrace();
        }
    }*/

    public static void dictionaryExportToFile(LinkedList<Word> dictionary, String file) {
        try {
            File fout = new File("./src/main/dictionary/" + file + ".txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Word i : dictionary) {
                bw.write(i.getWord_explain() + " : " + i.getWord_target());
                bw.newLine();
            }

            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException var7) {
            System.out.println("An error occurred.");
            var7.printStackTrace();
        }
    }

    /*public static void deleteWords() {
        String w;
        Scanner sc = new Scanner(System.in);
        w = sc.nextLine();

        dictionary.removeIf((n) -> n.getWord_target().equals(w));
    }*/

    public static void deleteWords(LinkedList<Word> dictionary, String word) {
        dictionary.removeIf((n) -> n.getWord_target().equals(word));
    }

    /*public  void updateWords() {
        String w;
        Scanner sc = new Scanner(System.in);
        w = sc.nextLine();

        for (Word value : dictionary)
            if (value.getWord_target().equals(word.getWord_target())) {
                value.setWord_target(word.getWord_target());
                value.setWord_explain(word.getWord_explain());
            }

    }*/

    public  void updateWords(LinkedList<Word> dictionary, Word word) {
        for (Word i : dictionary)
            if (i.getWord_target().equals(word.getWord_target())) {
                i.setWord_target(word.getWord_target());
                i.setWord_explain(word.getWord_explain());
            }

    }

}

