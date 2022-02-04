package com.ralphevmanzano.workoutsforhumans.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

  protected lateinit var binding: VB
  protected abstract fun getViewBinding(): VB

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = getViewBinding()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupViews()
    observeData()
  }

  fun <T> observeLiveData(liveData: LiveData<T>, doNext: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) {
      doNext(it)
    }
  }

  open fun setupViews() {}
  open fun observeData() {}
}