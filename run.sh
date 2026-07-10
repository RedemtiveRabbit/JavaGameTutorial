#!/bin/zsh
set -e

javac -d bin $(find src -name "*.java")
java -cp bin:res main.Main