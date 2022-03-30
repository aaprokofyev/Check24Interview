package de.check24.devtest.ui

import android.content.Context
import androidx.fragment.app.Fragment
import de.check24.devtest.di.Injectable

abstract class BaseFragment : Fragment(), Injectable {

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }
}