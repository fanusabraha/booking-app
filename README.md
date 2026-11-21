# Booking App

A Spring Boot prototype for browsing and managing event venues. Java 17 or newer and Maven are required. Open this folder in IntelliJ as a Maven project, or run on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Visit http://localhost:8080. By default the application uses an in-memory H2 database, which is empty on startup and is erased when the application stops. Add a venue through the interface to try search. The first Maven run may need internet access to download dependencies.

To use an existing MySQL database instead, create the database and set environment variables before running:

```powershell
$env:DB_URL = 'jdbc:mysql://localhost:3306/bookingApp'
$env:DB_USERNAME = 'your_database_user'
$env:DB_PASSWORD = 'your_database_password'
.\mvnw.cmd spring-boot:run
```

Avoid committing credentials. `DB_SCHEMA_ACTION` defaults to `update` for development; production needs managed database migrations and an explicit schema policy. The previous configuration contained credentials: rotate the database password and revoke/replace the Google OAuth client secret, including anywhere else they were used. Removing them from the latest file does not remove them from Git history.

## Current scope and next steps

This is a prototype, not ready for public deployment. Anyone can add, edit, or delete venues. Registration currently stores passwords in plain text and does not implement login; do not use real passwords or personal data. Google login is not implemented. The bookings link points to a separate service on localhost:9090; it is not included here. Contact requests are saved without associating them with a venue, and the current code does not implement a complete booking or payment flow.

Suggested reviewable branches, in order:

1. **MVP foundation (this branch):** local database defaults, external configuration and this guide.
2. **Authentication and authorization:** password hashing, validated registration and login, roles, CSRF protection, and restricting venue management to authorized staff. Existing plain-text passwords require a safe migration or reset.
3. **Venue and request workflows:** validation, associate inquiries with venues, clear confirmation and error pages, and image upload limits and validation.
4. **Booking workflow:** availability, reservations and cancellation rules, with database constraints or transactions to prevent simultaneous bookings of the same slot.
5. **Product experience:** responsive design, accessibility, useful empty states, and consistent navigation.
6. **Production readiness:** automated tests, migrations, structured logs without sensitive data, monitoring, backups and deployment configuration. Measure performance before adding caching, pagination, queues or additional servers.

For AWS, choose services and sizing after the booking and security requirements are clear. A typical starting point is a managed application deployment, RDS for MySQL, S3 for images, a secrets manager, HTTPS and monitoring. Costs and configuration depend on traffic and availability requirements. Do not expose this prototype to the internet before authentication, authorization and secret rotation are complete.

The temporary in-memory database starts with two fictional example venues and resized photos from this project. They reset on restart and are not added to MySQL. Their names, addresses, capacities and prices are examples.
