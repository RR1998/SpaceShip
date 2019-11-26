package Desing

interface SpaceShip {
    fun launch():Boolean{
        return true
    }
    fun land(): Boolean {
        return true
    }
    fun CanCarry(Weigth: Int, Capacity: Int):Boolean{
        return Weigth <= Capacity
    }
    fun Carry(Carry: Int, NewItem: Int): Int{
        return Carry + NewItem
    }
}