package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class DictionaryApplication implements Initializable {

    @FXML
    private TextArea wordExplain;

    @FXML
    private TextField wordTarget;

    @FXML
    private ListView<String> wordsSuggestion;

    LinkedList<Word> dictionary= new LinkedList<>();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    LinkedList<Word> dictionarySearcher = new LinkedList<>();

    @FXML
    void onAdd(ActionEvent event) {
        String word_target = wordTarget.getText();
        String word_explain = wordExplain.getText();
        Word newWord = new Word(word_target, word_explain);
        dictionary.add(newWord);
        dictionaryManagement.dictionaryExportToFile(dictionary, "dictionaries");
    }

    @FXML
    void onDelete(ActionEvent event) {
        String word_target = wordTarget.getText();
        dictionaryManagement.deleteWords(dictionary, word_target);
        dictionaryManagement.dictionaryExportToFile(dictionary, "dictionaries");
    }

    //https://stackoverflow.com/questions/32700005/javafx-listview-add-and-edit-element
    @FXML
    void onSearch(ActionEvent event) {
        String word_target = wordTarget.getText();
        wordsSuggestion.getItems().clear();
        wordExplain.setText("");

        for(Word word : dictionary){
            if(word.getWord_target().equals(word_target)){
                wordExplain.setText(word.getWord_explain());
                break;
            }
        }

        dictionarySearcher = dictionaryManagement.dictionarySearcher(dictionary, word_target);

        for(Word word : dictionarySearcher){
            wordsSuggestion.getItems().add(word.getWord_target());
        }
    }

    @FXML
    void onUpdate(ActionEvent event) {
        String word_target = wordTarget.getText();
        String word_explain = wordExplain.getText();
        Word updateWord = new Word(word_target, word_explain);
        dictionaryManagement.updateWords(dictionary, updateWord);
        dictionaryManagement.dictionaryExportToFile(dictionary, "dictionaries");
    }

    @FXML
    void onClick() {
        String word_target = wordsSuggestion.getSelectionModel().getSelectedItem().toString();
        wordTarget.setText(word_target);

        for(Word word : dictionary){
            if(word.getWord_target().equals(word_target)){
                wordExplain.setText(word.getWord_explain());
                break;
            }
        }
    }

    @FXML
    void onSpeak(ActionEvent event) {
        Speak speak = new Speak();
        speak.speakWord(wordTarget.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dictionary = dictionaryManagement.insertFromFile();
    }
}

