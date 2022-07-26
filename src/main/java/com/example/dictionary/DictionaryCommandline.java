package com.example.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline {
    static DictionaryManagement dictionaryManagement = new DictionaryManagement();
    static Dictionary dict;

    // in cac tu ra man hinh
    public static void showAllWords(List<Word> dictionary){
        System.out.print("No\t| English\t| Vietnamese");
        for(int i = 0; i < dictionary.size(); i++){
            System.out.print(i + " \t| " + dict.wordList.get(i).getWord_target() + "\t| " + dict.wordList.get(i).getWord_explain());
        }
    }

    /*public static void dictionaryBasic(){
        dictionaryManagement.insertFromCommandLine();
        showAllWords(dictionaryManagement.dictionary);
    }*/

    /*public static void dictionaryAdvanced(){
        dictionaryManagement.insertFromFile();
        showAllWords(dictionaryManagement.dictionary);
        dictionaryManagement.dictionaryLookup();
    }*/

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
}
