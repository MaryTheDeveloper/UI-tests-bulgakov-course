package package1;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(20);
        user1.setFirstName("Marta");
        user1.setLastName("Jones");

        System.out.println(user1.getFirstName());
    }
}
