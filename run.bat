@echo off
SETLOCAL ENABLEDELAYEDEXPANSION
SET CP_LIBS=.;lib\gson-2.10.1.jar
SET MAIN_CLASS=RestaurantDriver


SET SOURCES=
FOR /R src %%f IN (*.java) DO (
    SET SOURCES=!SOURCES! "%%f"
)

IF NOT DEFINED SOURCES (
    goto :EXECUTION
)

javac -cp %CP_LIBS% %SOURCES% -d src

IF ERRORLEVEL 1 (
    goto :END
)

:EXECUTION

java -cp src;lib\gson-2.10.1.jar %MAIN_CLASS%

:END
ENDLOCAL