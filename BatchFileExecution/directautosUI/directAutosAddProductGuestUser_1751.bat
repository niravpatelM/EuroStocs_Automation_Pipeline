@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\directautosUI\directAutosAddProductGuestUser_1751.spec