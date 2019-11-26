package desing

import desing.space.U1

fun main(){
    val R1 = U1()
    R1.rocketModel = "U-1"
    R1.crashExplosionChanceSelection(R1.rocketModel, 11000, 18000)
    print(R1.chanceLandingCrash)
}
