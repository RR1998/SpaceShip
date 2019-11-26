package Desing

class Rocket(RocketModel: String,RocketCost: Float, RocketWeight: Int, MaxWeight: Int, CargoCarried: Int?, CargoLimit: Int) : SpaceShip {
    var ChanceLaunchExplosion: Float?  = null
    var ChanceLandingCrash: Float?  = null
    var StatusLaunch: Boolean? = false
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }
    private fun ExplosionChance(RocketModel: String, CargoCarried: Int?, CargoLimit: Int){
        when(RocketModel){
            "U-1" -> ChanceLaunchExplosion = (0.05 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
            "U-2" -> ChanceLaunchExplosion = (0.04 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
        }
    }
    private fun CrashChance(RocketModel: String, CargoCarried: Int?, CargoLimit: Int){
        when(RocketModel){
            "U-1" -> ChanceLandingCrash = (0.01 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
            "U-2" -> ChanceLandingCrash = (0.08 * CargoCarried!!.toFloat() /CargoLimit.toFloat()).toFloat()
        }
    }
    init {

    }
}
