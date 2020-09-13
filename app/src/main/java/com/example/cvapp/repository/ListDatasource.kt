package com.example.cvapp.repository

import com.example.cvapp.domains.User
import java.lang.Exception

object ListDatasource : UserDatasource {
    private var storage: MutableList<User> = mutableListOf()

    override fun save(user: User): String? {
        return try {
            if(!storage.contains(user)) {
                storage.add(user)
                user.userId.toString()
            } else null
        } catch (e: Exception) {
            "Couldn't save Device"
        }
    }

    override fun find(id: String): User? {
        storage.forEach { when (it.userId.toString()) { id -> return it } }
        return null
    }

    override fun edit(user: User): String {
        TODO("Not yet implemented")
    }

    override fun delete(user: User): String {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<User> {
        return this.storage
    }
}