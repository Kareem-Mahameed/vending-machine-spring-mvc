#  vending-machine-spring-mvc
vending-machine-spring-mvc project.

Design and code a vending machine that satisfies the following diagram.
Vending Machine
USER INPUTS :
Coin Input 5, 10, 25
Key in ID of Selection
Make Selection
Abort (reset)- Return balance of funds

DISPLAY OUTPUTS:
Display Running Total
Dispense Status (success or failure) Return balance of funds
InventoryDisplay

The vending machine must do the following:
1. The vending machine accepts only the following coin denominations: nickels, dimes or
quarters. Assign unique character key to represent each coin input denomination. Assign
a special key to simulate the valid entry of a coin into the system.
2. As coins are entered, a running total is displayed on the screen.
3. The vending machine contains the following inventory:
 Item 1 which costs 55 cents
 Item 2 which costs 70 cents
 Item 3 which costs 75 cents
 Each item begins with an inventory count of 10.
4. Display inventory information; what items it contains, the prices for said items, and the
count for each item.
5. If the user has not inserted sufficient funds and intends to purchase an item, the system
should alert the user and return the coins inserted.
6. You can limit the total funds that the system can take in at a time to be 1 dollars.
7. The system should have a “coin return” key that will return all inserted funds and reset
the vending machine.
