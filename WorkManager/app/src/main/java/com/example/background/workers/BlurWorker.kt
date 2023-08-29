package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.background.R

class BlurWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    /* doWork : 백그라운드에서 실행하고 싶은 실제 코드 */
    override fun doWork(): Result {
        /* Bitmap 작업때 필요함 */
        val appContext = applicationContext

        /* Start Notification */
        makeStatusNotification("Blurring image", appContext)

        return try {
            /* Image -> Bitmap */
            val picture = BitmapFactory.decodeResource(
                appContext.resources,
                R.drawable.android_cupcake)

            /* 실제 블러처리하는 과정 */
            val output /* : Bitmap */ = blurBitmap(picture, appContext)

            /* 비트맵을 임시파일에 저장 */
            val outputUri = writeBitmapToFile(appContext, output)

            /* Finish Notification */
            makeStatusNotification("Blurring image", appContext)

            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }

    }


}