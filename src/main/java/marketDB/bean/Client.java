package marketDB.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString @NoArgsConstructor @AllArgsConstructor
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private int age;


}
