package com.example.retrofit

import okhttp3.Interceptor
import okhttp3.Request

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjAxMWMzNGNkZWI5NGM5NTAyZDYzNTI5MGZkZTZkMGNmNzA0Y2Y0ZTcxYjM3MWI3MzdkNmZkNWRjOWQzMmEwYjI5MzNjZjcwZTk4Mzg1M2FmIn0.eyJhdWQiOiI5IiwianRpIjoiMDExYzM0Y2RlYjk0Yzk1MDJkNjM1MjkwZmRlNmQwY2Y3MDRjZjRlNzFiMzcxYjczN2Q2ZmQ1ZGM5ZDMyYTBiMjkzM2NmNzBlOTgzODUzYWYiLCJpYXQiOjE2OTY0OTk3MTUsIm5iZiI6MTY5NjQ5OTcxNSwiZXhwIjoxNzI4MTIyMTE1LCJzdWIiOiI4NyIsInNjb3BlcyI6W119.JCuVD8swtjm5Wef2Hztg3CyoW3mbWqvcCvraflbZBGSjeiRXrf_ycm9e4AZ145gxUquC1WwxX7NbFMAhqKKExb0RlyYL7b0G_kaoZatxQ77ZFvwqvrkDiVGeJHT-vE4qeeNb18ZcNCm1G-lZBTcR69x6BXbwuLFpWm_jBQh6NUjww425ZGz2afnSZBUoFEpQRjCBekz7qOIUGNqKT6qDTbjKfkhPJcCqA79fm9gWvhwn0gsbJokStaNCTwSZdfU1ilOdjTYYOj5LS-6URdkn3-LeG19mKjKzAMs9Lw8ez2xIMGBQtnSyG62hD6Tyt7vubYOrUfj_ZmAq9fmPnIHhkaWcyWv_6M33fHt_9PRQMeG7Ij6f3Hf82IiuSMNfnrAGRXN19SmHVvArOF6HH9uS5UVD8flIpDsAbDkt9cvIHHgRRYxeOuaQTVWBhUaeHwwHCGooJPeTJUKWI2tPikdCPEY6zq2UaEvqs_BtOxk_NLgpXBqoha7AAcV-ipzuB9m81O8Z0XLrnje3N6x55iPsvpEgCOn6l_8s86QTOFlqbD5KB0MaR4MJU_ne2G3svUehvE7BBRM02nIjMliQek1iUzwNUWSDgh2cqv910X98ifbi7I_hmQA_sXGtah5SUMMGz4ViFexK7hTX838OnFXNT-CFH8NXwI28sultRH4fxE4")
            .build()
        return chain.proceed(newRequest)
    }
}