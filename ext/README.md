```bash
### Dockerfileのあるディレクトリに移動してビルド
cd ./docker
docker build -t kinesis-commerce-system-sample-postgres ./

### postgres起動
docker run \
       --name kinesis-commerce-system-sample-postgres \
       -p 5432:5432 \
       -e POSTGRES_USER=commerce_database_user \
       -e POSTGRES_PASSWORD=hogehoge \
       -e POSTGRES_DB=commerce_database \
       -e LANG=ja_JP.UTF-8 \
       -d kinesis-commerce-system-sample-postgres

### コンテナにログインしてからpsqlで接続。パスワードはなんでも通る
docker exec -it kinesis-commerce-system-sample-postgres psql -h localhost -p 15432 -U commerce_database_user -d commerce_database -W

```
