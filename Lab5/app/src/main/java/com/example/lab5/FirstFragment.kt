package com.example.lab5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment() {

    companion object {
        private const val TAG = "FirstFragment"
    }

    private fun logLifecycleEvent(event: String) {
        Log.e(TAG, event)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logLifecycleEvent("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifecycleEvent("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logLifecycleEvent("onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logLifecycleEvent("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logLifecycleEvent("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logLifecycleEvent("onDetach")
    }
}
