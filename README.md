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
    compileOnly("net.chaossquad:mclib-json:main-188b6f2059b1a8bf1bf547c6aeb98a0f89937a74")
}
```