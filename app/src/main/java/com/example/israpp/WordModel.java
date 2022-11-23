package com.example.israpp;

public class WordModel {
    private int id;
    private String word;
    private String reading;
    private String meaning;
    private String category;
    private int showed;

    public WordModel(int id, String word, String reading, String meaning, String category, int showed) {
        this.id = id;
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.category = category;
        this.showed = showed;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getReading() {
        return reading;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getCategory() {
        return category;
    }

    public int getShowed() {
        return showed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setShowed(int showed) {
        this.showed = showed;
    }
}
