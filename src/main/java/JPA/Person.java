package JPA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private String id;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastname;

    @OneToMany(
            mappedBy ="family",
            cascade = {CascadeType.ALL}
    )

    private List<Person> persons = new ArrayList<Person>();
}
