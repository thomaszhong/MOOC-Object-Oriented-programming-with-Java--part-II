public class Person implements Comparable<Person> {

    private int salary;
    private String name;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return name + " " + salary;
    }

    @Override
    public int compareTo(Person person) {
        if (person.getSalary() == this.salary) {
            return 0;
        } else if (person.getSalary() > this.salary) {
            return 1;
        } else {
            return -1;
        }
    }
}
