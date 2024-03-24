package main.ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class ITDepartment extends Department implements Comparable<CommonInformation>, CommonInformation {
    private ArrayList<Employee> employees;
    private String product;

    public ITDepartment(String name, String product) {
        super(name);
        employees = new ArrayList<>();
        this.product = product;
    }

    public String getNameOfDepartment() {
        return this.name;
    }


    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    public BigDecimal getTotalSalary() {
        BigDecimal totalSalary = new BigDecimal(0);
        for (Employee employee : employees) {
            totalSalary.add(new BigDecimal(employee.getSalary()));
        }
        return totalSalary;
    }


    public int getTotalEmployeeNumber() {
        return employees.size();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ITDepartment prod = (ITDepartment) obj;
        return Objects.equals(this.name, prod.name);
    }


    @Override
    public int compareTo(CommonInformation obj) {
        return Integer.compare(getTotalEmployeeNumber(), obj.getTotalEmployeeNumber());
    }



    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }


    @Override
    public String toString() {
        return "В отделе `" + this.name + "` разрабатывают" + 
               this.product + " и пьют чай с пончиками%n";
    }

}
