package simulation

import desing.space.Rocket
import desing.space.U1
import desing.space.U2
import desing.supplies.Items
import java.io.File

/**
 *Class simulation designed to create the simulation
 */

class Simulation {
    /**
     * loadItems functions execute the process of read the text files that have the items to load
     */
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

    /**
     * loadU1 and loadU2 send the rocket model to load
     */
    fun loadU1(): ArrayList<Rocket> {
        return load("U-1")
    }

    fun loadU2(): ArrayList<Rocket> {
        return load("U-2")
    }

    /**
     * load function create a rocket variable then iterates the array of items and add mutch the add the rocket to an array list of rockets until there's
     * no more items and returns an array list with the rockets launched
     */
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

    /**
     * runSimulation executes the simulation with the array of rockets
     */
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