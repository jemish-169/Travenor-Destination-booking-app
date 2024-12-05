package com.app.travenor.sample_data

fun Place.toDetailPlace(): DetailPlace {
    return DetailPlace(
        id = this.id,
        name = this.name,
        location = this.location,
        imageUrl = this.imageUrl,
        placeHolder = this.placeHolder,
        amount = this.amount.toString().dropLast(7),
        rating = this.rating,
    )
}