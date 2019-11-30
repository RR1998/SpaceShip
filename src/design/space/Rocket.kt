package design.space

import design.supplies.Items

/**
 * the class rocket it's composed by all the core items and functions that will have U1 and U2
 * it have the functions to calculate the crash and explosion chances also percentage of the load loaded
 */
open class Rocket : SpaceShip {
    //Rocket, structure that takes to U-1 and U-2 classes
    var rocketModel: String = "" //Rocket Model
    var rocketCost: Int = 0 //Rocket Cost in billions
    var rocketWeight: Int = 0 //Rocket weight + Items, weight in kilograms
    var maxWeight: Int = 0 //Max Weight
    var chanceLaunchExplosion: Double = 0.00 //Chance of accident in launch
    var chanceLandingCrash: Double = 0.00 //Chance of accident in landing
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(Item: Items): Boolean {
        return rocketWeight + Item.Weight <= maxWeight
    }

    override fun carry(Item: Items) {
        rocketWeight += Item.Weight
    }

    /**
     * crashExplosionChanceSelection is used to know the chances of explosion and crash from a rocket using
     * it model, cargo carried and cargo limit
     */
    fun crashExplosionChanceSelection(
        RocketModel: String,
        CargoCarried: Int,
        CargoLimit: Int
    ) {
        when (RocketModel) {
            "U-1" -> {
                chanceLaunchExplosion = explosionCrashChance(
                    ROCKET_DEFAULT_EXPLOSION_CHANCE_ONE,
                    cargoPercentage(CargoCarried, CargoLimit)
                )
                chanceLandingCrash = explosionCrashChance(ROCKET_DEFAULT_CRASH_CHANCE_ONE,
                    cargoPercentage(CargoCarried, CargoLimit))
            }
            "U-2" -> {
                chanceLaunchExplosion = explosionCrashChance(ROCKET_DEFAULT_EXPLOSION_CHANCE_TWO,
                    cargoPercentage(CargoCarried, CargoLimit))
                chanceLandingCrash = explosionCrashChance(ROCKET_DEFAULT_CRASH_CHANCE_TWO,
                    cargoPercentage(CargoCarried, CargoLimit))
            }
            else -> {
                chanceLaunchExplosion = ACCIDENT_CHANCE_SHIELDED
                chanceLandingCrash = ACCIDENT_CHANCE_SHIELDED
            }
        }
    }

    /**
     *explosionCrashChance receive the variables about a constant variable
     * for explosion and the cargo complete percentage
     *
     */
    private fun explosionCrashChance(
        explosionVariable: Double,
        Percentage: Double
    ): Double {
        return explosionVariable * Percentage
    }

    /**
     * cargoPercentage receive CargoCarried and Cargo limit to calculate
     * the loaded percentage and return it
     */
    private fun cargoPercentage(
        CargoCarried: Int,
        CargoLimit: Int
    ): Double {//Function to calculate how percentage of the cargo cap is used
        return CargoCarried.toFloat() / CargoLimit.toDouble()
    }

    /**
     * rocketCosWeightSet sets the cost, and initial weight of a rocket based in it model
     */

    private fun rocketCostWeightSet() {
        when (rocketModel) {
            IDENTIFIER_ROCKET_TYPE_ONE -> {
                rocketCost = ROCKET_DEFAULT_COST_ONE
                rocketWeight = ROCKET_DEFAULT_WEIGHT_ONE
                maxWeight = ROCKET_DEFAULT_MAX_WEIGHT_ONE
            }
            IDENTIFIER_ROCKET_TYPE_TWO -> {
                rocketCost = ROCKET_DEFAULT_COST_TWO
                rocketWeight = ROCKET_DEFAULT_WEIGHT_TWO
                maxWeight = ROCKET_DEFAULT_MAX_WEIGHT_TWO
            }
        }
    }

    fun generateRocket(RocketModel: String) {
        rocketModel = RocketModel
        rocketCostWeightSet()
    }

    /**
     * Companion object where are the defaults values for the rockets
     */

    companion object {
        const val IDENTIFIER_ROCKET_TYPE_ONE = "U-1"
        const val IDENTIFIER_ROCKET_TYPE_TWO = "U-2"
        const val ROCKET_DEFAULT_COST_ONE = 100
        const val ROCKET_DEFAULT_COST_TWO = 120
        const val ROCKET_DEFAULT_WEIGHT_ONE = 10000
        const val ROCKET_DEFAULT_WEIGHT_TWO = 18000
        const val ROCKET_DEFAULT_MAX_WEIGHT_ONE = 18000
        const val ROCKET_DEFAULT_MAX_WEIGHT_TWO = 29000
        const val ROCKET_DEFAULT_EXPLOSION_CHANCE_ONE = 0.05
        const val ROCKET_DEFAULT_EXPLOSION_CHANCE_TWO = 0.04
        const val ROCKET_DEFAULT_CRASH_CHANCE_ONE = 0.01
        const val ROCKET_DEFAULT_CRASH_CHANCE_TWO = 0.08
        const val ACCIDENT_CHANCE_SHIELDED = 0.00
    }
}
