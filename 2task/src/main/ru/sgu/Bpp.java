package main.ru.sgu;


public class Bpp {

    private String dayOfWeek;
    private int num;
    
    public Bpp(String day, int num) {
        this.dayOfWeek = day;
        this.num = num;
    }


    private enum DaysOfWeek {
        
        monday ("monday"),
        tuesday("tuesday"),
        wednesday("wednesday"),
        thursday("thursday"),
        friday("friday"),
        saturday("saturday"),
        sunday("sunday");

        String dayOfWeek;

        DaysOfWeek(String d) {
            this.dayOfWeek = d;
        }

        public DaysOfWeek calculate(int num) {
            return DaysOfWeek.values()[(this.ordinal() + num) % 7]; 
        }
        
    }
    
    private boolean weekdayCheck() {
        for (DaysOfWeek el : DaysOfWeek.values()) {
            System.out.println(el.dayOfWeek);
            if (el.dayOfWeek.equals(this.dayOfWeek)) {
                return true;
            }
        }
        return false;
    }

    public void run() {
        if (weekdayCheck()) {
            DaysOfWeek dow = DaysOfWeek.valueOf(this.dayOfWeek) ;
            System.out.printf("\nЧерез %s дней(-я) будет следующий день недели:\n%s\n", num, dow.calculate(this.num));
        }
        else {
            System.out.println("\nНекорректный ввод данных!");
        }

    }
}
