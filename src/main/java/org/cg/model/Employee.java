package org.cg.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumbers;
    private LocalDate doj;
    private double salary;
}
