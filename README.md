### Dieses Projekt bauen und starten
#### Voraussetzung
Eine installierte Dockerumgebung

#### Gitprojekt klonen
```
git clone https://github.com/bastian-nolte/todolist.git
```

#### Bauen und im Dockercontainer starten
```
mvn clean install docker:build docker:start
```

Prüfen ob Service und Datenbank gestartet wurden
```
docker ps
```

Es sollte eine Ausgabe in etwa wie folgt erscheinen
```
CONTAINER ID        IMAGE                                    COMMAND                  CREATED             STATUS              PORTS                    NAMES
87df1ed082cd        bastiannolte/dev/todolist:1.0-SNAPSHOT   "/opt/jboss/wildfly/…"   5 minutes ago       Up 5 minutes        0.0.0.0:8080->8080/tcp   dev_todolist-1
a90edfec0dd5        mysql:8.0.2                              "docker-entrypoint.s…"   5 minutes ago       Up 5 minutes        0.0.0.0:3306->3306/tcp   mysql-1
```

Dockercontainer wieder stoppen
```
mvn docker:stop
```

#### Problembehebung
Dockerumgebnung aufräumen
```
docker system prune
```
