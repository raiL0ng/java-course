package main.ru.sgu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public class MergeSort {

        public void mergeSort(ArrayList<RawData> arr) {
            if (arr.size() <= 1) {
                return;
            }
    
            int middle = arr.size() / 2;
            ArrayList<RawData> left = new ArrayList<>(arr.subList(0, middle));
            ArrayList<RawData> right = new ArrayList<>(arr.subList(middle, arr.size()));
    
            mergeSort(left);
            mergeSort(right);
    
            merge(left, right, arr);
        }
    
        private void merge(ArrayList<RawData> left, ArrayList<RawData> right, ArrayList<RawData> arr) {
            int i = 0;
            int j = 0;
            int k = 0;
    
            while (i < left.size() && j < right.size()) {
                if (left.get(i).isMore(right.get(j))) {
                    arr.set(k++, left.get(i++));
                } else {
                    arr.set(k++, right.get(j++));
                }
            }
    
            while (i < left.size()) {
                arr.set(k++, left.get(i++));
            }
    
            while (j < right.size()) {
                arr.set(k++, right.get(j++));
            }
        }
    
    }

    public class RawData {
        private String surname, name, patronymic, companyName;
        int rating;

        public RawData( String surname, String name, String patronymic
                      , String companyName, int rating ) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.companyName = companyName;
            this.rating = rating;
        }

        public RawData(String surname, String name, String companyName, int rating) {
            this.surname = surname;
            this.name = name;
            this.patronymic = "";
            this.companyName = companyName;
            this.rating = rating;
        }

        public RawData(String surname, String companyName, int rating) {
            this.surname = surname;
            this.name = "";
            this.patronymic = "";
            this.companyName = companyName;
            this.rating = rating;
        }

        public String getSurname() {
            return this.surname;
        }
        
        public boolean isMore(RawData o) {
            if (this.rating == o.rating) {
                if (this.surname.equals(o.surname)) {
                    if ((this.name == "" && o.name == "") || this.name != "" && o.name == "")
                        return false;
                    if (this.name == "" && o.name != "")
                        return true;
                    if (this.name.equals(o.name)) {
                        if ((this.patronymic == "" && o.patronymic == "") ||
                            (this.patronymic != "" && o.patronymic == ""))
                            return false;
                        if (this.patronymic == "" && o.patronymic != "")
                            return true;
                        return this.patronymic.compareTo(o.patronymic) < 0; 
                    } else
                        return this.name.compareTo(o.name) > 0;
                } else 
                    return this.surname.compareTo(o.surname) < 0;
            } else {
                return this.rating > o.rating;
            }
        }

        public String getInf() {
            if (this.patronymic == "")
                return this.surname + " " + this.name + " " +
                       this.companyName + " " + 
                       Integer.toString(this.rating);   
            if (this.name == "")
                return this.surname + " " + this.companyName + " " + 
                       Integer.toString(this.rating);
            return this.surname + " " + this.name + " " +
                   this.patronymic + " " + this.companyName + " " + 
                   Integer.toString(this.rating);
        }
    }

    public ArrayList<RawData> data;


    public void run() {
        
        if (!data.isEmpty()) {
            MergeSort ms = new MergeSort();
            ms.mergeSort(data);
            writeToFile(data);
        }
    }

     private RawData stringFormatting(String[] data) {
        int n = data.length;
        int r = Integer.valueOf(data[n - 1]);
        if (r < 1 || r > 10)
            return new RawData(null, null, -1);
        if (n == 5) {
            return new RawData( data[0], data[1], data[2]
                              , data[3], r);        
        }
        if (n == 4)
            return new RawData(data[0], data[1], data[2], r);
        if (n == 3)
            return new RawData(data[0], data[1], r);
        return null;
    }

    public void processFile(String fileName) {
		Scanner scanner = null;
		try {
            data = new ArrayList<>();
			scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            RawData el;
            while (scanner.hasNextLine()) {
                el = stringFormatting(scanner.nextLine().split(" "));
                if (el != null) {
                    data.add(el);
                }
            }
		} catch (IOException e) {
			System.out.println("Ошибка считывания с файла `" + fileName + "`");
			data.clear();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}
    // buffered writer
    private void writeToFile(ArrayList<RawData> ans) {
        try {
            FileWriter writer = new FileWriter("tests/output.txt");
            for (RawData el : ans) {
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
