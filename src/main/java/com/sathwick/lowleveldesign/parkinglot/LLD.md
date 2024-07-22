# Designing Parking Lot System

# System Requirements

- PL can have multiple floors where customers can park
- Can have multiple entry and exit gates 
- Customer collect entry ticket from any gate and can pay at any exit gate
- Customer should be able to pay in multiple modes for the parking services
- There should be parking spot allocation service, if system is full - shouldn't allow new vehicles to park
- Parking spots can be 2 wheeler, Compact, Large, Handicapped, SUV, EV.

# HLD

On a high level there will be following services ---> Interact with vehicle parking database
1. Parking Service
   1. Generates parking tickets
   2. Does parking allocation
   3. Display free spots
2. Payment Service ----> Payment Details DB
3. Parking Management Service ----> Interacts with Parking Database
   1. Add/removes parking spots
   2. Add/removes parking floors
   3. Add/removes entry and exit gates

# LLD

## Entities

1. Vehicle
2. ParkingSpot
3. ParkingFloor
4. ParkingTicket
5. EntranceGate
6. ExitGate
7. Payment

## Database interactions

Vehicle 1 - 1 ParkingSpot
Parking Spot * - 1 Parking Floor
Parking Floor 1 - * Gate (Inheritance Mapping)
