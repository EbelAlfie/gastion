package com.example.gastion.ui.main

import android.location.Location
import android.location.LocationListener
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gastion.data.GasSource
import com.example.gastion.data.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.osmdroid.util.GeoPoint
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val locationRepository: LocationRepository,
  private val gasSource: GasSource
) : ViewModel() {
  val userLocation = MutableStateFlow<Location?>(null)
  val poiDebugLoc = MutableStateFlow<Location?>(null)
  val nearestGasStations = MutableStateFlow<ArrayList<Location>>(arrayListOf())

  @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
  fun requestLocationUpdate() {
    locationRepository.getCurrentLocation(
      object : LocationRepository.LocationListener {
        override fun onLocationResult(location: Location?) {
          userLocation.value = location
        }
      }
    )

  }

  fun searchNearestGasStation(location: Location) {
    gasSource.getNearestGasStation(GeoPoint(location.latitude, location.longitude), 0.1)
  }
}