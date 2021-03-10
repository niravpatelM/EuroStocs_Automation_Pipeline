@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\directautosUI\directAutosAllContactFunctionality_1750.spec