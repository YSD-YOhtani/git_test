package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Calculator クラスのテストクラス
 * GitHub研修用のサンプルテスト
 */
class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("加算のテスト")
    void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
        assertEquals(0.0, calculator.add(-1.0, 1.0), 0.001);
        assertEquals(-5.0, calculator.add(-2.0, -3.0), 0.001);
    }
    
    @Test
    @DisplayName("減算のテスト")
    void testSubtract() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), 0.001);
        assertEquals(-2.0, calculator.subtract(3.0, 5.0), 0.001);
        // TODO: 研修参加者への課題 - より多くのテストケースを追加してください
    }
    
    @Test
    @DisplayName("乗算のテスト")
    void testMultiply() {
        assertEquals(15.0, calculator.multiply(3.0, 5.0), 0.001);
        assertEquals(0.0, calculator.multiply(0.0, 5.0), 0.001);
        // TODO: 負数での乗算テストを追加してください
    }
    
    @Test
    @DisplayName("除算のテスト - 正常ケース")
    void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
        assertEquals(0.5, calculator.divide(1.0, 2.0), 0.001);
    }
    
    // TODO: 研修参加者への課題
    // 以下のテストは不完全です。適切な実装を追加してください。
    /*
    @Test
    @DisplayName("ゼロ除算のテスト")
    void testDivideByZero() {
        // 0で除算した場合の適切な処理をテストしてください
        // 例外をスローするか、特別な値を返すかを決めて実装してください
    }
    */
    
    @Test
    @DisplayName("結果フォーマットのテスト321")
    void testFormatResult() {
        String result = calculator.formatResult("+", 2.5, 3.7, 6.2);
        assertEquals("2.50 + 3.70 = 6.20", result);
        
        // TODO: より多くのフォーマットテストを追加してください
    }
    
    // TODO: 研修参加者への課題
    // 平方根計算機能を追加した際のテストケースをここに追加してください
}