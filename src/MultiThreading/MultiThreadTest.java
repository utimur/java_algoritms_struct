package MultiThreading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class MultiThreadTest {
    public static void main(String[] args) throws IOException {

        Thread1 thread1 = new Thread1(Lock.lock);
        Thread2 thread2 = new Thread2(Lock.lock);



        thread1.start();
        thread2.start();
    }
}

 class Lock {
    static final Object lock = new Object();
}

class Thread1 extends Thread {

    private FileWriter fileWriter;
    private Object lock;

    public Thread1(Object lock) throws IOException {
        fileWriter = new FileWriter(new File("firstFile.txt"),true);
        this.lock = lock;
    }

    public void write() throws IOException, InterruptedException {
        System.out.println(Lock.lock.hashCode() + " hashcode tred1");
        Random random = new Random();
        fileWriter.write(random.nextInt(100) + "\n"
                + random.nextInt(100) + "\n");
        fileWriter.flush();
    }

    @Override
    public synchronized void run() {
        try {
            synchronized (lock) {
                while (true) {
                    write();
                    System.out.println("Запись прошла");
                    lock.notify();
                    lock.wait();
                    System.out.println("вызван нотифай");
                    Thread.sleep(3000);
                    System.out.println("Тред проснулся");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Thread2 extends Thread {

    private Scanner scanner;
    private FileWriter fileWriter;
    private Object lock;

    public Thread2(Object lock) throws IOException {
        fileWriter = new FileWriter(new File("secondFile.txt"),true);
        scanner = new Scanner(new File("firstFile.txt"));
        this.lock = lock;
    }

    public void readAndWrite() throws IOException {
        if (scanner.hasNextLine()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            fileWriter.write((a+b) + " ");
            fileWriter.flush();
        }
    }


    @Override
    public void run() {
        System.out.println("Начало тред2");
        synchronized (lock) {
            while (true) {
                System.out.println("Начало цикла тред2");
                try {
                    System.out.println(Lock.lock.hashCode() + " hashcode lock tread2");
                    System.out.println("Thread 2 проснулся");
                    readAndWrite();
                    lock.notify();
                    lock.wait();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}