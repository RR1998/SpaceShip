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
        for(i in 1..2){
            File("$pathAux\\src\\Simulation\\Phases\\Phase-$i.txt").forEachLine {
                aux = it.split("=").toTypedArray()
                itemsList.add(Items(aux[1].toInt()))
            }
        }

        return itemsList
    }

    fun loadU1(): ArrayList<Rocket> {
        val itemsList = loadItems()
        val rocketList: ArrayList<Rocket> = ArrayList()
        var flag = true
        var count = 0
        while (flag) {
            val r1 = U1()//Rocket variable
            r1.createRocket()//Generate a rocket
            itemsList.forEach { item ->
                //For that fills the rockets
                if (r1.canCarry(item) && item.status) {
                    item.status = false
                    r1.carry(item)
                    count++
                }
            }
            r1.crashExplosionChanceSelection(r1.rocketModel, r1.rocketWeight, r1.maxWeight)
            rocketList.add(r1)
            if (count == itemsList.size) {
                flag = false
            }
        }
        return rocketList
    }

    fun loadU2(): ArrayList<Rocket> {
        val itemsList = loadItems()
        val rocketList: ArrayList<Rocket> = ArrayList()
        var flag = true
        var count = 0
        while (flag) {
            val r2 = U2()//Rocket variable
            r2.createRocket()//Generate a rocket
            itemsList.forEach { item ->
                //For that fills the rockets
                if (r2.canCarry(item) && item.status) {
                    item.status = false
                    r2.carry(item)
                    count++
                }
            }
            r2.crashExplosionChanceSelection(r2.rocketModel, r2.rocketWeight, r2.maxWeight)
            rocketList.add(r2)
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
            while (!RocketLaunched.launch() && !RocketLaunched.land()) {
                count++
            }
            count++
            //println("launched $count")
        }
        totalBudget = rocketCost * count
        return totalBudget
    }
}