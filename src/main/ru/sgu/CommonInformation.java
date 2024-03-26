package main.ru.sgu;

import java.math.BigDecimal;

interface CommonInformation extends Comparable<CommonInformation> {

    public String getNameOfDepartment();

    BigDecimal getTotalSalary(); 

    int getTotalEmployeeNumber();

    public int compareTo(CommonInformation obj);

}
