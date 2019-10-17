#!/bin/sh

if [ "$MATRIX4J_HOME" == "" ]; then
  if [ -e ../bin/${0##*/} ]; then
    MATRIX4J_HOME=".."
  elif [ -e ./bin/${0##*/} ]; then
    MATRIX4J_HOME="."
  else
    echo "env MATRIX4J_HOME not defined"
    exit 1
  fi
fi

cd $MATRIX4J_HOME
mvn clean deploy -DperformRelease=true -Dskiptests=true -Dmaven.test.skip=true