package src.estm_news

import src.estm_news.placeholder.ModuleData

class Personnel {
    var listEtudiant : ArrayList<Etudiant> = ArrayList()
    var listProfesseur : ArrayList<Professeur> = ArrayList()

    init {
        listEtudiant.add(Etudiant("1","M121314151","password1",ModuleData.modules1,ModuleData.modules_map1))
        listEtudiant.add(Etudiant("2","R121314151","password2",ModuleData.modules2,ModuleData.modules_map2))
        listEtudiant.add(Etudiant("3","F121314151","password3",ModuleData.modules3,ModuleData.modules_map3))
        listEtudiant.add(Etudiant("4","H121314151","password4",ModuleData.modules4,ModuleData.modules_map4))
        listEtudiant.add(Etudiant("5","J121314151","password5",ModuleData.modules5,ModuleData.modules_map5))

        listProfesseur.add(Professeur("1","prof1","password1",ModuleData.module1))
        listProfesseur.add(Professeur("2","prof2","password2",ModuleData.module2))
        listProfesseur.add(Professeur("3","prof3","password3",ModuleData.module3))
        listProfesseur.add(Professeur("4","prof4","password4",ModuleData.module4))
        listProfesseur.add(Professeur("5","prof5","password5",ModuleData.module5))
    }

    fun getEtudiant(cne : String, password : String) : Etudiant? {
        for(e in listEtudiant)
            if (e.cne.equals(cne) && e.password.equals(password))
                return e
        return null
    }
}