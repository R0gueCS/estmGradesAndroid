package src.estm_news.placeholder

import java.util.HashMap
import kotlin.collections.ArrayList

object ModuleData {


    val modules1: MutableList<Module> = ArrayList()
    val modules_map1: MutableMap<String, Module> = HashMap()
    val modules2: MutableList<Module> = ArrayList()
    val modules_map2: MutableMap<String, Module> = HashMap()
    val modules3: MutableList<Module> = ArrayList()
    val modules_map3: MutableMap<String, Module> = HashMap()
    val modules4: MutableList<Module> = ArrayList()
    val modules_map4: MutableMap<String, Module> = HashMap()
    val modules5: MutableList<Module> = ArrayList()
    val modules_map5: MutableMap<String, Module> = HashMap()


    var module1 = Module("1","Module_BD","Module de bases de données","Pr.Ghanou",12,15,12)
    var module2 = Module("2","Module_RI","Module des réseaux informatiques","Pr.Rhattoy",6,12,14)
    var module3 = Module("3","Module_POO","Module de programation orienté objet","Pr.Ouazzani",6,14,18)
    var module4 = Module("4","Module_DM","Module de développement mobile","Pr.Ait el mouden",6,16,13)
    var module5 = Module("4","Module_DM","Module de développement mobile","Pr.Ait el mouden",6,16,13)

    init {
        // Add some sample items.
        addModule(module1)
        addModule(module2)
        addModule(module3)
        addModule(module4)

        modules2.add(module1)
        modules2.add(module2)
        modules2.add(module3)
        modules2.add(module4)
        modules2.add(module5)

        modules_map2.put(module1.id,module1)
        modules_map2.put(module2.id,module2)
        modules_map2.put(module3.id,module3)
        modules_map2.put(module4.id,module4)
        modules_map2.put(module5.id,module5)

    }

    private fun addModule(module: Module) {
        modules1.add(module)
        modules_map1.put(module.id, module)
    }

    data class Module(val id: String, val nom_module: String, val description : String, val prof : String, val duree : Int, val note_cours:Int,val note_tp:Int) {
        override fun toString(): String = nom_module
    }

}