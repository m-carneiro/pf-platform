#!/usr/bin/env bash

set -e

ENVIRONMENT_NAME="${SPRING_PROFILES_ACTIVE:-"development"}"
JVM_OPS="${JVM_OPS:-""}"
echo "ENVIRONMENT_NAME: ${ENVIRONMENT_NAME}"

COMMAND=${1:-"web"}
echo "$COMMAND"

case "$COMMAND" in
  baseCheck)
    exit 0
    ;;
  web)
      exec java $JVM_OPS \
      -Djava.security.egd=file:/dev/./urandom \
      -Dspring.profiles.active=${ENVIRONMENT_NAME} \
      -jar /app/pf-platform*.jar \
      $COMMAND
    ;;
  *)
    exec sh -c "$*"
    ;;
esac