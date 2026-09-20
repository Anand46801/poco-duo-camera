# Poco 3D Camera — Complete GitHub-ready prototype

This project includes a GitHub Actions workflow, so a cloud build can create the APK without installing Android Studio.

## GitHub
1. Create a new GitHub repository.
2. Upload the contents of this folder (not the outer folder itself).
3. Commit to `main`.
4. Open **Actions** → **Build APK**.
5. Open the completed workflow run → **Artifacts** → download `Poco3DCamera-debug`.

## Current build
The APK detects the rear camera IDs and reports Camera2 capabilities.

## Intended full feature
The next implementation stage is concurrent rear-camera capture, synchronization, geometric alignment, and red/cyan anaglyph MP4 encoding.

Android CameraX supports concurrent camera operation on devices that expose a supported concurrent-camera configuration; the phone may still restrict specific rear-lens combinations.
