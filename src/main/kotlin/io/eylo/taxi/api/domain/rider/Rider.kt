package io.eylo.taxi.api.domain.rider

import io.eylo.taxi.api.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "rider")
class Rider : BaseEntity()
