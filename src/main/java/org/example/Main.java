package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new App(sc).run();

        sc.close();
    }
}
class App {
    private final Scanner sc;
    public App(Scanner sc) {
        this.sc=sc;
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String a = sc.nextLine().trim();

            if (a.equals("종료")) {
                break;
            }
        }
    }
}

