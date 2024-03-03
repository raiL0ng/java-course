package main.ru.sgu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Bpp {

    private File workingDir;
    private String target;

    public Bpp(String dirName, String target) {
        this.workingDir = new File(dirName);
        this.target = target;
    }


    public boolean dirValidalityCheck() {
        if (!workingDir.isDirectory()) {
            System.out.printf("Директории `%s` не существует или неверно указан к ней путь%n", workingDir);
            return false;
        }
        return true;
    }


    private boolean isCorrectName(File file) {
        return file.getName().toLowerCase().contains(target.toLowerCase());
    }


    private void runZip(ZipOutputStream zout, File curDir, String nextEntity) {
        System.out.printf("Архивирование директории '%s'%n", curDir.getName());
        for (File file : Objects.requireNonNull(curDir.listFiles())) {
            if (file.isDirectory()) {
                if (isCorrectName(file)) {
                    runZip(zout, file, "%s%s/".formatted(nextEntity, file.getName()));
                }
            } else {
                if (isCorrectName(file)) {
                    System.out.printf("- Архивирование файла '%s'%n", file.getName());
                    try (FileInputStream fis = new FileInputStream(file)) {
                        zout.putNextEntry(new ZipEntry(nextEntity + file.getName()));
                        byte[] buffer = new byte[1024];
                        int size;
                        while ((size = fis.read(buffer)) > 0) {
                            zout.write(buffer, 0, size);
                        }
                        zout.closeEntry();
                    } catch (IOException e) {
                        System.out.printf("Не удалось добавить сущность %s в архив%n", file.getName());
                    }
                }
            }
        }
    }

    public boolean run() {
        try (FileOutputStream fout = new FileOutputStream("%s.7z".formatted(this.workingDir.getName()));
             ZipOutputStream zout = new ZipOutputStream(fout)) {
            runZip(zout, workingDir, "");
        } catch (IOException e) {
            System.out.printf("Не удалось создать архив %s.7z%n", workingDir.getName());
            return false;
        }
        return true;
    }
}
