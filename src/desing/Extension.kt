package desing

import desing.space.Rocket

fun Rocket.shield(Rocket: Rocket, count: Int): Rocket {
    if (count.rem(3) == 0 && count != 0) {
      Rocket.chanceLaunchExplosion = 0.0
      Rocket.chanceLandingCrash = 0.0
    }
    return Rocket
}
