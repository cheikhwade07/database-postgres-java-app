# Database Interaction with PostgreSQL and Application Programming

## Prereqs
- Java 17+
- PostgreSQL 17+ (local)
- Maven 3.9+

## Setup
1. Create DB and load schema:
   - In pgAdmin run `db/schema.sql` in database `school` **or**
   - `psql -h localhost -U postgres -d school -f db/schema.sql`
2. Set env vars:
   - Windows Git Bash:
     ```bash
     export DB_URL="jdbc:postgresql://localhost:5432/school"
     export DB_USER="postgres"
     export DB_PASSWORD="<your-password>"
     ```
3. Run:
   ```bash
   mvn clean package
   mvn exec:java -Dexec.mainClass="com.example.app.App"
