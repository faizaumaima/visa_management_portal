package com.example.finalms3.models;

import java.time.LocalDateTime;

public class Evaluation {
    private String id;
    private String title;
    private String description;
    private String evaluator;
    private String evaluatedPerson;
    private LocalDateTime evaluationDate;
    private int score; // 1-10 scale
    private String category;
    private String status;
    private String comments;
    private String recommendations;

    public Evaluation(String id, String title, String description, String evaluator, String evaluatedPerson) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.evaluator = evaluator;
        this.evaluatedPerson = evaluatedPerson;
        this.evaluationDate = LocalDateTime.now();
        this.status = "PENDING";
        this.score = 0;
    }

    public Evaluation(String id, String title, String description, String evaluator, String evaluatedPerson,
                     int score, String category, String comments, String recommendations) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.evaluator = evaluator;
        this.evaluatedPerson = evaluatedPerson;
        this.score = score;
        this.category = category;
        this.comments = comments;
        this.recommendations = recommendations;
        this.evaluationDate = LocalDateTime.now();
        this.status = "COMPLETED";
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEvaluator() { return evaluator; }
    public void setEvaluator(String evaluator) { this.evaluator = evaluator; }

    public String getEvaluatedPerson() { return evaluatedPerson; }
    public void setEvaluatedPerson(String evaluatedPerson) { this.evaluatedPerson = evaluatedPerson; }

    public LocalDateTime getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(LocalDateTime evaluationDate) { this.evaluationDate = evaluationDate; }

    public int getScore() { return score; }
    public void setScore(int score) { 
        if (score >= 1 && score <= 10) {
            this.score = score;
        }
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public String getRecommendations() { return recommendations; }
    public void setRecommendations(String recommendations) { this.recommendations = recommendations; }

    public String getScoreDescription() {
        if (score >= 9) return "Excellent";
        else if (score >= 7) return "Good";
        else if (score >= 5) return "Average";
        else if (score >= 3) return "Below Average";
        else return "Poor";
    }
}
