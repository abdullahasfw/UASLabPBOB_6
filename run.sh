#!/bin/bash
javac -cp .:lib/gson-2.10.1.jar src/**/*.java src/*.java
java -cp src:lib/gson-2.10.1.jar RestaurantDriver