## Issue

### Description

Application stuck on shutdown if `ConcurrentTaskScheduler` is used and application has startup error.

### Reproducer

To reproduce try:

`$ ./mvnw clean spring-boot:run -Dspring-boot.run.profiles=non-working`

In this case `NonWorkingScheduler` is used with manually created `ConcurrentTaskScheduler`;

Alternatively, injected `TaskScheduler` works fine, try:

`$ ./mvnw clean spring-boot:run -Dspring-boot.run.profiles=working`

In this case `WorkingScheduler` is used.
