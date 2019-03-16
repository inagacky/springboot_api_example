# springboot API Frame 

SpringBootで作成したAPIのサンプルです。

## DB
### DBはmysqlを使用しています。Dockerで起動させます。

#### 起動方法

##### ビルド方法　
`/bin/sh build_dev.sh` 

##### 実行方法
`/bin/sh run_dev.sh`

##### 初回の場合
###### docker上へのテーブル自動作成
自動化ができなかったため、起動したmysqlコンテナにログイン後、下記のコマンドを実行します。  
(自動化でき次第変更する)  
`cd init`  
`/bin/sh init_database.sh`
