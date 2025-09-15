# mclib-json
This library contains Paper/Spigot-related utilities for json.

### Features
- Serialize/Deserialize things to/from json
- JSON Editor command
- ...

### Javadocs
You can visit the JavaDocs here: [JavaDocs](https://chaossquad.github.io/mclib-json)

### Import

Using Gradle:
```kotlin
repositories {
    // [...]
    maven {
        name = "chaossquad-releases"
        url = uri("https://maven.chaossquad.net/releases")
    }

    maven {
        name = "chaossquad-snapshots"
        url = uri("https://maven.chaossquad.net/snapshots")
    }
}

dependencies {
    // [...]
    implementation("net.chaossquad:mclib-json:main-3ff1b6dc60b0095802d12edf43464fadf6481fdd") {
        exclude(group = "net.chaossquad", module = "mclib")
    }
}
```