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
    compileOnly("net.chaossquad:mclib:main-9549d74546311c5b81e8b35b60c1e78618450dc7") // Same or higher version of mclib required
    implementation("net.chaossquad:mclib-json:main-51c24745e4a686559c9ea530072077c33e0991ca") {
        exclude(group = "net.chaossquad", module = "mclib")
    }
}
```