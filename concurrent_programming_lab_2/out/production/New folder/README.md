# Senate-Bus-Problem

This problem was originally based on the Senate bus at Wellesley College. Riders come to a bus stop and wait for a bus. When the bus arrives, all the waiting riders invoke boardBus, but anyone who arrives while the bus is boarding has to wait for the next bus. The capacity of the bus is 50 people; if there are more than 50 people waiting, some will have to wait for the next bus. When all the waiting riders have boarded, the bus can invoke depart. If the bus arrives when there are no riders, it should depart immediately.

1.Compile the Program:

`javac SenateBusProblem.java`

2.Run the Program:

`java SenateBusProblem`

3.Press `Enter` key at anytime to terminate the process.

Note:-
Buses and Riders are generated automatically at random intervals selected within pre-defined ranges of values.
For the Buses, minimum interval is 2500 milliseconds and maximum interval is 10000 milliseconds. The values can be changed manually in BusGenerator.java file.
For the Riders, minimum interval is 50 milliseconds and maximum interval is 250 milliseconds. The values can be changed manually in RiderGenerator.java file.
