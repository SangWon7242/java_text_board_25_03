package com.sbs.java.text_board.container;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;
  
  static { // 프로그램 실행시 딱 한번 실행
    scanner = new Scanner(System.in);
  }
}
