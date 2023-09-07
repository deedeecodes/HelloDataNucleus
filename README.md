# Duplicating a defect in which openTelemetry cannot instrument DataNucleus

##  Set your own connectionString in applicationinsights.json

Please see here: https://learn.microsoft.com/en-us/azure/azure-monitor/app/java-standalone-config#connection-string

Copy the connection string from Azure Application Insights as in the link, and copy to [applicationinsights.json](applicationinsights.json). 
This is a secret and should not be checked in to source control. Please do not check in your changes to this file. 

## Run the application
The following runs on linux. On Windows use the SET command instead of export

```bash
mvn datanucleus:enhance   # this will enhance the classes in the target directory
export OTEL_JAVAAGENT_EXCLUDE_CLASSES=org.datanucleus.store.rdbms.ParamLoggingPreparedStatement
mvn compile exec:exec`    # and this runs the application
```

You may get a h2 exception on start up but that is ok and not linked to this issue

## Expected behavior

We expect now to be able to go to Azure Application Insights, click 'application map' and see the database calls

We would like to see the actual sql 

## Actual behavior

We don't get the correct database calls in the application map

## Known Issues

We can't get the otel properties to work through maven. For example
```bash
-Dotel.traces.exporter=logging
-Dotel.metrics.exporter=none
-Dotel.logs.exporter=none
-Dotel.instrumentation.jdbc.statement-sanitizer.enabled=false
```
