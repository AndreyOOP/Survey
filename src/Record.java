import java.io.Serializable;

public class Record implements Serializable{

    private int age;
    private String name;
    private Boolean java;
    private Boolean ruby;
    private Boolean cSharp;
    private Boolean cpp;
    private Boolean python;

    public Record(int age, String name, Boolean java, Boolean ruby, Boolean cSharp, Boolean cpp, Boolean python) {
        this.age = age;
        this.name = name;
        this.java = java;
        this.ruby = ruby;
        this.cSharp = cSharp;
        this.cpp = cpp;
        this.python = python;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Boolean getJava() {
        return java;
    }

    public Boolean getRuby() {
        return ruby;
    }

    public Boolean getcSharp() {
        return cSharp;
    }

    public Boolean getCpp() {
        return cpp;
    }

    public Boolean getPython() {
        return python;
    }
}
