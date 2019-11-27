package simulation

import desing.space.Rocket
import desing.space.U1
import desing.space.U2
import desing.supplies.Items
import java.io.File

class Simulation {
    init {
    }

    private fun loadItems(): ArrayList<Items> {
        var aux: Array<String>
        val itemsList = ArrayList<Items>()
        val pathAux: String = System.getProperty("user.dir").toString()
        for (i in 1..2) {
            File("$pathAux\\src\\Simulation\\Phases\\Phase-$i.txt").forEachLine {
                aux = it.split("=").toTypedArray()
                itemsList.add(Items(aux[1].toInt()))
            }
        }
        return itemsList
    }

    fun loadU1(): ArrayList<Rocket> {
        return load("U-1")
    }

    fun loadU2(): ArrayList<Rocket> {
        return load("U-2")
    }

    private fun load(rocketModel: String): ArrayList<Rocket> {
        val itemsList = loadItems()
        val rocketList: ArrayList<Rocket> = ArrayList()
        var flag = true
        var count = 0
        var rocketToLoad = Rocket()
        while (flag) {
            if (rocketModel == "U-1") {
                rocketToLoad = U1()//Rocket variable]
                rocketToLoad.generateRocket(rocketModel)//Generate a rocket
            }
            if (rocketModel == "U-2") {
                rocketToLoad = U2()//Rocket variable]
                rocketToLoad.generateRocket(rocketModel)//Generate a rocket
            }
            itemsList.forEach { item ->
                //For that fills the rockets
                if (rocketToLoad.canCarry(item) && item.status) {
                    item.status = false
                    rocketToLoad.carry(item)
                    count++
                }
            }
            rocketToLoad.crashExplosionChanceSelection(
                rocketToLoad.rocketModel,
                rocketToLoad.rocketWeight,
                rocketToLoad.maxWeight
            )
            rocketList.add(rocketToLoad)
            if (count == itemsList.size) {
                flag = false
            }
        }
        return rocketList
    }

    fun runSimulation(ArrayRockets: ArrayList<Rocket>): Int {
        val totalBudget: Int
        var count = 0
        val rocketCost: Int = ArrayRockets[0].rocketCost
        ArrayRockets.forEach { RocketLaunched ->
            while (RocketLaunched.launch() && RocketLaunched.land()) {
                count++
            }
            count++
        }
        totalBudget = rocketCost * count
        return totalBudget
    }
}