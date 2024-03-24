package main.ru.sgu;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<CommonInformation> deps = new ArrayList<>();
    private int empNum;

    public Company(String name) {
        this.name = name;
        this.empNum = 0;
    }

    public void addDepartment(CommonInformation department) {
        deps.add(department);
        empNum++;
    }

    public void removeDepartment(CommonInformation department) {
        deps.remove(department);
        empNum--;
    }

    public ArrayList<CommonInformation> getDepartments() {
        return deps;
    }

    @Override
    public String toString() {
        StringBuilder deps = new StringBuilder();
        for (CommonInformation dep : this.deps) {
            deps.append(dep.getNameOfDepartment() + ";\n");
        }
        return "Компания `" + this.name + "` имеет " + this.empNum + " отделов:\n" + deps;
    }
}

