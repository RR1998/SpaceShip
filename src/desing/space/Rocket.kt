package desing.space

import desing.supplies.Items

class Rocket() : SpaceShip {
    var RocketModel: String = ""
    var RocketWeight: Int = 0
    var MaxWeight: Int = 0
    var CargoCarried: Int? = 0
    var chanceLaunchExplosion: Double? = 0.00
    var chanceLandingCrash: Double?  = 0.00
    var statusLaunch: Boolean? = false
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }
    override fun canCarry(Item: Items): Boolean {
        return Item.Weight <= MaxWeight
    }

    override fun carry(Item: Items): Int? {

        return 0
    }

    fun crashExplosionChance(RocketModel: String, CargoCarried: Int, CargoLimit: Int){
        when(RocketModel){
            "U-1" -> {
                this.chanceLaunchExplosion = (0.05 * cargoPercentage (CargoCarried, CargoLimit))
                this.chanceLandingCrash = (0.01 * cargoPercentage (CargoCarried, CargoLimit))
            }
            "U-2" ->{
                this.chanceLaunchExplosion = (0.04 * cargoPercentage (CargoCarried, CargoLimit))
                this.chanceLandingCrash = (0.08 * cargoPercentage (CargoCarried, CargoLimit))
            }
        }
    }
    private fun cargoPercentage(CargoCarried: Int, CargoLimit: Int): Double{
        return CargoCarried.toFloat() /CargoLimit.toDouble()
    }
    init {

    }
}
