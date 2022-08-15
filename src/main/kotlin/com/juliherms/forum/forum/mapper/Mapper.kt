package com.juliherms.forum.forum.mapper

interface Mapper<T, U> {
    fun map(t:T): U
}
