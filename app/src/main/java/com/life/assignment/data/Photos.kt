package com.life.assignment.data

import org.joda.time.LocalDate

/**
 * A data class that holds details about a Photo.
 *
 * @property id: String – A unique ID for each photo.
 * @property author: [Author] – Hotel object where the booking is made.
 * @property takenDate: [LocalDate] - Date of the picture taken.
 * @property imageUrl: String - url for downloading image.
 *
 */
data class Photos(
    val id: String,
    val author: Author,
    val takenDate: LocalDate,
    val imageUrl: String,
)

/**
 * Data class to hold details about a Author.
 *
 * @property id: String - A unique ID for each Author.
 * @property firstName: String - First Name of the Author.
 * @property lastName: String - Last Name of the Author.
 *
 */
data class Author(
    val id: Int,
    val firstName: String,
    val lastName: String
)