package com.example.poco3dcamera

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.widget.*

class MainActivity : Activity() {
    private lateinit var status: TextView
    override fun onCreate(b: Bundle?) {
        super.onCreate(b); setContentView(R.layout.activity_main)
        status=findViewById(R.id.status)
        findViewById<Button>(R.id.check).setOnClickListener { checkCameras() }
        if (checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED)
            requestPermissions(arrayOf(Manifest.permission.CAMERA),10) else checkCameras()
    }
    private fun checkCameras() {
        val cm=getSystemService(CameraManager::class.java)
        val rear=cm.cameraIdList.filter { id ->
            cm.getCameraCharacteristics(id).get(CameraCharacteristics.LENS_FACING)==CameraCharacteristics.LENS_FACING_BACK
        }
        val details=rear.map { id ->
            val c=cm.getCameraCharacteristics(id)
            val caps=c.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES)?.joinToString() ?: "unknown"
            "Camera ID $id — capabilities: $caps"
        }
        status.text="Rear cameras detected: ${rear.size}\n\n${details.joinToString("\n")}\n\nNext build will attempt concurrent dual-rear capture."
    }
}
