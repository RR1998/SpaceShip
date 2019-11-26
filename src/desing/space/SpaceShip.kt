package desing.space

import desing.Supplies.Items

interface SpaceShip {
    fun launch() :Boolean
    fun land(): Boolean
    fun canCarry(Item: Items):Boolean//Item = Item to add to carry capacity, Capacity left to the rocket
        //var Capacity: Int = 0
      //  return Item.Weight!! <= Capacity
    //}
    fun carry(Item: Items): Int?
    //    var WeightAdded: Int? = 0
    //    return (Item.Weight?.plus(WeightAdded!!))
    //}
}