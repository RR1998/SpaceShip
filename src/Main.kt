import desing.space.U1

fun main(){
    val r1 = U1()
    r1.rocketModel = "U-1"
    r1.crashExplosionChanceSelection(r1.rocketModel, 11000, 18000)
    print(r1.chanceLandingCrash)
}
