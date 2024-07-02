package interview;

public class NoDeepCopy {

    static class Address implements Cloneable {
        String city;

        Address(String city) {
            this.city = city;
        }

//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();
//        }
    }

    static class Person implements Cloneable {
        int age;
        String name;
        Address address;

        Person(int age, String name, Address address) {
            this.age = age;
            this.name = name;
            this.address = address;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        try {
            Address address = new Address("New York");
            Person person1 = new Person(30, "John", address);
            Person person2 = (Person) person1.clone();

            System.out.println(person1.address.city); // 输出: New York
            System.out.println(person2.address.city); // 输出: New York

            person2.address.city = "Los Angeles";
            System.out.println(person1.address.city); // 输出: Los Angeles
            System.out.println(person2.address.city); // 输出: Los Angeles

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
