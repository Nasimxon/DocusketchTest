//import sun.misc.Version

object Modules {
    val common = ":common"
    val core = ":core"
    val data = ":data"
    val domain = ":domain"
    val navigation = ":navigation"
    val presentation = ":presentation"
    val users = ":users"
    val details = ":details"
}

object ApplicationId {
    val id = "com.docusketch.test"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val appCompat = "1.5.1"
    val androidTestRunner = "1.5.0"
    val androidJunit = "1.5.0"
    val buildTool = "30.0.3"
    val cardViewVersion = "1.0.0"
    val coreKtx = "1.9.0"
    val compileSdkVersion = 29
    val constraintLayout = "2.1.4"
    val coroutines = "1.3.5"
    val dagger = "2.44.2"
    val espressoCore = "3.5.0"
    val fragment = "1.5.4"
    val glideVersion = "4.14.2"
    val gradle = "7.6"
    val junit = "4.13.1"
    val kotlinVersion = "1.7.20"
    val kotlinCoroutine = "1.6.4"
    val lifecycle = "2.5.1"
    val minSdk = 23
    val legacyVersion = "1.0.0"
    val logginInterceptor = "4.7.2"
    val materialDesignVersion = "1.7.0"
    val moshiVersion = "1.14.0"
    val nav = "2.5.3"
    val okHttp = "4.10.0"
    val retrofit = "2.9.0"
    val retrofitMoshi = "2.9.0"
    val roomVersion = "2.4.3"
    val recyclerview = "1.2.1"
    val rxJavaAndroid = "2.1.1"
    val rxJava = "2.2.9"
    val rxJavaKotlin = "2.2.0"
    val safeArgs = "2.2.2"
    val shapeImageVersion = "0.9.3@aar"
    val svgDecoderVersion = "1.2.1"
    val targetSdk = 33
    val vectorDrawableVersion = "1.1.0"
}

object Libraries {
    // Dagger core
    val dagger2 = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    // RETROFIT
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitMoshi}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logginInterceptor}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"

    // MOSHI
    val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

    // VIEWS AND ANIMATIONS
    val shapeImage = "com.github.siyamed:android-shape-imageview:${Versions.shapeImageVersion}"
    val glide =  "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    val svgDecoder = "com.caverock:androidsvg:${Versions.svgDecoderVersion}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val coreKotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"
    val androidKotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}"
}

object AndroidLibraries {
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacyVersion}"

    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val cardView = "androidx.cardview:cardview:${Versions.cardViewVersion}"
    val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawableVersion}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val fragment = "androidx.fragment:fragment:${Versions.fragment}"

    val materialDesign = "com.google.android.material:material:${Versions.materialDesignVersion}"

    // ViewModel and LiveData
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleCompile = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // ROOM
    val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    // optional - Kotlin Extensions and Coroutines support for Room
    val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"

}

object TestLibraries {
    // ANDROID TEST
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val junit = "junit:junit:${Versions.junit}"
    val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"

}