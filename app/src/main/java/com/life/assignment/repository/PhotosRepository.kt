package com.life.assignment.repository

import android.os.Looper
import com.life.assignment.data.Photos
import com.life.assignment.utils.NetworkError
import com.life.assignment.utils.Result
import java.lang.RuntimeException
import javax.inject.Inject
import kotlin.random.Random

/**
 * An interface to represent a repository that returns a list of photos .
 */
interface PhotosRepository {
    /**
     * Returns list of photos.
     */
    fun fetchPhotos(): Result<List<Photos>>
}

/**
 *  An implementation for the repository which returns photos based on a generated dataset.
 */
class MockNetworkPhotosRepository @Inject constructor() : PhotosRepository {

    override fun fetchPhotos(): Result<List<Photos>> {
       /* if (Looper.myLooper() == Looper.getMainLooper()) {
            throw RuntimeException("fetchPhotos called on main thread!")
        }*/

        Thread.sleep(Random.nextInt(10, 2000).toLong())
        if (Random.nextInt(0, 21) % 10 == 0) {
            return Result.Error(NetworkError("API call error"))
        }

        val photos = MockDataGenerator.photos(TestCase.THIRTY_PHOTO.testId) ?: return Result.Error(NetworkError("API call error"))
        return Result.Success(photos)
    }
}