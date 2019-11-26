package desing

import desing.space.Rocket

fun main(){
    val R1 = Rocket()
    R1.RocketModel = "U-1"
    R1.crashExplosionChance(R1.RocketModel, 11000, 18000)
    print(R1.chanceLandingCrash)
}
