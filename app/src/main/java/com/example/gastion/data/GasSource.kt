package com.example.gastion.data

import org.osmdroid.bonuspack.location.NominatimPOIProvider
import org.osmdroid.bonuspack.location.POI
import org.osmdroid.util.GeoPoint
import javax.inject.Inject


class GasSource @Inject constructor() {

  fun getNearestGasStation(myPosition: GeoPoint, maxDistance: Double): ArrayList<POI> {
    val poiProvider = NominatimPOIProvider("OSMBonusPackTutoUserAgent")
    return poiProvider.getPOICloseTo(myPosition, "fuel", 100, maxDistance)
  }

}