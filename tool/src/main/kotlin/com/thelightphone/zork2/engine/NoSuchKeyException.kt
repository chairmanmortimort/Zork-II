package com.thelightphone.zork2.engine

internal class NoSuchKeyException : Exception {
    constructor() : super()
    constructor(s: String) : super(s)
}
