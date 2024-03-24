package main.ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class ProductionHall extends Department implements Comparable<CommonInformation>, CommonInformation {
    private ArrayList<Employee> employees;
    private String product;


    public ProductionHall(String name, String product) {
        super(name);
        employees = new ArrayList<>();
        this.product = product;
    }

    @Override
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
            totalSalary = totalSalary.add(new BigDecimal(employee.getSalary()));
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
        ProductionHall prod = (ProductionHall) obj;
        return Objects.equals(this.name, prod.name);
    }


    @Override
    public int compareTo(CommonInformation obj) {
        return this.getNameOfDepartment().compareTo(obj.getNameOfDepartment());
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }


    @Override
    public String toString() {
        return "В отделе `" + this. name + "` производят " + this.product + "\n";
    }

}
