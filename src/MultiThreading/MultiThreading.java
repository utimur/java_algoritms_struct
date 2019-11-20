package MultiThreading;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException, IOException {
        File firstFile = new File("firstFile.txt");
        File secondFile = new File("secondFile.txt");

        if(!firstFile.exists()) firstFile.createNewFile();
        if(!secondFile.exists()) secondFile.createNewFile();

        FirstFileThread firstFileThread = new FirstFileThread(firstFile);
        SecondFileThread secondFileThread = new SecondFileThread(firstFile, secondFile);

        firstFileThread.start();
        secondFileThread.start();
    }
}

class FirstFileThread extends Thread {

    private FileWriter fileWriter;

    public FirstFileThread(File file) throws IOException {
        fileWriter = new FileWriter(file,true);
    }

    public synchronized void write() throws IOException, InterruptedException {
        for (int i = 1; i < 10; i++) {
            fileWriter.write(i + "\n");
            fileWriter.flush();
            if (i % 2 == 0) {

            }
        }
    }

    @Override
    public void run() {
        try {
            write();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondFileThread extends Thread {
    private Scanner scanner;
    private FileWriter fileWriter;

    public SecondFileThread(File read, File write) throws IOException {
        scanner = new Scanner(read);
        fileWriter = new FileWriter(write,true);
    }

    public synchronized void writeSum() throws IOException, InterruptedException {
        wait();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        fileWriter.write((a+b) + "\n");
        fileWriter.flush();
    }

    @Override
    public void run() {
        try {
            writeSum();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}