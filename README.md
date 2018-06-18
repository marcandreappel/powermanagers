# Powermanagers
An Android library to check for installed power managers on the phone, like some from ASUS, OPPO, Sony, etc...

## Installation
Add the following to your project build.gradle:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

and in your app/build.gradle add:
```
android {
  ...
  dependencies {
    implementation 'com.github.marcandreappel:powermanagers:1.0.0'
  }
}
```

## Implementation
In any (but preferably the earliest) activity add under ``onCreate``:

```
// Check for the presence of a powermanager
val powermanagerIntent: Intent? = Powermanagers.present(this)

// If there's one, then open it
if (powermanagerIntent != null) {
    startActivity(powermanagerIntent)
}
```
