# Java-coaching_test_2
SpringBootコース フレームワークテスト2

## clone時の注意点
clone時は以下のコマンドを利用し、ローカルリポジトリの名称が `coaching_test_2` になるようにしてください。

```git
git clone https://github.com/SLStudioGithub/CoachingTest-SpringBoot-FWTest02.git coaching_test_2
```

クローンが完了したら、プロジェクトに移動しておきましょう。
```
cd coaching_test_2
```

## 連携リポジトリの切り替え
clone後、解答提出用にご自身で作成していただいたリポジトリに連携を行っていただく必要があります。

1. GitHubに新しいプロジェクトを作成
    - プロジェクト名は `coaching_test_2` とし、private なリポジトリとして作成しましょう
    - コーチング担当者をプロジェクトのCollaboratorに追加してください  
2. cloneしたプロジェクトの連携先を変更
    - GitBashにて以下のコマンドを実行してください
    ```
    git remote set-url origin 新しいリポジトリのURL
    
    // 連携中のリポジトリ情報の確認（表示される内容が自分で作ったリポジトリになっていればOKです）
    git remote -v
    ```
    - 作業前に一度pushしておき、提出用リポジトリに反映されることを確かめておきましょう
    ```
    git push
    ```

## Eclipseへのインポート
cloneしてきたプロジェクトのインポートを行います。
Eclipseにて以下の操作を行いましょう。

1. `ファイル` をクリック
2. メニューの中から`インポート` をクリック
3. Gradle > 既存のGladleプロジェクト を選択し `次へ` をクリック
4. プロジェクト・ルート・ディレクトリー の欄にcloneしてきたプロジェクトのパスを設定（参照 を利用すると良い）
5. `完了` をクリック


## データの投入
テストで利用するデータをDBに準備します。
以下のSQLを実行してください。
```sql
-- USER SQL(ユーザー名、パスワードなど)
CREATE USER "FW_COACHING_TEST" IDENTIFIED BY "fw_coaching_test"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- 割当て容量の変更
ALTER USER "FW_COACHING_TEST" QUOTA UNLIMITED ON "USERS";

-- ROLES(付与されたロール)
GRANT "CONNECT" TO "FW_COACHING_TEST" ;
GRANT "RESOURCE" TO "FW_COACHING_TEST" ;
ALTER USER "FW_COACHING_TEST" DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES(ユーザーのシステム権限)
GRANT CREATE ANY SEQUENCE TO "FW_COACHING_TEST" ;
GRANT CREATE VIEW TO "FW_COACHING_TEST" ;
GRANT CREATE SESSION TO "FW_COACHING_TEST" ;
GRANT CREATE TABLE TO "FW_COACHING_TEST" ;
GRANT CREATE ANY SYNONYM TO "FW_COACHING_TEST" ;
GRANT CREATE SYNONYM TO "FW_COACHING_TEST" ;
GRANT CREATE SEQUENCE TO "FW_COACHING_TEST" ;
GRANT CREATE ANY VIEW TO "FW_COACHING_TEST" ;
GRANT CREATE DATABASE LINK TO "FW_COACHING_TEST" ;
GRANT CREATE ANY TABLE TO "FW_COACHING_TEST" ;

GRANT ALTER SESSION TO "FW_COACHING_TEST" ;
GRANT ALTER DATABASE LINK TO "FW_COACHING_TEST" ;
GRANT ALTER ANY TABLE TO "FW_COACHING_TEST" ;
GRANT ALTER ANY SEQUENCE TO "FW_COACHING_TEST" ;
GRANT ALTER DATABASE TO "FW_COACHING_TEST" ;

GRANT DROP ANY SEQUENCE TO "FW_COACHING_TEST" ;
GRANT DROP ANY TABLE TO "FW_COACHING_TEST" ;
GRANT DROP ANY SYNONYM TO "FW_COACHING_TEST" ;
GRANT DROP ANY VIEW TO "FW_COACHING_TEST" ;
GRANT DROP PUBLIC SYNONYM TO "FW_COACHING_TEST" ;
GRANT DROP PUBLIC DATABASE LINK TO "FW_COACHING_TEST" ;

GRANT INSERT ANY TABLE TO "FW_COACHING_TEST" ;
GRANT SELECT ANY TABLE TO "FW_COACHING_TEST" ;
GRANT SELECT ANY SEQUENCE TO "FW_COACHING_TEST" ;
GRANT UPDATE ANY TABLE TO "FW_COACHING_TEST" ;
GRANT DELETE ANY TABLE TO "FW_COACHING_TEST" ;
GRANT COMMENT ANY TABLE TO "FW_COACHING_TEST" ;
```

以下の操作は、接続を `FW_COACHING_TEST` に変更してから行います。
```sql
-- テーブル作成
CREATE TABLE ANIMALS(
  ID NUMBER(11) NOT NULL
  , NAME VARCHAR2(64) NOT NULL
  , CONSTRAINT ANIMALS_PK PRIMARY KEY (ID) ENABLE
);
COMMENT ON TABLE ANIMALS IS '動物テーブル';
COMMENT ON COLUMN ANIMALS.ID IS '主キー';
COMMENT ON COLUMN ANIMALS.NAME IS '動物名';

-- データ挿入
CREATE SEQUENCE ANIMAL_ID_SEQ;
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, '人間');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, 'サメ');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, 'スズメ');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, 'カブトムシ');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, 'ワニ');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, 'カエル');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, '犬');
INSERT INTO ANIMALS (ID, NAME) VALUES (ANIMAL_ID_SEQ.nextval, '鷲');
```
