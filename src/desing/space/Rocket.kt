package desing.space

import desing.Supplies.Items

class Rocket(RocketModel: String,RocketCost: Float, RocketWeight: Int, MaxWeight: Int, CargoCarried: Int?, CargoLimit: Int) : SpaceShip {

    var chanceLaunchExplosion: Float?  = null
    var chanceLandingCrash: Float?  = null
    var statusLaunch: Boolean? = false
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }
    override fun canCarry(Item: Items): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun carry(Item: Items): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    private fun explosionChance(RocketModel: String, CargoCarried: Int?, CargoLimit: Int){
        when(RocketModel){
            "U-1" -> chanceLaunchExplosion = (0.05 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
            "U-2" -> chanceLaunchExplosion = (0.04 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
        }
    }
    private fun crashChance(RocketModel: String, CargoCarried: Int?, CargoLimit: Int){
        when(RocketModel){
            "U-1" -> chanceLandingCrash = (0.01 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
            "U-2" -> chanceLandingCrash = (0.08 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
        }
    }
    init {

    }
}
