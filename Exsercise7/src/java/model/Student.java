package model;

import java.util.*;

public class Student {

    private String name;
    private Map<String, Double> marks;

    public Student() {
        this.marks = new HashMap<>();
    }

    public Student(String name, Map<String, Double> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        String str = "";
        int i = 0;
        for (String sub : marks.keySet()) {
            i++;
            str += sub + ":" + marks.get(sub) + (i == marks.size() ? "" : ", ");
        }
        return str;
    }

    public void setMarks(Map<String, Double> marks) {
        this.marks = marks;
    }

}
