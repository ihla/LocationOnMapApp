This is a small demo of the application of Google Maps API v2 - MapView,
inspired by sample code from Google Play Services SDK: <android-sdk-folder>/extras/google/google_play_services/samples/maps.
See doc here: https://developers.google.com/maps/documentation/android/map.

MapView, a subclass of the Android View class, allows you to place a map in an Android View.
A View represents a rectangular region of the screen, and is a fundamental building block for Android applications and widgets.
Much like a MapFragment, the MapView acts as a container for the Map, exposing core map functionality through the GoogleMap object.

WARNING: In order to resolve the exception thrown when app starts up,
which was caused by initialized BitmapDescriptorFactory and CameraUpdateFactory, I have to call MapsInitializer prior to calling GoogleMap.
See also here: http://developer.android.com/reference/com/google/android/gms/maps/MapsInitializer.html.

THE APP DEPENDS ON google-play-services_lib! You need to set your Google Maps Android API Key in manifest xml file.