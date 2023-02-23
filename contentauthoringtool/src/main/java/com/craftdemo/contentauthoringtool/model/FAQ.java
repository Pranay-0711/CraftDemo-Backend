package com.craftdemo.contentauthoringtool.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class FAQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID userId;
    private String question;

    public FAQ(int i, String question, String answer, UUID userId) {
        this.id = i;
        this.question = question;
        this.answer = answer;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    private String answer;
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public FAQ() {

    }
}
