package com.pedro.passporter.utils

import com.pedro.passporter.data.api.models.Repository
import com.pedro.passporter.data.models.LocalRepository

/**
 * Created by pedro on 1/4/22.
 */

fun Repository.toLocalRepository(): LocalRepository {
  val description = this.description ?: "No description provided"
  return LocalRepository(this.id, this.name, description, this.owner.login, this.fork, this.html_url, this.owner.html_url)
}