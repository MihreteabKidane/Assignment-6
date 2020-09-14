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
        for ((index, aUser) in storage.withIndex()) {
            when (aUser.userId) {
                user.userId -> {
                    storage[index] = user
                    return user.userId.toString()
                }
            }
        }
        return "Couldn't Edit Device"
    }

    override fun editBio(userId: String, text : String){
        for ((index, aUser) in storage.withIndex()) {
            when (aUser.userId.toString()) {
                userId -> {
                    storage[index].bio = text
                }
            }
        }
    }

    override fun delete(user: User): String {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<User> {
        return this.storage
    }

    override fun addAchievement(s: String, achievement: String) {
        for ((index, aUser) in storage.withIndex()) {
            when (aUser.userId.toString()) {
                s -> storage[index].achievements.add(achievement)
            }
        }
    }
}