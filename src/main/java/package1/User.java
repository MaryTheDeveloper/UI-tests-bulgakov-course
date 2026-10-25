package package1;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 28 && 65 >= age) {
            this.age = age;
        } else {
            System.out.println("Возраст не подходит для нашего сервиса");
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 2 && firstName.length() < 50) {
            this.firstName = firstName;
        } else {
            System.out.println("Ваше имя невалидно");
        }
    }
}
