package org.patterns.creational;


// This pattern is used to create complex objects step by step
// Mainly used when -
//      Object has many fields
//      Constructor has too many parameters
//      Some parameters are optional

class User{
    private String name;
    private int age;
    private String address;
    private String email;
    private int salary;

    private User(BuilderClass builder){
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.email = builder.email;
        this.salary = builder.salary;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static class BuilderClass {
        private String name;
        private int age;
        private String address;
        private String email;
        private int salary;

        // static builder class
        public BuilderClass setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderClass setAge(int age) {
            this.age = age;
            return this;
        }

        public BuilderClass setAddress(String address) {
            this.address = address;
            return this;
        }

        public BuilderClass setEmail(String email) {
            this.email = email;
            return this;
        }

        public BuilderClass setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
public class Builder {
    public static void main(String[] args) {
        User u = new User.BuilderClass()
                .setAge(25).setName("AXZ")
                .setAddress("NY").setSalary(75000)
                .build();

        System.out.println(u);
    }
}