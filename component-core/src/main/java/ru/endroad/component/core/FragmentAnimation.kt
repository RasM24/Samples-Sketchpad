package ru.endroad.component.core

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes

data class FragmentAnimation(
	@AnimRes @AnimatorRes val enter: Int,
	@AnimRes @AnimatorRes val exit: Int,
	@AnimRes @AnimatorRes val popEnter: Int? = null,
	@AnimRes @AnimatorRes val popExit: Int? = null
)

val defaultForwardAnimation = FragmentAnimation(
	R.anim.default_slide_in_right,
	R.anim.default_slide_out_left,
	R.anim.default_slide_in_left,
	R.anim.default_slide_out_right
)

val defaultForwardInverseAnimation = FragmentAnimation(
	R.anim.default_slide_in_left,
	R.anim.default_slide_out_right,
	R.anim.default_slide_in_right,
	R.anim.default_slide_out_left
)

val defaultReplaceAnimation = FragmentAnimation(
	R.anim.default_fade_in,
	R.anim.default_fade_out,
	R.anim.default_fade_in,
	R.anim.default_fade_out
)