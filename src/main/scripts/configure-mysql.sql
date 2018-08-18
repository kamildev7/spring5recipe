## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE dev_env;
CREATE DATABASE prod_env;

#Create database service accounts
CREATE USER 'dev_env_user'@'localhost' IDENTIFIED BY 'kamil';
CREATE USER 'prod_env_user'@'localhost' IDENTIFIED BY 'kamil';
CREATE USER 'dev_env_user'@'%' IDENTIFIED BY 'kamil';
CREATE USER 'prod_env_user'@'%' IDENTIFIED BY 'kamil';

#Database grants
GRANT SELECT ON dev_env.* to 'dev_env_user'@'localhost';
GRANT INSERT ON dev_env.* to 'dev_env_user'@'localhost';
GRANT DELETE ON dev_env.* to 'dev_env_user'@'localhost';
GRANT UPDATE ON dev_env.* to 'dev_env_user'@'localhost';
GRANT SELECT ON prod_env.* to 'prod_env_user'@'localhost';
GRANT INSERT ON prod_env.* to 'prod_env_user'@'localhost';
GRANT DELETE ON prod_env.* to 'prod_env_user'@'localhost';
GRANT UPDATE ON prod_env.* to 'prod_env_user'@'localhost';
GRANT SELECT ON dev_env.* to 'dev_env_user'@'%';
GRANT INSERT ON dev_env.* to 'dev_env_user'@'%';
GRANT DELETE ON dev_env.* to 'dev_env_user'@'%';
GRANT UPDATE ON dev_env.* to 'dev_env_user'@'%';
GRANT SELECT ON prod_env.* to 'prod_env_user'@'%';
GRANT INSERT ON prod_env.* to 'prod_env_user'@'%';
GRANT DELETE ON prod_env.* to 'prod_env_user'@'%';
GRANT UPDATE ON prod_env.* to 'prod_env_user'@'%';