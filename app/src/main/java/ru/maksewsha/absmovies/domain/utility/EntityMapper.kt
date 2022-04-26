package ru.maksewsha.absmovies.domain.utility


//This interface enables us to map entities to objects and vice versa
//Generic of entity is T
//Generic of object is F

interface EntityMapper<T, F> {
    fun mapFromEntity(entity: F): T
    fun mapToEntity(objectToMap: T): F
}