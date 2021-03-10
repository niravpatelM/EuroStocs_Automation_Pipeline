@echo off
timeout 10
cd /D D:\IDEA\AutoEuroStocks & mvn test-compile gauge:execute -DspecsDir=specs\eurostocksUIBackend\euroStocksRemarketingPortalForProductsBackend_1589.spec