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


    var module1 = Module("1","Module_BD","Module de bases de données","Pr.Ghanou",12,15,12)
    var module2 = Module("2","Module_RI","Module des réseaux informatiques","Pr.Rhattoy",6,12,14)
    var module3 = Module("3","Module_POO","Module de programation orienté objet","Pr.Ouazzani",6,14,18)
    var module4 = Module("4","Module_DM","Module de développement mobile","Pr.Ait el mouden",6,16,13)
    var module5 = Module("5","Module_ECO","Module d'économie","Pr.Ait el mouden",6,16,13)
    var module6 = Module("6","Module_ORGA","Module d'organisation des entreprises","Pr.Ghanou",12,15,12)
    var module7 = Module("7","Module_ANG","Module d'anglais","Pr.Rhattoy",6,12,14)
    var module8 = Module("8","Module_TEC","Module des techniques d'expression et de communication","Pr.Ouazzani",6,14,18)
    var module9 = Module("9","Module_AO","Module d'architecture des ordinateurs","Pr.Ait el mouden",6,16,13)
    var module10 = Module("10","Module_COMPT","Module de comptabilité","Pr.Ait el mouden",6,16,13)
    var module11 = Module("11","Module_AI","Module de intelligence artificielle","Pr.Ghanou",12,15,12)
    var module12 = Module("12","Module_DA","Module d'analyses des données","Pr.Rhattoy",6,12,14)
    var module13 = Module("13","Module_ML","Module de machine learning","Pr.Ouazzani",6,14,18)
    var module14 = Module("14","Module_DL","Module de deep learning","Pr.Ait el mouden",6,16,13)

    init {
        // Add some sample items.
        addModule(module1)
        addModule(module2)
        addModule(module3)
        addModule(module4)
        addModule(module5)

        modules2.add(module11)
        modules2.add(module12)
        modules2.add(module13)
        modules2.add(module14)

        modules_map2.put(module11.id,module11)
        modules_map2.put(module12.id,module12)
        modules_map2.put(module13.id,module13)
        modules_map2.put(module14.id,module14)

        modules3.add(module6)
        modules3.add(module7)
        modules3.add(module8)
        modules3.add(module9)
        modules3.add(module10)

        modules_map3.put(module6.id,module6)
        modules_map3.put(module7.id,module7)
        modules_map3.put(module8.id,module8)
        modules_map3.put(module9.id,module9)
        modules_map3.put(module10.id,module10)

    }

    private fun addModule(module: Module) {
        modules1.add(module)
        modules_map1.put(module.id, module)
    }

    data class Module(val id: String, val nom_module: String, val description : String, val prof : String, val duree : Int, val note_cours:Int,val note_tp:Int) {
        override fun toString(): String = nom_module
    }

}