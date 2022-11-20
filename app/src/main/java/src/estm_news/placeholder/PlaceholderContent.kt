package src.estm_news.placeholder

import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent {

    val modules: MutableList<Module> = ArrayList()
    val modules_map: MutableMap<String, Module> = HashMap()


    init {
        // Add some sample items.
        addModule(Module("1","Module_BD","Module de bases de données","Pr.Ghanou",12,15,12))
        addModule(Module("2","Module_RI","Module des réseaux informatiques","Pr.Rhattoy",6,12,14))
        addModule(Module("3","Module_POO","Module de programation orienté objet","Pr.Ouazzani",6,14,18))
        addModule(Module("4","Module_DM","Module de développement mobile","Pr.Ait el mouden",6,16,13))
    }

    private fun addModule(module: Module) {
        modules.add(module)
        modules_map.put(module.id, module)
    }

    data class Module(val id: String, val nom_module: String, val description : String, val prof : String, val duree : Int, val note_cours:Int,val note_tp:Int) {
        override fun toString(): String = nom_module
    }

}