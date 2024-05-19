package com.fedi.apiaplicatiion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem
import java.util.*

class Mainscreen3 : AppCompatActivity() {
    private lateinit var map: MapView

    // Définir la classe interne pour OnItemGestureListener
    private inner class MyItemGestureListener : ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
        override fun onItemSingleTapUp(index: Int, item: OverlayItem?): Boolean {
            return true
        }

        override fun onItemLongPress(index: Int, item: OverlayItem?): Boolean {
            return false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(applicationContext, PreferenceManager.getDefaultSharedPreferences(applicationContext))
        setContentView(R.layout.activity_mainscreen3)
        map = findViewById(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)

        val startPoint = GeoPoint(36.8065, 10.1815)
        val mapController: IMapController = map.controller
        mapController.setZoom(18.0)
        mapController.setCenter(startPoint)

        val items = ArrayList<OverlayItem>()
        val home = OverlayItem("Rallo's office", "my office", GeoPoint(36.8065, 10.1815))
        home.getMarker(0);
        items.add(home)
        items.add(OverlayItem("Resto", "chez babar", GeoPoint(36.8028, 10.1797)))

        // Utiliser la classe interne pour OnItemGestureListener
        val mOverlay = ItemizedOverlayWithFocus<OverlayItem>(
            applicationContext,
            items,
            MyItemGestureListener()  // Utilisation de la classe interne
        )
        mOverlay.setFocusItemsOnTap(true)
        map.overlays.add(mOverlay)
    }
    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }
}