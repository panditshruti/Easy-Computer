package com.shrutipandit.easycomputer

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.shrutipandit.easycomputer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(this, R.color.black))
        )
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
//                R.id.chapterNameFragment,
//                R.id.chapterNotesDetailsFragment,
//                R.id.videos,
//                R.id.typingFragment
            )
        )

        binding.toolbar.setupWithNavController(navController)
//          binding.bottomNevigation.setupWithNavController(navController)

    }

            override fun onCreateOptionsMenu(menu: Menu): Boolean {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
                return true
            }

            override fun onOptionsItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {


                    R.id.inviteAFriend -> {
                        Toast.makeText(this, "Clicked on invite a friend", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.helpCenterFragment -> {
                        // Navigate to HelpCenterFragment when "Help Center" menu item is clicked
                        navigateToHelpCenterFragment()
                        true
                    }
//                    R.id.ratingApp -> {
//                        // Open Play Store page for rating the app
//                        openPlayStoreForRating()
//                        true
//                    }
                    R.id.profileFragment -> {
                  navigateToProfileFragment()
                        true
                    }


                    else -> super.onOptionsItemSelected(item)
                }

            }

            override fun onDestroy() {
                super.onDestroy()
                _binding = null
            }



            fun shareAppLink(item: MenuItem) {
                val packageName = packageName

                // Create a URI for the app on the Play Store
                val appStoreUri = Uri.Builder()
                    .scheme("https")
                    .authority("play.google.com")
                    .appendPath("store")
                    .appendPath("apps")
                    .appendPath("details")
                    .appendQueryParameter("id", packageName)
                    .build()

                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, appStoreUri.toString())
                }

                startActivity(Intent.createChooser(shareIntent, "Share App Link"))
            }
            private fun navigateToHelpCenterFragment() {
                // Navigate to HelpCenterFragment using NavController
                navController.navigate(R.id.helpCenterFragment)
            }


    private fun navigateToProfileFragment() {
        // Navigate to HelpCenterFragment using NavController
        navController.navigate(R.id.profileFragment)
    }

    private fun openPlayStoreForRating() {
                // Create a URI for the app on the Play Store
                val appStoreUri = Uri.parse("market://details?id=$packageName")

                val rateIntent = Intent(Intent.ACTION_VIEW, appStoreUri)

                // Ensure that the Play Store app is available on the device
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                try {
                    startActivity(rateIntent)
                } catch (e: ActivityNotFoundException) {
                    // In case the Play Store app is not available, open the Play Store website
                    val webStoreUri = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    val webRateIntent = Intent(Intent.ACTION_VIEW, webStoreUri)
                    startActivity(webRateIntent)
                }
            }


//    private fun logoutUser() {
//        FirebaseAuth.getInstance().signOut()
//
//        val intent = Intent(this, Login::class.java)
//        intent.flags =
//            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//        startActivity(intent)
//        finish()
//    }

//
//            private fun inAppUp() {
//                val appUpdateInfoTask = appUpdateManager.appUpdateInfo
//
//                appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
//                    if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
//                        && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
//                    ) {
//                        try {
//                            appUpdateManager.startUpdateFlowForResult(
//                                appUpdateInfo,
//                                AppUpdateType.IMMEDIATE,
//                                this,
//                                updateCode
//                            )
//                        } catch (e: IntentSender.SendIntentException) {
//                            e.printStackTrace()
//                        }
//                    }
//                }
//            }
//            private fun inProgressUpdate() {
//                val appUpdateInfoTask = appUpdateManager.appUpdateInfo
//
//                appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
//                    if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
//                        try {
//                            appUpdateManager.startUpdateFlowForResult(
//                                appUpdateInfo,
//                                AppUpdateType.IMMEDIATE,
//                                this,
//                                updateCode
//                            )
//                        } catch (e: IntentSender.SendIntentException) {
//                            e.printStackTrace()
//                        }
//                    }
//                }
//            }
//
////
//            override fun onResume() {
//                super.onResume()
//                inProgressUpdate()
//            }

        }

