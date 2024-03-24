package main.ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    
    public ITDepartment getITDepartment(String name, String prod) {
        ITDepartment itd = new ITDepartment(name, prod);
        itd.addEmployee(new Employee("Григорий", "Карпов", "Схемотехник", 80000));
        itd.addEmployee(new Employee("Василий", "Чудиков", "Главный тестировщик", 120000));
        itd.addEmployee(new Employee("Николай", "Поршнев", "Разработчик", 200000));
        itd.addEmployee(new Employee("Андрей", "Кульков", "Схемотехник", 90000));
        itd.addEmployee(new Employee("Анна", "Ванна", "Разработчик", 130000));
        itd.addEmployee(new Employee("Валерий", "Мальчиков", "Начальник отдела", 210000));

        return itd;
    }


    public ProductionHall getProductionHall(String name, String prod) {
        ProductionHall ph = new ProductionHall(name, prod);
        ph.addEmployee(new Employee("Анатолий", "Коликов", "Сварщик 1-го разряда", 112000));
        ph.addEmployee(new Employee("Геннадий", "Крокодилов", "Сварщик 2-го разряда", 100000));
        ph.addEmployee(new Employee("Владимир", "Путкин", "Слесарь", 80000));
        ph.addEmployee(new Employee("Андрей", "Мальков", "Слесарь", 90000));
        ph.addEmployee(new Employee("Жора", "Табачков", "Сварщик 3-го разряда", 85000));
        ph.addEmployee(new Employee("Дмитрий", "Иванов", "Фрезеровщик", 130000));
        ph.addEmployee(new Employee("Александр", "Ржевский", "Начальник отдела", 210000));
        return ph;
    }


    public TechnicalSupport getTechnicalSupport(String name) {
        TechnicalSupport ts = new TechnicalSupport(name);
        ts.addEmployee(new Employee("Алексей", "Говорунов", "Сотрудник тех. поддержки", 110000));
        ts.addEmployee(new Employee("Евгений", "Задолбалов", "Сотрудник тех. поддержки", 110000));
        ts.addEmployee(new Employee("Алина", "Дописделкина", "Сотрудник тех. поддержки", 110000));
        ts.addEmployee(new Employee("Егор", "Начальников", "Начальник отдела", 190000));
        return ts;
    }

    public void run() {
        Main m = new Main();
        // ITDepartment itd1 = m.getITDepartment("IT-отдел №1", "приложение по автоматизации создания скрепок");
        // ITDepartment itd2 = m.getITDepartment("IT-отдел №2", "новые коробки для скрепок");
        // TechnicalSupport ts1 = m.getTechnicalSupport("Тех. поддержка");
        // TechnicalSupport ts2 = m.getTechnicalSupport("Тех. поддержка");
        // ProductionHall ph = m.getProductionHall("Производственный цех", "высококачественный скрепки");
        // ArrayList<CommonInformation> deps = new ArrayList<>();
        // deps.add(itd1);
        // deps.add(itd2);
        // deps.add(ph);
        // deps.add(ts1);
        // deps.add(ts2);
        Company c = new Company("ИП Скрепочкина");
        c.addDepartment(m.getITDepartment("IT-отдел №1", "приложение по автоматизации создания скрепок"));
        c.addDepartment(m.getITDepartment("IT-отдел №2", "новые коробки для скрепок"));
        c.addDepartment(m.getProductionHall("Производственный цех", "высококачественный скрепки"));
        c.addDepartment(m.getTechnicalSupport("Тех. поддержка"));
        System.out.println(c.toString());
    
        ArrayList<CommonInformation> deps = c.getDepartments();
        System.out.println("\nСравнение двух IT-отделов: " + deps.get(0).equals(deps.get(1)));

        System.out.println("\nХеш-коды отделов:" );
        for (CommonInformation el : deps) {
            System.out.println(el.getNameOfDepartment() + ": " + el.hashCode());
        }

        System.out.println("\nСравнение отделов осуществляется по количеству сотрудников");
        System.out.println("Количество сотрудников:" );
        for (CommonInformation el : deps) {
            System.out.println(el.getNameOfDepartment() + ": " + el.getTotalEmployeeNumber());
        }

        System.out.println("\nСравнение IT-отделов: " + deps.get(0).compareTo(deps.get(1)));
        System.out.println("Сравнение отдела технической поддрежки и IT-отдела №1: " + 
                           deps.get(3).compareTo(deps.get(1)));
        
        System.out.println("\nНазначение отделов:" );
        for (CommonInformation el : deps) {
            System.out.println(el.toString());
        }


        System.out.println("\nВыплата зарплаты сотрудникам каждого отдела:" );
        BigDecimal sum = new BigDecimal(0);
        for (CommonInformation el : deps) {
            sum = sum.add(el.getTotalSalary());
            System.out.println(el.getNameOfDepartment() + ": " + el.getTotalSalary());
        }
        System.out.println("Суммарная выплата: " + sum);
        
        
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
        // Company c = new Company("ИП Скрепочкина");
        // c.addDepartment(m.getITDepartment("IT-отдел", "приложение по автоматизации создания скрепок"));
        // c.addDepartment(m.getProductionHall("Производственный цех", "высококачественный скрепки"));
        // c.addDepartment(m.getTechnicalSupport("Тех. поддержка"));
        // System.out.println(c.toString());
    }
}
