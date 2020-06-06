package com.androiddevs.confused.ui.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.androiddevs.confused.R

class indiafragmentDirections private constructor() {
  companion object {
    fun actionIndiafragmentToStatefragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_indiafragment_to_statefragment)

    fun actionIndiafragmentToInformfragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_indiafragment_to_informfragment)
  }
}
