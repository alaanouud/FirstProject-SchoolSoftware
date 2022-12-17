package com.example.school.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
public class Teacher {
    @NotNull( message = "ID shouldn't Be Empty")
    private Integer ID;
    @NotNull( message ="Name Shouldn't Be Empty")
    private String name;
    @NotNull( message ="Salary Shouldn't Be Empty")
    private double salary;
}
