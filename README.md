# Read Me First
This application stores and calculates distance between stored coordinates for 2 wheeler vehicles.


# Getting Started

## How to run the application

#### Runtime environment
This SpringBoot application requires JDK17 and Apache Maven to run

Open a terminal in project root directory and run `mvn spring-boot:run`.

Application will start on `http://localhost:8080`

#### Database
This application needs `postgreSQL` to connect to with id and password in `application.properties` file under 
`src/main/resources`

Create a database with name `gps-tracking`

The `data.sql` file is an initial data dump file to populate the database with some initial value.

**IMPORTANT : THIS SCRIPT IS ONLY BE MEANT TO RUN ONCE PER DATABASE SCHEMA CREATION**

**IMPORTANT :** Comment lines `1-30` and uncomment line `31` if you have to restart the application to avoid errors. 

### API endpoints

This application has three categories of endpoints

1. `/owner`
   1. `/all-owners`: returns the list of all owners
   2. `/get-owner/{owner_id}`: return an owner with given {owner_id} in the path
   3. `/save`: saves an owner object in database
   4. `/deleteAll`: delete all owners
   5. `/delete/{owner_id}`: deletes an owner with given {owner_id} in the path
2. `/vehicle/{owner_id}`: `owner_id` is required for authorization check  
   1. `/all-vehicles`: returns the list of all vehicles
   2. `/get/{vehicle_id}`: return a vehicle associated with given {owner_id} in the path
   3. `/save`: saves a vehicle object in database associates with an owner
   4. `/deleteAll`: delete all vehicle associated with given {owner_id} in the path
   5. `/delete/{vehicle_id}`: deletes a vehicle associated with given {owner_id} in the path 
3. `/gpsData/{owner_id}`: `owner_id` is required for authorization check
   1. `/getInfo/{vehicle_id}`: returns a list of all gps data associates with a vehicle_id
   2. `/save/{vehicle_id}`: saves gps data object in database for a vehicle
   3. `/getDist/{vehicle_id}?startDate=<startDate>&endDate=<endDate>`: calculates and return distance travelled by a vehicle between 
      two dates
