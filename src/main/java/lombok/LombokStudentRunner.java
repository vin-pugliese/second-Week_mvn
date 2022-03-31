package lombok;

public class LombokStudentRunner {

    public static void main(String[] args) {

        LombokStudent l2 = new LombokStudent();

        LombokStudent l3 = LombokStudent.builder()
                .name("gg").build();

        LombokStudent l = new LombokStudent();
        l.setAge(2);

        System.out.println(l.getAge());

    }
}
