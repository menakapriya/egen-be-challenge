											EGEN CODING CHALLENGE
*************************************************************************************************************
Project Requirements:
--------------------

Please refer to document "Egen Java Challenge - Level 2" in downloaded project code base for given requirements.

Service Methods implemented in Handler for reference:

AlertsMonitorHandler: 
1) readAllAlerts() : Used to read all the alerts data from MongoDB Metric's collection.
2) readAlertsByRange() : Used to read the alerts data for the give time range. 

MetricsMonitorHandler:
1) createMetrics() : Used to save the metrics data into MongoDB Metric's collection.
2) readAllMetrics() : Used to read all the metrics data from MongoDB Metric's collection.
3) readMetricsByRange() : Used to read the metrics data for the give time range.


*************************************************************************************************************
MONGODB DATABASE ENVIRONMENT SETUP
---------------------------------- 

1) Create database: Metrics_Alert_DB
2) Create collections: Metrics and Alerts
Steps to create database and collections using following commands:
	> use Metrics_Alert_DB
	> db.createCollection("metrics");
	> db.createCollection("alerts");
 
***************************************************************************************************************
						Project Environment setup and Execution

METHOD #1: Spring Tool suite IDE
--------------------------------

1) Go to GITHUB repository: https://github.com/menakapriyaranjani/egen-be-challenge
2) Please download the source code by clicking "Clone or download" button.
3) Please extract the downloaded ZIP file to any desired location in your system.
4) Navigate to the 'egen-be-challenge-master' folder in the command prompt
5) Execute maven build using command: mvn clean install  
6) Import as existing Maven project in STS IDE referring to POM.XML file in 'egen-be-challenge-master' folder.
7) Right click project and select Maven -> Update Project.
8) Select POM.XML file and run as Maven Build providing goals as: clean install 

Please Note: Incase of build issues due to Junit Test Case failure, please execute build using folling command:
"clean install -DskipTests"

10) Once build is successful, right click project and RUN as "SpringBoot Application".
11) Now, please execute the Emulator in command prompt having following command:

	"java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/metricsHandler/createMetrics 	sensor-emulator-0.0.1-SNAPSHOT.jar"

Please Note: Updated for context root in URL as per application handler method.


METHOD #2: Windows command prompt
---------------------------------

1) Go to GITHUB repository: https://github.com/menakapriyaranjani/egen-be-challenge
2) Please download the source code by clicking "Clone or download" button.
3) Please extract the downloaded ZIP file to any desired location in your system.
4) Navigate to the 'egen-be-challenge-master' folder in the command prompt
5) Execute maven build using command: mvn clean install

Please Note: Incase of build issues due to Junit Test Case failure, please execute build using folling command:
"mvn clean install -DskipTests"

6) Once build is successful, navigate to 'egen-be-challenge-master/target' folder and run the following command:
	
	"java -jar egenWeightMonitor-0.0.1-SNAPSHOT.jar"
	
7) Now, please execute the Emulator in command prompt having following command:

	"java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/metricsHandler/createMetrics 	sensor-emulator-0.0.1-SNAPSHOT.jar"

Please Note: Updated for context root in URL as per application handler method.
***************************************************************************************************************