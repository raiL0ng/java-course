// package main.ru.sgu;

// interface Worker {
//     // String getFirstName();
//     // String getLastName();
//     String getPosition();
//     double getSalary();
// }

// abstract class AbstractEmployee implements Worker {
//     abstract String getNameOfPosition();
// }

// class Worker_ extends AbstractEmployee {
//     private double workHours;

//     public Worker_(String firstName, String lastName, double workHours) {
//         super(firstName, lastName);
//         this.workHours = workHours;
//     }

//     @Override
//     public String getNameOfPosition() {
//         return "Worker";
//     }

//     @Override
//     public double getSalary() {
//         return workHours * 10; // Предположим, оплата 10 долларов в час
//     }

//     @Override
//     public String toString() {
//         return "Worker{" +
//                 "firstName='" + getFirstName() + '\'' +
//                 ", lastName='" + getLastName() + '\'' +
//                 ", position='" + getNameOfPosition() + '\'' +
//                 ", workHours=" + workHours +
//                 ", salary=" + getSalary() +
//                 '}';
//     }
// }

// class Manager extends AbstractEmployee {
//     private int projects;

//     public Manager(String firstName, String lastName, int projects) {
//         super(firstName, lastName);
//         this.projects = projects;
//     }

//     @Override
//     public String getNameOfPosition() {
//         return "Manager";
//     }

//     @Override
//     public double getSalary() {
//         return projects * 1000; // Предположим
//     }
// }