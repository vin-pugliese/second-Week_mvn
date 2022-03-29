package db.first_DB.beans;

public class Studente {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private int enabled;
    private int age;


    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    public int getEnabled() {
        return enabled;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    /**-----------------------toString
     *
     */
    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", age=" + age +
                '}';
    }
}
