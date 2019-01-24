# ICE Application

### Introduction

This application was inspired by a [similar app](https://play.google.com/store/apps/details?id=com.lagache.sylvain.ice_android) by Sylvain Lagache. It attempts to create an Android equivalent to the extremely useful Emergency App on iOS. 

For me, this app was a great way to get acquainted with the Android SDK, while making a useful project. 

### Use Case

The main use case for this app is when the owner of the phone is unable to provide information about themselves, in case of an emergency. First responders or other personnel could use the lock screen notification to gain information about the user without needing to unlock the user's phone. Thus, this app saves time while also protecting the user's privacy. 

### Working

The app takes in the following information from the user:
1. Name
2. Blood Type
3. Allergies

It also takes information for up to five emergency contacts:
1. Contact's Name
2. Contact's Phone
3. Relation to User

If the user chooses, the app sets a permanent lock screen notification displaying the information entered. 

All user data is stored locally using the [Shared Preferences](https://developer.android.com/training/data-storage/shared-preferences) API. This was done since there are only a few simple key-value pairs to be stored. 

### Resources Used:
- I found the [Android Developer Guide](https://developer.android.com/guide/) to be a great resource

### TODO:

- Migrate the app to [Kotlin](https://developer.android.com/kotlin/get-started)
