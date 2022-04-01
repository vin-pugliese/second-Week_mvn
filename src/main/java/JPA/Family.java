package JPA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="family_id")
    private String id;

    @Column(length = 100)
    private String descrizione;

    public Family(){}

    public Family(String id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @ManyToOne
    @JoinColumn(name ="family_id")
    private Family family;
}
