# Mastercard Developer API - Spending Pulse - Reference Implementation - Angular/Spring-Boot #
Spring-Boot/Maven/Angular based reference implementation of Mastercard Developer API - Spending Pulse

## [Demo](https://perusworld.github.io/mcdevapi-spendingpulse-refimpl-web/) ##

## Requirements ##
1. JDK 1.8+
1. Maven
1. Bower
   

## Setup Client App (optional if you want to host the sample client app) ##
This setups up the same client app that is being used in [Mastercard Developer API - Spending Pulse - Reference Implementation - Angular/Express](https://github.com/perusworld/mcdevapi-spendingpulse-refimpl-web)

```bash
git submodule init
git submodule update
cd  src/main/resources/ref-html
bower install
```

## Run with Remote Debug ##
```bash
set MAVEN_OPTS=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
mvn -Dserver.port=3000 -Dmastercard.api.p12.path="file:///C:/path-to-p12-file" -Dmastercard.api.consumer.key="api-key" spring-boot:run
```

## Package Executable jar/war ##
```bash
mvn clean package
```

## Running the packaged jar ##
```bash
	java -jar target\mcdevapi-spendingpulse-refimpl-springboot-0.1.war
```

## Test App ##
Open browser and goto [http://localhost:3000](http://localhost:3000)

## Test REST APIs -cURL ##
### Query spending pulse reports using period/country sent as part of JSON post ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"currentRow": 1,
	"offset": 25,
	"country": "US",
	"period": "Weekly"
}' "http://localhost:3000/spendingPulse"
```

### Query weekly gasoline report ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"currentRow": 1,
	"offset": 25
}' "http://localhost:3000/gasWeekly"
```

### Query distinct list of reports subscribed to ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"currentRow": 1,
	"offset": 25
}' "http://localhost:3000/parameters"
```

### Query available subscriptions ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"currentRow": 1,
	"offset": 25
}' "http://localhost:3000/subscriptions"
```
