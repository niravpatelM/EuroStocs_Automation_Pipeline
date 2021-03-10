@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\eurostocksUI\euroStocksVehicleContactFunctionality_1570.spec