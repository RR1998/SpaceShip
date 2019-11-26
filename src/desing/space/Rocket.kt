package desing.space

import desing.supplies.Items

open class Rocket : SpaceShip {//Rocket, structure that takes to U-1 and U-2 classes
    var rocketModel: String = "" //Rocket Model
    var rocketCost: Int = 0 //Rocket Cost
    private var rocketWeight: Int = 0 //Rocket weight + Items
    private var maxWeight: Int = 0 //Max Weight
    var chanceLaunchExplosion: Double = 0.00 //Chance of accident in launch
    var chanceLandingCrash: Double  = 0.00 //Chance of accident in landing
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }
    override fun canCarry(Item: Items): Boolean {
        return rocketWeight + Item.Weight <= maxWeight
    }

    override fun carry(Item: Items): Int? {

        return 0
    }

    fun crashExplosionChanceSelection(RocketModel: String, CargoCarried: Int, CargoLimit: Int){//Function to choose the rocket chance of explode or crash
        when(RocketModel){//View witch model is going to be used to calculate the chance
            "U-1" -> {
                chanceLaunchExplosion = explosionCrashChance(0.05, cargoPercentage (CargoCarried, CargoLimit))
                chanceLandingCrash = explosionCrashChance(0.01, cargoPercentage (CargoCarried, CargoLimit))
            }
            "U-2" ->{
                chanceLaunchExplosion = explosionCrashChance(0.04, cargoPercentage (CargoCarried, CargoLimit))
                chanceLandingCrash = explosionCrashChance(0.08, cargoPercentage (CargoCarried, CargoLimit))
            }
        }
    }
    private fun explosionCrashChance(explosionVariable: Double, Percentage: Double): Double{//Calculates the chance of explode or crash from the rocket
        return explosionVariable * Percentage
    }
    private fun cargoPercentage(CargoCarried: Int, CargoLimit: Int): Double{//Function to calculate how percentage of the cargo cap is used
        return CargoCarried.toFloat() /CargoLimit.toDouble()
    }
    init {

    }
}
