package com.example;

import java.util.Scanner;

/**
 * 電卓アプリケーションのメインクラス
 */
public class Main {
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== GitHub研修用 電卓アプリケーション ===");
        System.out.println("使用可能な演算: +, -, *, /");
        System.out.println("終了するには 'quit' と入力してください");
        System.out.println();
        
        while (true) {
            try {
                System.out.print("第一引数を入力してください: ");
                String input1 = scanner.nextLine();
                if ("quit".equalsIgnoreCase(input1)) {
                    break;
                }
                double a = Double.parseDouble(input1);
                
                System.out.print("演算子を入力してください (+, -, *, /): ");
                String operation = scanner.nextLine();
                if ("quit".equalsIgnoreCase(operation)) {
                    break;
                }
                
                System.out.print("第二引数を入力してください: ");
                String input2 = scanner.nextLine();
                if ("quit".equalsIgnoreCase(input2)) {
                    break;
                }
                double b = Double.parseDouble(input2);
                
                double result = 0;
                boolean validOperation = true;
                
                switch (operation) {
                    case "+":
                        result = calculator.add(a, b);
                        break;
                    case "-":
                        result = calculator.subtract(a, b);
                        break;
                    case "*":
                        result = calculator.multiply(a, b);
                        break;
                    case "/":
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("無効な演算子です。");
                        validOperation = false;
                        break;
                }
                
                if (validOperation) {
                    System.out.println("結果: " + calculator.formatResult(operation, a, b, result));
                }
                
            } catch (NumberFormatException e) {
                System.out.println("エラー: 有効な数値を入力してください。");
            } catch (Exception e) {
                System.out.println("エラーが発生しました: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        System.out.println("アプリケーションを終了します。");
        System.out.println("アプリケーションを終了します。2");
        scanner.close();
    }
}