package fr.iutgon.suballigatorsapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import fr.iutgon.suballigatorsapp.data.LoggedInUser

class SessionEvaluationActivity(val id:Int) : ComponentActivity()
{

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Composable
    fun Page()
    {
        var expanded by remember {
            mutableStateOf(false)
        }
        Column()
        {
            Row()
            {
                Text("Seance")
                for(skill in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.skillDAO().getByLevelId(
                    FormationProgressActivity.bdd.value.formationDAO().getById(id).levelId) }!!)
                {
                    for (aptitude in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                    {
                        Text(skill.name)
                    }
                }
            }
            Row()
            {
                Text("Seance")
                for(skill in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.skillDAO().getByLevelId(
                    FormationProgressActivity.bdd.value.formationDAO().getById(id).levelId) }!!)
                {
                    for (aptitude in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                    {
                        Text(aptitude.name)
                    }
                }
            }
        }
        for(session in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.sessionDAO().getByFormationId(id) }!!)
        {
            Column()
            {
                for(student in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.studentDAO().getByFormationId(id) }!!)
                {
                    Row()
                    {
                        Text(student.name)
                        for(skill in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.skillDAO().getByLevelId(
                            FormationProgressActivity.bdd.value.formationDAO().getById(id).levelId) }!!)
                        {
                            for (aptitude in FormationProgressActivity.user.initiator?.let { FormationProgressActivity.bdd.value.aptitudeDAO().getBySkillId(skill.id) }!!)
                            {
                                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                    DropdownMenuItem(onClick = { expanded = false }) {
                                        Text("Absent")
                                    }
                                    DropdownMenuItem(onClick = { expanded = false }) {
                                        Text("En cours")
                                    }
                                    DropdownMenuItem(onClick = { expanded = false }) {
                                        Text("Acquis")
                                    }
                                    DropdownMenuItem(onClick = { expanded = false }) {
                                        Text("Non-évalué")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}