package desing

import desing.space.Rocket

fun main(){
    val R1 = Rocket()
    R1.rocketModel = "U-1"
    R1.crashExplosionChanceSelection(R1.rocketModel, 11000, 18000)
    print(R1.chanceLandingCrash)
}
