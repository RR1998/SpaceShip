package Simulation

import desing.supplies.Items
import java.io.BufferedReader
import java.io.File

class Simulation {
    fun loadItems(){
        var aux: Array<String>
        val itemsList = ArrayList<Items>()
        val PathAux: String = System.getProperty("user.dir").toString()
        File("$PathAux\\src\\src\\Simulation\\Phases\\Phase-1.txt").forEachLine {
            aux = it.split("=").toTypedArray()
            itemsList.add(Items(aux[0],aux[1].toInt()))
        }
        File("$PathAux\\src\\Simulation\\Phases\\Phase-2.txt").forEachLine {
            aux = it.split("=").toTypedArray()
            itemsList.add(Items(aux[0],aux[1].toInt()))
        }
    }
}