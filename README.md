Java Deck of Cards Rest Service
===============================
This project is a Rest Service for Deck of Cards. The goal of the library is provide a the principal funtionalities of deck of cards by rest.


## Technologies used
* Java
* Maven
* Spring Boot

## Packages
The library only contain 1 package

## (org.allecuona.deckofcards)
This package contanin all the interface, enum and class of the Service

## Examples

### Create a Deck of Card
uri: http://localhost:8080/deck  
method: POST  
Content-Type: application/json  
Json: "UsingStack" or "UsingList"

### Get an especif Deck of Card
uri: http://localhost:8080/deck/{id}  
method: GET

### Remove an especif Deck of Card
uri: http://localhost:8080/deck/{id}  
method: DELETE

### Shuffle the deck
uri: http://localhost:8080/deck/{id}/shuffle  
method: GET

### Get a first card from deck
http://localhost:8080/deck/{id}/firstcards  
method: GET

### Get a first card from deck
http://localhost:8080/deck/{id}/lastcards  
method: GET

### Reset the deck
uri: http://localhost:8080/deck/{id}/reset  
method: GET

### Total card in the deck
uri: http://localhost:8080/deck/{id}/cards  
method: GET

### Exist card in the deck
uri: http://localhost:8080/deck/{id}/card  
method: GET

### Run
* git clone https://github.com/angelcubano/deckofcardrestservice
* cd DeckOfCardsRestService
* mvn clean install
* mvn spring-boot:run
