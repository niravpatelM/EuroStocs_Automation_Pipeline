# EuroStocks Test Automation Suite(Behaviour Driven Development) Automation Testing with Gauge, Selenium and Maven 

## Getting Started
- Gauge - https://gauge.org/
- Gauge Docs - https://docs.gauge.org/?os=windows&language=javascript&ide=vscode
- Maven - https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- Selenium - https://www.seleniumhq.org/docs/
- Maven Env. Variable Setup - https://www.mkyong.com/maven/how-to-install-maven-in-windows/

### Plugins

Automation Project is currently extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin 			| README |
| ------ 			| ------ |
|Gauge  			| [https://plugins.jetbrains.com/plugin/7535-gauge/][PlGb] 	|
|Gauge Report	    | [https://gauge.org/plugins/][PlGe]   			|
|Gauge html-Report	| [https://github.com/getgauge/html-report/][PlGc]			|
|Gauge xml-Report	| [https://github.com/getgauge/xml-report][PlGd]			|

### Installation

## Running Examples Using Command Line Console
```sh
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one).
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Type Command : mvn test-compile gauge:execute (all the spec file from specs folder)
- Type Command : mvn test-compile gauge:execute -DspecsDir=specs\example.spec (used to specific spec file)
- Type Command : gauge docs spectacle specs
```

License
----
Copyright &copy; Nirav Patel. All rights reserved.

   [PlGb]: <https://plugins.jetbrains.com/plugin/7535-gauge/>
   [PlGc]: <https://github.com/getgauge/html-report/>
   [PlGd]: <https://github.com/getgauge/xml-report/>
   [PlGe]: <https://gauge.org/plugins/>
   
