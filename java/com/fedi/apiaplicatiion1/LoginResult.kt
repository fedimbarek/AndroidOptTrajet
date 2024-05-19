/*package com.fedi.apiaplicatiion1

import java.io.Serializable

data class LoginResult (
    val nom: String,
    val email: String,
        ):Serializable*/
package com.fedi.apiaplicatiion1

import java.io.Serializable

data class LoginResult (
    val _id: String?,
    val nom: String,
    val prenom: String?,
    val cin: String?,
    val email: String?,
    val password: String,
    val role: String,
    val telephone: String,
    val picture: String?,
): Serializable
