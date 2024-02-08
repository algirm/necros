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

## Run wasmJs from docker (local)
1. Checkout repository
2. Create Dockerfile for build project
```
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
```
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
