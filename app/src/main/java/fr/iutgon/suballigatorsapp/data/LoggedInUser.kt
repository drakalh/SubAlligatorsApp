package fr.iutgon.suballigatorsapp.data

import fr.iutgon.suballigatorsapp.data.entities.Initiator

class LoggedInUser {
    var initiator: Initiator? = null

    companion object {
        private var instance: LoggedInUser? = null

        fun getInstance(): LoggedInUser {
            if (instance == null) {
                instance = LoggedInUser()
            }
            return instance!!
        }
    }
}