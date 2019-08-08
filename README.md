## デモ
こちらがデモ動画です  
![teamlab_submission](https://user-images.githubusercontent.com/43234619/62705387-46281180-ba28-11e9-8ee0-fc784f1051de.gif)


## 使用した技術要素
Spring Boot (Intellij)で初期化  
データベースにMySQL  

## 全体の設計
デモ動画の通り  

## 開発環境のセットアップ手順
まず、[MySQL](https://dev.mysql.com/downloads/file/?id=487977)をダウンロードしてください  
ダウンロード時、パスワードはレガシーモードで(暗号化なしで)`slslslsl`と設定するようにしてください（他のパスワードを設定した場合このアプリのソースコードのapplication.propertiesのパスワードのところを変えてください)    
もし暗号化ありで起動してしまった場合[こちら](https://stackoverflow.com/questions/49194719/authentication-plugin-caching-sha2-password-cannot-be-loaded)の手順にしたがってパスワードを設定し直してください  

次に、Windowsの場合は環境変数を設定してMySQLがコマンドプロンプトから実行できるようにしてください  
Mac, Linux の場合は `~/.bash_profile` に `export PATH=$PATH:/usr/local/mysql/bin` を追記しターミナルを再起動するか`source ~/.bash_profile`を実行してください   
ターミナルを再起動したら`$ mysql` を実行してください  
そうして,`mysql> CREATE DATABASE demodb1` を実行してください  
これでデータベースの準備は完了です  

あとはこのレポジトリをダウンロードして、`./gradlew bootrun` で `localhost:8080`に本アプリが立ち上がります  

## 今後やりたいこと  
あいまい検索を実装できていません  
また、一回完了や削除を押してしまったら取り消しができません  
各Todoリストにメモを追加してもいいかもしれません  

## 大変だったとところ
JpaRepository にメソッドを追加する際、メソッドの引数がTodoクラスのフィールドにある名前でないとエラーになる（？）ことに気がつくのに時間がかかりました  
また、データベースとの連携をしたことがなかったので、たくさんのページにお世話になりました  
