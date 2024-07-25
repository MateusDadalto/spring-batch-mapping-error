# Batch Error Handling Project

## Overview

This project demonstrates that BatchProcessing resolver is called N times when resolving a mutation result instead of
just once.

## Technologies Used

- Java
- Spring Boot
- Spring GraphQL
- Maven

## Getting Started

### Prerequisites

- Java 17
- Maven 3.6.0

### Building the Project

To build the project, run the following command:

```sh
mvn clean install
```

The test `saveManyMutationShouldCallFooServiceOnce` will fail demonstrating that there is a bug with 
spring @BatchMapping for mutations 