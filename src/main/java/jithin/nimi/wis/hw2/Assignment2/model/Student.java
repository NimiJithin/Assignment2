package jithin.nimi.wis.hw2.Assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private String id;
    private String name;
    private String subject;

    public Student() {
    }

    public Student(String name, String subject) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.subject = subject;
    }


    public String getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{id= " + id + ",name = " + name + ",subject = " + subject + "}";
    }
}
