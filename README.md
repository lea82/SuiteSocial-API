## Deploying

- Go to the directory `SuiteSocial`

```
$ cd SuiteSocial
```

- Create the environment variables file and add the following variables: `MYSQL_DB_HOST`, `MYSQL_DB_PORT`, `MYSQL_DB_NAME`, `MYSQL_DB_USERNAME` and `MYSQL_DB_PASSWORD`

```
$ vi .env.api
``` 

- Run the `docker-compose` command to deploy the application

```
$ docker-compose up -d suitesocialapi
```

- See the logs

```
$ docker logs -f --tail 30 suitesocialapi
```