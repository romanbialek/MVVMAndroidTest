package com.romanbialek.mvvmtest.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.Timestamp


object Utils {

    @JvmStatic
    fun generateAuthHash(publicKey: String, privateKey: String, timeStamp: String): String {
        val input = timeStamp + privateKey + publicKey
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}