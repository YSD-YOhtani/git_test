# 研修参加者向けヒント集

## Git基本コマンド

### 初期設定（最初に1回だけ実行）
```bash
git config --global user.name "あなたの名前"
git config --global user.email "あなたのメールアドレス"
```

### よく使うGitコマンド

```bash
# リポジトリをクローン
git clone <リポジトリURL>

# ブランチ作成と切り替え
git checkout -b feature/新機能名

# 現在の状態を確認
git status

# ファイルをステージング
git add .
# または特定のファイルのみ
git add src/main/java/com/example/Calculator.java

# コミット
git commit -m "機能追加: 平方根計算機能を追加"

# リモートリポジトリにプッシュ
git push origin feature/新機能名

# ブランチ一覧表示
git branch -a

# ブランチ切り替え
git checkout main
```

## 課題解決のヒント

### 課題1: 0除算の処理

```java
// 修正前（問題のあるコード）
public double divide(double a, double b) {
    return a / b;  // b=0の場合Infinityが返される
}

// 修正案の例
public double divide(double a, double b) {
    if (b == 0) {
        throw new IllegalArgumentException("0で除算することはできません");
        // または特別な値を返す: return Double.NaN;
    }
    return a / b;
}
```

### 課題2: 平方根機能の追加

```java
// Calculator.javaに追加する メソッドの例
public double sqrt(double a) {
    if (a < 0) {
        throw new IllegalArgumentException("負数の平方根は計算できません");
    }
    return Math.sqrt(a);
}
```

対応するテストケース例：
```java
@Test
@DisplayName("平方根のテスト")
void testSqrt() {
    assertEquals(3.0, calculator.sqrt(9.0), 0.001);
    assertEquals(2.0, calculator.sqrt(4.0), 0.001);
    assertEquals(0.0, calculator.sqrt(0.0), 0.001);
}
```

### 課題3: コード改善のポイント

1. **コメントの追加**
   - メソッドの目的を説明
   - パラメータの説明
   - 戻り値の説明
   - 例外処理の説明

2. **エラーメッセージの改善**
   ```java
   // 改善前
   System.out.println("エラー");
   
   // 改善後
   System.out.println("エラー: 有効な数値を入力してください。入力値: " + input);
   ```

## Pull Request作成時のポイント

### 良いPRタイトルの例
- `機能追加: 平方根計算機能を追加`
- `バグ修正: 0除算時の例外処理を追加`
- `リファクタリング: エラーメッセージを改善`

### PRの説明に含めるべき内容
1. **変更内容の概要**
2. **変更理由**
3. **テスト方法**
4. **レビュアーが確認すべき点**

### PR説明のテンプレート例
```markdown
## 変更内容
- 0除算時の例外処理を追加
- 対応するテストケースを追加

## 変更理由
- 現在0で除算した場合、Infinityが返されるため、適切なエラー処理が必要

## テスト方法
- `mvn test` でテストが通ることを確認
- Main.javaで実際に0除算を試して例外が発生することを確認

## レビューポイント
- 例外メッセージが分かりやすいか
- テストケースが適切か
```

## トラブルシューティング

### よくある問題と解決策

1. **コンフリクトが発生した場合**
   ```bash
   git pull origin main
   # コンフリクトを手動で解決
   git add .
   git commit -m "コンフリクト解決"
   git push origin feature/ブランチ名
   ```

2. **間違ったファイルをコミットした場合**
   ```bash
   # 直前のコミットを取り消し
   git reset HEAD~1
   ```

3. **Mavenが使えない場合のテスト実行**
   ```bash
   # JUnitライブラリがない場合は手動テスト
   cd src/main/java
   javac com/example/*.java
   java com.example.Main
   ```

## コードレビューでチェックするポイント

### レビュアー向け
- [ ] コードが期待通りに動作するか
- [ ] 適切なエラー処理が実装されているか
- [ ] テストケースが十分か
- [ ] コメントが分かりやすいか
- [ ] コーディング規約に従っているか

### レビュー対象者向け
- セルフレビューを行ってから提出する
- テストが全て通ることを確認する
- 不要なファイルがコミットに含まれていないかチェック
- コミットメッセージが分かりやすいか確認

## 参考資料

- [Git公式ドキュメント](https://git-scm.com/doc)
- [GitHub Flow](https://guides.github.com/introduction/flow/)
- [Javadocの書き方](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)