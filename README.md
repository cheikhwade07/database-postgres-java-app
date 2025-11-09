# Database Interaction with PostgreSQL and Application Programming

## Prerequisites
- Java 17+, Maven 3.9+
- PostgreSQL (local)

## Database Setup
Create database `school` and run the schema:
- Using pgAdmin: open `db/schema.sql` on `school` DB and execute.
- Or with psql:
  psql -h localhost -U postgres -c "CREATE DATABASE school;"
  psql -h localhost -U postgres -d school -f db/schema.sql

## Run the App
Set environment variables (Git Bash):
export DB_URL="jdbc:postgresql://localhost:5432/school"
export DB_USER="postgres"
export DB_PASSWORD="<your-password>"

Build and run:
mvn clean package

# List all
mvn -q exec:java -Dexec.mainClass="com.example.app.App" -Dexec.args="list"

# Add 
mvn -q exec:java -Dexec.mainClass="com.example.app.App" -Dexec.args='add Alice Wong alice.wong@example.com 2023-09-03'

# Update email
mvn -q exec:java -Dexec.mainClass="com.example.app.App" -Dexec.args='update 10 alice.wong+updated@example.com'

# Delete
mvn -q exec:java -Dexec.mainClass="com.example.app.App" -Dexec.args='delete 10'

## Video

