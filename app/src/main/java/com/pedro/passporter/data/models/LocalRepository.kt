package com.pedro.passporter.data.models

/**
 * Created by pedro on 1/4/22.
 *
 * Parse to a local variable with values used in app.
 */
data class LocalRepository(
  val id: Int,
  val name: String,
  val description: String,
  val loginOwner: String,
  val fork: Boolean,
  val htmlUrl: String,
  val htmlUrlOwner: String,
)