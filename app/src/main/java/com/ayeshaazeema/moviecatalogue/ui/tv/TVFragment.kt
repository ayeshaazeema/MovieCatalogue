package com.ayeshaazeema.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ayeshaazeema.moviecatalogue.R

class TVFragment : Fragment() {

    private lateinit var TVViewModel: TVViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        TVViewModel =
                ViewModelProvider(this).get(TVViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        TVViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}