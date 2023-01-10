package com.life.assignment.repository

import com.life.assignment.data.Author
import com.life.assignment.data.Photos
import org.joda.time.LocalDate

/**
 * Test cases for different scenarios that we encounter in day to day work.
 * You can use these different test cases to evaluate your algorithm to build photos chains.
 *
 * Each test case has a corresponding testId which you can use to get photos data.
 */
enum class TestCase(val testName: String, val testId: Int) {
    NO_PHOTO("No photo", 99999),
    ONE_PHOTO("1 Photo", 178374),
    THIRTY_PHOTO("30 photo", 7298)
}

object MockDataGenerator {

    fun photos(id: Int): List<Photos>? {
        val case = TestCase.values().firstOrNull { it.testId == id } ?: return null
        return photos(case)
    }

    private fun photos(case: TestCase): List<Photos> {
        val photos: List<Photos>


        when (case) {
            TestCase.NO_PHOTO -> photos = emptyList()
            TestCase.ONE_PHOTO -> {
                photos = listOf(
                    buildPhoto(
                        author = AuthorEnum.Alejandro.build(),
                        days = -35,
                        imageUrl = AuthorEnum.Alejandro.imageUrl()[0]
                    )
                )
            }
            TestCase.THIRTY_PHOTO ->
                photos = buildPhotosByAuthor(AuthorEnum.Alejandro) +
                        buildPhotosByAuthor(AuthorEnum.Paul) +
                        buildPhotosByAuthor(AuthorEnum.Aleks) +
                        buildPhotosByAuthor(AuthorEnum.Vadim) +
                        buildPhotosByAuthor(AuthorEnum.Yoni) +
                        buildPhotosByAuthor(AuthorEnum.Jerry) +
                        buildPhotosByAuthor(AuthorEnum.John)
        }

        return photos.shuffled()
    }
}

private fun buildPhoto(author: Author, days: Int, imageUrl: String): Photos {
    val id = "${author.id}-$days"
    val today = LocalDate.now()

    val takenDate = today.plusDays(days)

    return Photos(
        id = id,
        author = author,
        takenDate = takenDate,
        imageUrl = imageUrl
    )
}

private fun buildPhotosByAuthor(author: AuthorEnum): List<Photos> {
    return listOf(
        buildPhoto(
            author = author.build(),
            days = -(30..40 ).random(),
            imageUrl = author.imageUrl()[0]
        ),

        buildPhoto(
            author = author.build(),
            days = -(60..70 ).random(),
            imageUrl = author.imageUrl()[1]
        ),

        buildPhoto(
            author = author.build(),
            days = -(90..100 ).random(),
            imageUrl = author.imageUrl()[2]
        ),

        buildPhoto(
            author = author.build(),
            days = -(120..130 ).random(),
            imageUrl = author.imageUrl()[3]
        ),
    )
}



