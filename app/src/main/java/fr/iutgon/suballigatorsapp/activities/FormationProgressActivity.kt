package fr.iutgon.suballigatorsapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.tooling.preview.Preview
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser

class FormationProgressActivity(val id: Int) : ComponentActivity() {
    companion object {
        lateinit var bdd: MutableState<AppBDD>
        val user = LoggedInUser.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdd = AppBDD.getInstance(this)
        setContent()
        {
            Page()
        }
    }

    @Composable
    fun Page()
    {
        Column()
        {
            Row()
            {
                Text("Seance")
                for(skill in user.initiator?.let { bdd.value.skillDAO().getByLevelId(bdd.value.formationDAO().getById(id).levelId) }!!)
                {
                    for (aptitude in user.initiator?.let { bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                    {
                        Text(skill.name)
                    }
                }
            }
            Row()
            {
                Text("Seance")
                for(skill in user.initiator?.let { bdd.value.skillDAO().getByLevelId(bdd.value.formationDAO().getById(id).levelId) }!!)
                {
                    for (aptitude in user.initiator?.let { bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                    {
                        Text(aptitude.name)
                    }
                }
            }
        }
        for(session in user.initiator?.let { bdd.value.sessionDAO().getByFormationId(id) }!!)
        {
            Column()
            {
                for(student in user.initiator?.let { bdd.value.studentDAO().getByFormationId(id) }!!)
                {
                    Row()
                    {
                        Text(student.name)
                        for(skill in user.initiator?.let { bdd.value.skillDAO().getByLevelId(bdd.value.formationDAO().getById(id).levelId) }!!)
                        {
                            for (aptitude in user.initiator?.let { bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                            {
                                Text("Non évalué")
                            }
                        }
                    }
                }
            }
        }
    }
}