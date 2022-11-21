package src.estm_news

import src.estm_news.placeholder.ModuleData

class Etudiant (val id:String, val cne : String, val password: String,
                val modulesList : MutableList<ModuleData.Module>,
                val moduleList_map : MutableMap<String, ModuleData.Module>
                ){}