package by.clevertec.model;

import java.util.Optional;

import by.clevertec.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String surname;
    private int age;
    private String faculty;
    private String group;
    private Optional<Examination> examination = Optional.empty();

}

