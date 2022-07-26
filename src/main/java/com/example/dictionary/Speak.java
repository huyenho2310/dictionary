package com.example.dictionary;

import com.sun.speech.freetts.VoiceManager;

// https://softwarepulse.co.uk/blog/javafx-and-adding-basic-speech/
// https://www.youtube.com/watch?v=4OdMztrDyOs
class Speak {
    private final com.sun.speech.freetts.Voice voice;

    public Speak(){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        this.voice = VoiceManager.getInstance().getVoice("kevin16");
        this.voice.allocate();
    }

    public void speakWord(String word){
        voice.speak(word);
    }
}
