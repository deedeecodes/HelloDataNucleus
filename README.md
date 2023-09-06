# Duplicating a defect in which openTelemetry cannot instrument DataNucleus

# Steps 

* Set DataNucleus Information in Schema Tool menu
* Set your own connectionString in applicationinsights.json
* Run the with the following parameters  

# Program arguments

-Dapplicationinsights.configuration.file=applicationinsights.json
-Dotel.traces.exporter=logging
-Dotel.metrics.exporter=none
-Dotel.logs.exporter=none
-Dotel.instrumentation.jdbc.statement-sanitizer.enabled=false

# VM arguments

-javaagent:applicationinsights-agent-3.4.16.jar

# DataNucleus

* Driver Name: org.h2.Driver
* Sql Connection Url: jdbc:h2:mem:helloworlddb

