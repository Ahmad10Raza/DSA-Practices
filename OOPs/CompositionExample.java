// Address class
class Address {
    private String street;
    private String city;
    private String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + zipCode;
    }
}

// Job class
class Job {
    private String title;
    private double salary;

    public Job(String title, double salary) {
        this.title = title;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return title + " - Salary: $" + salary;
    }
}

// Person class composed of Address and Job
class Person {
    private String name;
    private int age;
    private Address address;
    private Job job;

    public Person(String name, int age, Address address, Job job) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nAddress: " + address + "\nJob: " + job;
    }
}

// Usage of Composition to create a complex object
public class CompositionExample {
    public static void main(String[] args) {
        Address personAddress = new Address("123 Main St", "Cityville", "12345");
        Job personJob = new Job("Software Engineer", 90000.0);

        // Creating a Person using composition
        Person person = new Person("John Doe", 30, personAddress, personJob);

        // Displaying information about the person
        System.out.println(person);
    }
}

