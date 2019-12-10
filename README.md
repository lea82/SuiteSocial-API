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

- See the logs to follow up the deployment process

```
$ docker logs -f --tail 30 suitesocialapi
```

- For code updating in the server, you will need stop the docker instance and get up it again using the following commands once you have the directory updated
```
$ docker-compose rm -sf suitesocialapi
$ docker-compose up -d suitesocialapi
```
