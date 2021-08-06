Google Vision Object Detection Application
(Spring Boot - Angular - H2 in memory database->{if needs change path to DB file})

First make sure your setup: https://cloud.google.com/vision/docs/setup.

Provide GOOGLE_APPLICATION_CREDENTIALS into application.properties:
spring.cloud.gcp.credentials.location= {PATH_TO_YOUR_CREDENTIALS}.

Run backend Java application, run frontend Angular Application:
e.g. 
Run Java on Intellij -> press RUN.
Angular on VSCode -> ng serve --open.

Notice: After submit sometimes need to refresh page to see last entered result if your internet connection in not fast.
