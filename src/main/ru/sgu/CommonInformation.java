package main.ru.sgu;

import java.math.BigDecimal;

interface CommonInformation {

    public String getNameOfDepartment();

    BigDecimal getTotalSalary(); 

    int getTotalEmployeeNumber();

    public int compareTo(CommonInformation obj);

}
