# Introduction
Weather App to display weather information for cities.

# Packages 
1. data -  It contains all the data accessing and manipulating components.
2. domain - Here ViewModel holding data for UI
3. ui - It has MainActivity which shows data collected from ViewModel.


# Feature
1. Display a list of cities accompanied by countries with weather information.
2. Display temperature in degree Celcius
3. Added animated images to show the weather description
4. Here is what the UI looks like ->

https://ibb.co/71trgyt

# Overview
  1. LiveData - To updates app component MainActivity from ViewModel.
  2. Coroutine - To perform background operation
  3. Gson - To parse json string to object 
  4. Lottie - To show animated images

# Architecture
Used Google MVVM architecture.
  1. MVVM with ViewModel and Repository to avoid logical code in Activity.
  2. Loose coupling by making code dependent on interfaces rather than implementations
     eg: WeatherRepository

# Possible Improvement
  1. Add Loading before data appears to the user
  2. Add unit test and ui tests 








