package com.app.remote.mapper

interface BaseRemoteMapper<in REMOTE, out ENTITY> {
    fun mapFromRemote(remoteObject:REMOTE):ENTITY
}