package com.sg.classroster.entities;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

public class Teacher {

    private int id;
    @NotBlank(message = "First name must not be empty.")
    @Size(max = 30, message = "First name must be less than 30 characters.")
    private String firstName;

    @NotBlank(message = "Last name must not be empty.")
    @Size(max = 50, message = "Last name must be less than 50 characters.")
    private String lastName;

    @Size(max = 50, message = "Specialty must be less than 50 characters")
    private String specialty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && firstName.equals(teacher.firstName) && lastName.equals(teacher.lastName) && specialty.equals(teacher.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, specialty);
    }

}
