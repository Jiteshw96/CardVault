package com.app.data.mapper.entitymapper

interface BaseEntityMapper<in ENTITY, out MODEL> {
    fun mapFromEntity(remoteObject: ENTITY): MODEL
}