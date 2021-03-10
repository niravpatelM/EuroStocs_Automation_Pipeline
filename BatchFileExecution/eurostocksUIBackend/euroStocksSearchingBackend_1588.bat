@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\eurostocksUIBackend\euroStocksSearchingBackend_1588.spec