package ratsastuspaivakirja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Diary diary = new Diary(reader);
        diary.start();
    }
}
