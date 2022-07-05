package com.accenture.javajoggers.pets;
// POJO: Plain Old Java Object
class HUman {

    // Immutable - can't be changed
    private String name;
    private int age;
    private String jobTitle;

    public HUman(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
