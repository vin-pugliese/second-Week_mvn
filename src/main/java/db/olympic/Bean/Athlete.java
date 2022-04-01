package db.olympic.Bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Athlete {

    private int id;
    private String name;
    private String nation;
    private Date birthday;
    private double height;


}
