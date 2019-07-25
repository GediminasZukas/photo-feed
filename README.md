# photo-feed
This is a playground app which is architected by following Uncle Bob's "Clean Architecture" approach. Special thanks to Fernando Cejas and his work on this topic: https://github.com/android10/Android-CleanArchitecture Many ideas from his repo and blog is used in this project.

It is a very simple application - it shows recent photo feed  which is retrieved from Flickr API.

## Technologies
- Entire app written in **Kotlin**
- **RxJava 2**
- **Dagger 2** for dependency injection
- **Retrofit 2** with **Moshi** converter for dealing with network APIs
- **Picasso** for loading images
- **ConstraintLayout** for creating UI
- **Timber** for logging in debug builds

## Quick run
1. In your dedicated project directory:
`git clone git@github.com:GediminasZukas/photo-feed.git`
2. `cd` to root `photo-feed` project directory
3. Connect a real device to your machine (or run the emulator) and then execute: `./gradlew installDebug`
