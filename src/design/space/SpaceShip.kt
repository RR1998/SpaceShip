package design.space

import design.supplies.Items

/**
 * interface where its declared every base function to Rocket
 */
interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(Item: Items): Boolean//Item = Item to add to carry capacity, Capacity left to the rocket
    fun carry(Item: Items)//Loads the item to the cargo ship
}