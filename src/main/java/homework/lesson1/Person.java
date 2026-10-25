package homework.lesson1;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //вообще у меня так уже было, мне менять ничего не пришлось по задаче 2 из дз для java урок 2
    public String introduce() {
        return "Привет, меня зовут " + firstName + " " + lastName + ". Мне " + age + " лет.";
    }
}

class Execution {

    public static void main(String[] args) {
        Person person = new Person("Nikolay", "Baskov", 25);
        System.out.println(person.introduce());
    }

}
