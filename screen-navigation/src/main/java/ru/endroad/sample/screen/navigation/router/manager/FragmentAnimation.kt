package ru.endroad.sample.screen.navigation.router.manager

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import ru.endroad.sample.screen.navigation.R

data class FragmentAnimation(
	@AnimRes @AnimatorRes val enter: Int,
	@AnimRes @AnimatorRes val exit: Int,
)

val defaultForwardAnimation = FragmentAnimation(
	R.anim.default_slide_in_right,
	R.anim.default_slide_out_left,
)

val defaultReplaceAnimation = FragmentAnimation(
	R.anim.default_fade_in,
	R.anim.default_fade_out,
)