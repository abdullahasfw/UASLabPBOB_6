#!/bin/bash
javac -cp .:lib/gson-2.10.1.jar src/**/*.java
java -cp .:lib/gson-2.10.1.jar src.RestaurantDriver