package main.ru.sgu;

import java.util.ArrayList;


abstract public class Department {
    protected String name;
    protected ArrayList<Employee> employees;


    public Department(String name) {
        this.name = name;
    }

    public abstract void addEmployee(Employee employee);


    public abstract void removeEmployee(Employee employee);


    public abstract ArrayList<Employee> getEmployees();


}
