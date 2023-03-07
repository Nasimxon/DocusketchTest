package com.docusketch.core.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.docusketch.core.App

fun Activity.coreComponent() = App.coreComponent(this)
fun FragmentActivity.coreComponent() = App.coreComponent(this)
fun Fragment.coreComponent() = App.coreComponent(requireContext())