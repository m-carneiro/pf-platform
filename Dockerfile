FROM gradle:7.6.1-jdk17 as builder

ENV TZ=America/Sao_Paulo
ENV APP_DIR /app
WORKDIR $APP_DIR

RUN mkdir /tmp/cache

COPY build.gradle $APP_DIR/
COPY settings.gradle $APP_DIR/

RUN gradle dependencies -g /tmp/cache

COPY . $APP_DIR

RUN gradle assemble -g /tmp/cache --no-daemon

ENTRYPOINT ["sh", "init.sh"]

# -----------------------------------------------------------------------------

FROM openjdk:17-slim-buster

ENV TZ=America/Sao_Paulo
WORKDIR /app

COPY .env /app
COPY --from=builder /app/init.sh /app
COPY --from=builder /app/build/libs/pf-platform-1.jar /app/

EXPOSE 3000

ENTRYPOINT ["sh", "init.sh"]