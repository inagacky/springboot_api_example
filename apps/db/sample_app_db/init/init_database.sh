#!/bin/bash
 
SCRIPT_DIR=$(cd $(dirname $0) && pwd)

echo "CREATE DATABASE IF NOT EXISTS \`$MYSQL_DATABASE\` ;" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;
echo "FLUSH PRIVILEGES;" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;
echo "CREATE USER $MYSQL_APP_USER@localhost IDENTIFIED BY '$MYSQL_APP_USER_PASSWORD'" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;
echo "GRANT ALL ON $MYSQL_DATABASE.* TO $MYSQL_APP_USER@localhost" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;

echo "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '$MYSQL_ROOT_PASSWORD';" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;
echo "ALTER USER '$MYSQL_APP_USER'@'localhost' IDENTIFIED WITH mysql_native_password BY '$MYSQL_APP_USER_PASSWORD';" | mysql -uroot -p$MYSQL_ROOT_PASSWORD;

# Please Add 
cat ./001_create_tables.sql_ |  mysql -uroot -p$MYSQL_ROOT_PASSWORD $MYSQL_DATABASE
