package main.ru.sgu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;


public class App {

    public class DataFormatting {

        private String surname, name, patronymic, companyName, stringInf;
        int rating;


        public DataFormatting( String surname, String name, String patronymic
                      , String companyName, int rating ) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.companyName = companyName;
            this.rating = rating;
            this.stringInf = this.surname + " " + this.name + " " +
                             this.patronymic + " " + this.companyName + " " + 
                             Integer.toString(this.rating);
        }


        public DataFormatting(String surname, String name, String companyName, int rating) {
            this.surname = surname;
            this.name = name;
            this.patronymic = "";
            this.companyName = companyName;
            this.rating = rating;
            this.stringInf = this.surname + " " + this.name + " " +
                             this.companyName + " " + 
                             Integer.toString(this.rating);
        }


        public DataFormatting(String surname, String companyName, int rating) {
            this.surname = surname;
            this.name = "";
            this.patronymic = "";
            this.companyName = companyName;
            this.rating = rating;
            this.stringInf = this.surname + " " + this.companyName + " " + 
                             Integer.toString(this.rating);
        }


        public int getRating() {
            return this.rating;
        }


        public String getSurname() {
            return this.surname;
        }


        public String getName() {
            return this.name;
        }


        public String getPatronymic() {
            return this.patronymic;
        }


        public String getInf() {
            return this.stringInf;
        }

        
        @Override
        public int hashCode() {
            return Objects.hash(surname, name, patronymic, companyName, rating);
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            DataFormatting other = (DataFormatting) obj;
            return Objects.equals(surname, other.surname) &&
                   Objects.equals(name, other.name) &&
                   Objects.equals(patronymic, other.patronymic) &&
                   Objects.equals(companyName, other.companyName) &&
                   rating == other.rating;
        }
    }


    public ArrayList<DataFormatting> data = new ArrayList<>();


    public boolean dataCheck() {
        if (data.isEmpty()) {
            return false;            
        }
        return true;
    }

    public void run() {
        Comparator<DataFormatting> comparator = Comparator
                                   .comparing( DataFormatting::getRating
                                             , Comparator.reverseOrder() )
                                   .thenComparing(DataFormatting::getSurname)
                                   .thenComparing( DataFormatting::getName
                                                 , Comparator.reverseOrder() )
                                   .thenComparing(DataFormatting::getPatronymic);
        if (!data.isEmpty()) {
            data.sort(comparator);
            writeToFile(data);
        }
    }


     private DataFormatting stringFormatting(String[] data) {
        int n = data.length;
        int r = Integer.valueOf(data[n - 1]);
        if (r < 1 || r > 10)
            return null;
        if (n == 5) {
            return new DataFormatting( data[0], data[1], data[2]
                                     , data[3], r);        
        }
        if (n == 4)
            return new DataFormatting(data[0], data[1], data[2], r);
        if (n == 3)
            return new DataFormatting(data[0], data[1], r);
        return null;
    }


    public void processFile(String fileName) {
		HashSet<DataFormatting> dataSet = new HashSet<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name())){
            dataSet = new HashSet<>();
            DataFormatting el;
            while (scanner.hasNextLine()) {
                el = stringFormatting(scanner.nextLine().split(" "));
                if (el != null) {
                    dataSet.add(el);
                }
            }
		} catch (IOException e) {
			System.out.println("Ошибка считывания с файла `" + fileName + "`" + e.getMessage());
		}
        data.addAll(dataSet);
	}


    public void writeToFile(ArrayList<DataFormatting> ans) {
        try {
            FileWriter writer = new FileWriter("tests/output.txt");
            for (DataFormatting el : ans) {
                writer.write(el.getInf() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл!");
            e.printStackTrace();
        } finally {
            System.out.println("Результат был успешно записан в файл tests/output.txt");
        }
    }

}
