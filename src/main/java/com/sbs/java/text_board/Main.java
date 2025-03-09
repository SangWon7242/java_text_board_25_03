package com.sbs.java.text_board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("== JAVA 텍스트 게시판 구현 ==");

    System.out.print("명령어) ");
    String cmd = sc.nextLine();

    System.out.printf("입력받은 명령어 : %s\n", cmd);

    System.out.println("== JAVA 텍스트 게시판 종료 ==");
    sc.close();
  }
}