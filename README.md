# Tookitaki-Test
Programming assignment for Tookitaki company

## Project Information
Framework : Play       version 2.6.11<br />
Language  : Scala      version 2.12.7<br />
Database  : Mysql      version 5.7.24

## Configurations


Create mysql database and add database details to Tookitaki-Test/conf/application.conf file

db.default.url="jdbc:mysql://localhost/{databse name}"<br /> 
db.default.username={username}<br />
db.default.password=""

create table name bitcoin_prices with fields price(decimal(8,2)) and time(datetime)
Add url json data into this table


## How to run the project
 
Clone or download project
go to project folder and run the command sbt run

the go to url http://localhost:9000/price/lastWeek.
It will show the last week bitcoin prices data

## Check the data

last week data http://localhost:9000/price/lastWeek.<br />
lastmonth data http://localhost:9000/price/lastMonth<br />
custom range data http://localhost:9000/price/range/{startDate}/{endDate} use yyyyddMM for date formats<br />
get average date range http://localhost:9000/avg/{startDate}/{endDate} use yyyyddMM for date formats

## Improvements

Allowing users to get the forecasted bitcoin price for next 15 days implementation.<br />
Use query parameters instead of passing through url<br />
adding table name as a configuration<br />
proper logging mechanism


