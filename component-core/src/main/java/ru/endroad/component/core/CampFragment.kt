package ru.endroad.component.core

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

abstract class CampFragment : Fragment() {

	protected open var toolbarMenuLayout: Int? = null
	abstract val layout: Int

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		toolbarMenuLayout?.let { setHasOptionsMenu(true) }
		setupViewComponents()
	}

	protected open fun setupViewComponents() = Unit

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View =
		inflater.inflate(layout, container, false)

	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		toolbarMenuLayout?.let { inflater.inflate(it, menu) }
		super.onCreateOptionsMenu(menu, inflater)
	}

	protected fun setToolbarText(text: CharSequence) {
		activity?.title = text
	}
}