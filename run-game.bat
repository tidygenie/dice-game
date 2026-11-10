@echo off
chcp 65001 >nul
cd /d "%~dp0"
javac *.java Helper\TerminalColors.java
if errorlevel 1 (
    pause
    exit /b 1
)
java DiceGame
pause
