package lombok;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class LombokStudent {

    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private int age;
    private boolean enabled;

}
