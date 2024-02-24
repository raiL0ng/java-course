package main.ru.sgu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

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

        public boolean compare(RawData o) {
            return false;
        }
    }
    public ArrayList<String[]> data;

    public App(String filename) {
        data = readFromFile(filename);
    }

    public void run() {
        if (data != null) {
            ArrayList<String> ans = stringProcessing(data);
            writeToFile(ans);
        }
    }

     public ArrayList<String> stringProcessing(ArrayList<String[]> data) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < data.size(); i++) {
            row.setLength(0);
            cnt = 0;
            for (String el : data.get(i)) {
                if (el.length() < 3)
                    break;
                if (cnt >= 3) {
                    break;
                } else if (cnt == 0 || cnt == 2) {
                    row.append(el.charAt(0) + ". ");
                } else if (cnt == 1) {
                    row.insert(0, el + " ");
                }
                cnt++;
            }
            if (cnt < 3) {
                res.add("...не удалось обработать строку...");
            } else {
                res.add(row.toString());
            }
        }
        return res;
    }

    private ArrayList<String[]> readFromFile(String fileName) {
		Scanner scanner = null;
		try {
            ArrayList<String[]> data = new ArrayList<>();
			scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine().split(" "));
                for (String el : data.get(data.size() - 1))
                    System.out.print(el + " ");
                System.out.println("");
            }
			return data;
		} catch (IOException e) {
			System.out.println("Ошибка считывания с файла `" + fileName + "`");
			return null;
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

    public void writeToFile(ArrayList<String> ans) {
        try {
            FileWriter writer = new FileWriter("tests/output.txt");
            for (String el : ans) {
                writer.write(el + "\n");
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
