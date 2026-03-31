package com.example;

/**
 * 簡単な電卓クラス
 * GitHub研修用のサンプルアプリケーション
 */
public class Calculator {
    
    /**
     * 加算を行います
     * @param a 第一引数
     * @param b 第二引数
     * @return a + b の結果
     */
    public double add(double a, double b) {
        return a + b;
    }
    
    /**
     * 減算を行います
     * @param a 第一引数
     * @param b 第二引数
     * @return a - b の結果
     */
    public double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * 乗算を行います
     * @param a 第一引数
     * @param b 第二引数
     * @return a * b の結果
     */
    public double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * 除算を行います
     * 注意: 0で除算した場合の処理に問題があります（研修課題）
     * @param a 第一引数
     * @param b 第二引数
     * @return a / b の結果
     */
    public double divide(double a, double b) {
        // TODO: 0で除算する場合の適切な処理を追加してください
        return a / b;
    }
    
    /**
     * 結果をフォーマットして表示用の文字列を返します
     * @param operation 演算子
     * @param a 第一引数
     * @param b 第二引数
     * @param result 計算結果
     * @return フォーマットされた文字列
     */
    public String formatResult(String operation, double a, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operation, b, result);
    }
}