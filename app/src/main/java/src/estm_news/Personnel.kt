package src.estm_news

import src.estm_news.placeholder.ModuleData

class Personnel {
    var listEtudiant : ArrayList<Etudiant> = ArrayList()

    init {
        listEtudiant.add(Etudiant("1","M121314151","password1",ModuleData.modules1,ModuleData.modules_map1))
        listEtudiant.add(Etudiant("2","R121314151","password2",ModuleData.modules2,ModuleData.modules_map2))
        listEtudiant.add(Etudiant("3","F121314151","password3",ModuleData.modules3,ModuleData.modules_map3))

    }

    fun getEtudiant(cne : String) : Etudiant? {
        for(e in listEtudiant)
            if (e.cne.equals(cne) && e.password.equals(getPasswordByCne(cne)))
                return e
        return null
    }
    fun getPasswordByCne(cne : String) : String?{
        for(e in listEtudiant)
            if (e.cne.equals(cne))
                return e.password
        return null
    }
}