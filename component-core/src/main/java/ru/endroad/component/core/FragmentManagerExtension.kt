package ru.endroad.component.core

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

val Class<out Fragment>.key get() = this::class.java.canonicalName
val Fragment.key get() = this::class.java.key

/**
 * Очищает текущий стек фрагментов и начинает новую цепочку
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.changeRoot(fragment: Fragment, @IdRes container: Int) {
	for (i in 0 until backStackEntryCount) popBackStack()

	beginTransaction()
		.replace(container, fragment)
		.commitAllowingStateLoss()
}

/**
 * Очищает текущий стек фрагментов и начинает новую цепочку
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.changeRoot(
	fragment: Fragment,
	animation: FragmentAnimation,
	@IdRes container: Int
) {
	for (i in 0 until backStackEntryCount) popBackStack()

	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		commitAllowingStateLoss()
	}
}

/**
 * Заменяет текущий фрагмент на новый
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.replace(fragment: Fragment, @IdRes container: Int) {
	if (backStackEntryCount == 0) {
		beginTransaction()
			.replace(container, fragment)
			.commitAllowingStateLoss()
	} else {
		beginTransaction()
			.replace(container, fragment)
			.addToBackStack(fragment.key)
			.commitAllowingStateLoss()
	}
}

/**
 * Заменяет текущий фрагмент на новый
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.replace(
	fragment: Fragment,
	animation: FragmentAnimation,
	@IdRes container: Int
) {
	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		if (backStackEntryCount != 0) addToBackStack(fragment.key)
		commitAllowingStateLoss()
	}
}

/**
 * Добавляет в стек новый фрагмент и ставит его текущим
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.forwardTo(fragment: Fragment, @IdRes container: Int) {
	findFragmentById(container)?.onHiddenChanged(true)
	beginTransaction()
		.replace(container, fragment)
		.addToBackStack(fragment.key)
		.commitAllowingStateLoss()
}

/**
 * Добавляет в стек новый фрагмент и ставит его текущим
 *
 * @param fragment экземпляр фрагмента
 * @param container id layout'а, в котором будет заменен фрагмент
 */
fun FragmentManager.forwardTo(
	fragment: Fragment,
	animation: FragmentAnimation,
	@IdRes container: Int
) {
	findFragmentById(container)?.onHiddenChanged(true)
	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		addToBackStack(fragment.key)
		commitAllowingStateLoss()
	}
}

private fun FragmentTransaction.setAnimationTransaction(animation: FragmentAnimation) {
	animation.run {
		if (popExit == null || popEnter == null)
			setCustomAnimations(enter, exit)
		else
			setCustomAnimations(enter, exit, popEnter, popExit)
	}
}

/**
 * Удаляет из стека последний фрагмент
 */
fun FragmentManager.back() {
	this.popBackStack()
}

/**
 * Возвращается по стеку фрагментов до первого найденного.
 *
 * Если в стеке два экземпляра фрагментов одинакового класса - то вернется к верхнему(самому ближнему)
 */
fun FragmentManager.backTo(fragment: Class<out Fragment>) {
	this.popBackStack(fragment.key, 0)
}

/**
 * Возвращается к корневому фрагменту, полностью очищая стек
 */
fun FragmentManager.backToRoot() {
	this.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

/**
 * Закрывает текущий фрагмент.
 */
fun Fragment.finish() {
	requireFragmentManager().back()
}