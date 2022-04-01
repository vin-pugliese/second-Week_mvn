package marketDB.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString @NoArgsConstructor @AllArgsConstructor
public class Order {

    private int idOrder;
    private String nOrder;
    private int id_client;

}
