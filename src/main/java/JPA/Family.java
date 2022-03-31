package JPA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="family_id")
    private String id;

    @Column(length = 100)
    private String descrizione;

    @ManyToOne
    @JoinColumn(name ="family_id")

    private Family family;
}
