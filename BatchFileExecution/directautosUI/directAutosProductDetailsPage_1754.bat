@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\directautosUI\directAutosProductDetailsPage_1754.spec