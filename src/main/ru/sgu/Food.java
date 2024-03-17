package main.ru.sgu;

public class Food {
    public String name;
    public int calories;

    public Food(String n, int c) {
        this.name = n;
        this.calories = c;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }
}

