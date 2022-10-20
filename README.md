# A2

Project for Assignment 2

A project template based on gradle and a gitlab pipeline. You should always build and run the application using gradle regularely.

[design.md](design.md) contains the prescribed architectural design of the application.

## Contributors

Fredrik Eriksson, ferth09@student.lnu.se <br> 
Farzad Fahiminia, ff222cb@student.lnu.se <br> 
Therese Grass, tg222kv@student.lnu.se

## Usage

This application is a Blackjack game which have been altered and built upon according to the course guidelines. The game is basically played as a classic Blackjack; a dealer and a player draw cards and whoever gets closest (but not over) 21 wins the game. 

An operation has been implemented, stand in the Game class, which makes the game playable. Hidden and unnecessary dependencies have been removed, as well as duplicated code. Different rules have been implemented to, in a simple way, create a possibility to switch between rules that rules different winners if the player and the dealer have equal score. 

The Blackjack rule, Soft 17, is incorporated in the game, which basically means that if a dealer has a combination of Ace and 6 (i.e., 17) they can change the Ace value to 1 and ask for another card. The Observer pattern is used to briefly paus the game to give it a bit of an edge.

## Building

The build must pass by running console command:  
`./gradlew build`

## Running

The application should start by running console command:  
`./gradlew run -q --console=plain`

## Versioning

Adhere to the git versioning instructions according to the assignment.

## System test

Adhere to the instructions according to the assigment.

## Handing In

Adhere to the instructions according to the assigment.