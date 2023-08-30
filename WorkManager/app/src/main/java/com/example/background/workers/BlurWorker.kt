package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.background.KEY_IMAGE_URI
import com.example.background.R

class BlurWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    /* doWork : 백그라운드에서 실행하고 싶은 실제 코드 */
    override fun doWork(): Result {
        Log.d("[jw]", "doWork")
        /* Bitmap 작업때 필요함 */
        val appContext = applicationContext

        /* setInputData 에서 넣어준 값 꺼내서 사용하기 */
        val resourceUri = inputData.getString(KEY_IMAGE_URI)

        /* Start Notification */
        makeStatusNotification("Blurring image", appContext)

        sleep() // slow down the worker

        return try {
            /* Image -> Bitmap */
//            val picture = BitmapFactory.decodeResource(
//                appContext.resources,
//                R.drawable.android_cupcake)

            /* null check */
            if (TextUtils.isEmpty(resourceUri)) {
                throw IllegalArgumentException("Invalid input uri")
            }
            val resolver = appContext.contentResolver
            val picture = BitmapFactory.decodeStream(
                resolver.openInputStream(Uri.parse(resourceUri))
            )

            /* 실제 블러처리하는 과정 */
            val output /* : Bitmap */ = blurBitmap(picture, appContext)

            /* 비트맵을 임시파일에 저장 */
            val outputUri = writeBitmapToFile(appContext, output)

            /* Worker 완료 후, Result.success() 에서 uri 값 반환 */
            /* Key 값은 그대로 유지하고, 데이터를 바꿔서, 결과값을 쓰기 편하게 해준다 */
            val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())

            Result.success(outputData)
        } catch (throwable: Throwable) {
            Result.failure()
        }

    }


}