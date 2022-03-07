# Introduction
Weather App to display weather information for cities.

# Packages 
data -  It contains all the data accessing and manipulating components.
domain - Here ViewModel holding data for UI
ui - It has MainActivity which shows data collected from ViewModel.


# Feature
Display a list of cities accompanied by countries with weather information.
Display temperature in degree Celcius
Added animated images to show the weather description
Here is what the UI looks like ->

https://ibb.co/71trgyt

# Overview
  LiveData - To updates app component MainActivity from ViewModel.
  Coroutine - To perform background operation
  Gson - To parse json string to object 
  Lottie - To show animated images

# Architecture
Used Google MVVM architecture.
  1. MVVM with ViewModel and Repository to avoid logical code in Activity.
  2. Loose coupling by making code dependent on interfaces rather than implementations
     eg: WeatherRepository

# Possible Improvement
  Add Loading before data appears to the user
  Add unit test and ui tests 








