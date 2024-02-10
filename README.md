This is a Kotlin Multiplatform project targeting Android, iOS, Web.

* `:shared:common` is for code that will be shared across applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.
  - Web using Kotlin/JS and wasmJs also (`jsMain`, `wasmJsMain`)

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


**Note:** Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).
So do kotlin js web, still this is for personal development and exploration.

Web using kotlin JS (react) -> run application by running the `:app-web:jsApp:jsBrowserDevelopmentRun` Gradle task.
Web using kotlin WASM (compose) -> run application by running the `:app-web:wasmJsApp:wasmJsBrowserDevelopmentRun` Gradle task.

## Deploy wasmJs from docker (local)
1. Checkout repository
2. Create Dockerfile for build project
```Dockerfile
FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle wasmJsBrowserDistribution --no-daemon
```
3. Build project image
```
docker build -t necros-img .
```
4. Create new directory for webserver (different directory from project)
5. Create Dockerfile for web server
```Dockerfile
FROM necros-img:latest AS buildImg
FROM nginx
COPY --from=buildImg /home/gradle/src/app-web/wasmJsApp/build/dist/wasmJs/productionExecutable /usr/share/nginx/html
WORKDIR /usr/share/nginx/html
RUN ls
```
6. Build web server image
```
docker build -t webserver-img .
```
7. Run webserver to localhost
```
docker run -it -d -p 80:80 webserver-img 
```

## Deploy wasmJs from docker (cloud) with minimum specification machine
1. Build application with your machine (local) on IDE
```agsl
./gradlew wasmJsBrowserDistribution
```
2. Copy or push all files inside `app-web/wasmJsApp/build/dist/wasmJs/productionExecutable` 
to another temp remote repository or directly push to server if available 
4. Create `/src` directory and move all files pushed before into it
5. Create `Dockerfile` (so the directory contain `Dockerfile` and `/src`)
```Dockerfile
FROM progrium/busybox
ADD /src /var/www/html
VOLUME necros-wasm:/var/www/html
```
6. Build into docker image
```
docker build -t necros-wasm-image .
```
7. Create docker compose file
```yml
version: '3'

services:
  necros-wasm:
    image: necros-wasm-image
    container_name: necros-wasm
    volumes:
      - necros-wasm:/var/www/html

  necros-wasm-webserver:
    depends_on:
      - necros-wasm
    image: nginx:1.15.12-alpine
    container_name: necros-wasm-webserver
    restart: unless-stopped
    ports:
      - "2000:2000"
    volumes:
      - necros-wasm:/var/www/html
      - ./nginx-conf:/etc/nginx/conf.d
    networks:
      - app-network
volumes:
  necros-wasm:

networks:
  app-network:
    driver: bridge
```
8. Create directory `nginx-conf` and create `nginx.conf` inside it
```conf
server {
        listen 80;
        listen [::]:80;

        server_name <your_pub_ip> localhost;

        root /var/www/html;

        location ~ /.well-known/acme-challenge {
                allow all;
                root /var/www/html;
        }
        location = /favicon.ico {
                log_not_found off; access_log off;
        }
        location = /robots.txt {
                log_not_found off; access_log off; allow all;
        }
        location ~* \.(css|gif|ico|jpeg|jpg|js|png|wasm)$ {
                expires max;
                log_not_found off;
        }

        include       /etc/nginx/mime.types;

        types {

            application/wasm wasm;

        }

        default_type  application/octet-stream;
}
```
9. Run docker compose
```yml
docker-compose up -d
```
10. If there any change, pull new code to `/src` and do build image and recreate container
```yml
docker-compose up -d --force-recreate
```
or if want to reload one container
```yml
docker-compose up -d --force-recreate --no-deps <container_name>
```

## Version catalog util library
Add this plugin on build.gradle.kts project root
```renderscript
plugins { 
    id("com.github.ben-manes.versions") version "0.41.0"
    id("nl.littlerobots.version-catalog-update") version "0.8.3"
}

versionCatalogUpdate { // Optional config
    versionCatalogs {
        keep {
            keepUnusedVersions = true
            keepUnusedLibraries = true
            keepUnusedPlugins = true
        }
    }
}
```
1. `./gradlew versionCatalogUpdate` → Automatically updates dependency versions, formats them, and sorts them alphabetically.
2. `./gradlew versionCatalogUpdate --interactive` → Lists updatable dependencies but does not automatically update them.
3. `./gradlew versionCatalogApplyUpdates` → Approves the updates listed for dependencies.
4. `./gradlew versionCatalogFormat` → Formats and alphabetically sorts the version catalog.