package com.thelightphone.zork2.engine

/** Thrown when an expected IFF chunk is missing (ported from Zplet). */
class IFFChunkNotFoundException : Exception {
    constructor() : super()
    constructor(s: String) : super(s)
}
