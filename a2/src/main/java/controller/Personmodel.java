package controller;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Personmodel {

    @NotNull
    @Schema(required = true,example = "varun")
    private String firstname;

    @NotNull
    @Schema(required = true,example = "Gorle")
    private String lastname;
    @NotNull
    @Schema(required = true,example = "21")
    private int age;

    @Schema(required = true,example = "6")
    private int height;

    public Personmodel() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Personmodel(String firstname, String lastname, int age,int height) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.height=height;
    }



}
