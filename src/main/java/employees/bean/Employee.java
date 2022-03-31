package employees.bean;

import lombok.*;

@Data @NoArgsConstructor @Builder @AllArgsConstructor @ToString
public class Employee {

    private int id;
    private String name;
    private String lastname;
}
