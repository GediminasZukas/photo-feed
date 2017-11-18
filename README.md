# photo-feed
This is a sample app which is architected by following Uncle Bob's "Clean Architecture" approach. I strongly believe that this approach helps us to write well testable, maintainable and scalable high-quality apps. 

At the same time, special thanks to Fernando Cejas and his work on this topic: https://github.com/android10/Android-CleanArchitecture Many ideas from his repo and blog is used in this project.

From functionality perspective, currently it is a very simple application - it just shows recent photo feed  which is retrieved from Flickr API.

## Motivation
There are 2 reasons why I created this project:
- **Education.** I know that there are many Android Clean Architecture examples out there, but I still believe that for somebody (including myself too) this project can definitely help to learn something new.
- **New/trending technologies playground.** It is always good to keep up with the state-of-the-art technologies and see how well they play with each other.

## Technologies
- Entire app written in **Kotlin**
- **RxJava 2**
- **Dagger 2** for dependency injection
- **Retrofit 2** with **Moshi** converter for dealing with network APIs
- **Picasso** for loading images
- **ConstraintLayout** for creating UI
- **Timber** for logging in debug builds

Coming soon:

- **Android Architecture Components** - for better relationship with Android lifecycle events
- **Espresso 3.0** - for UI testing
- **Mockito** - for unit testing
- Kotlin static analysis tool? usage
- Continuous integration (CI) tool? usage for build tasks automation

## Status
Currently this project is at the development stage and therefore cannot be considered "full" Clean Architecture example. It lacks functionality, unit/integration tests, proper error handling.

## Quick run
1. In your dedicated project directory:
`git clone git@github.com:GediminasZukas/photo-feed.git`
2. `cd` to root `photo-feed` project directory
3. Connect a real device to your machine (or run the emulator) and then execute: `./gradlew installDebug`
