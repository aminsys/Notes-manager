package com.example.spring_boot_notes.data;


public class Note {
    private String name;
    private String text;
    private String date;
    private Long id;

    public Note() {
    }

    public Note(Long id, String name, String text, String date){
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.text = text;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getText() {
        return this.text;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public void setText (String text) {
        this.text = text;
    }


}