package com.example.road.to.effective.snapshot.testing.samples.fragment.parameterized

import androidx.test.filters.SdkSuppress
import com.example.road.to.effective.snapshot.testing.recyclerviewscreen.mvvm.RecyclerViewFragment
import com.example.road.to.effective.snapshot.testing.utils.annotations.HappyPath
import com.example.road.to.effective.snapshot.testing.utils.annotations.UnhappyPath
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sergio.sastre.uitesting.utils.fragmentscenario.fragmentScenarioConfiguratorRule

/**
 * Example of Parameterized test with TestParameterInjector Runner.
 *
 * Unlike Parameterized Runner, the test methods admit arguments, although we do not use them here.
 *
 * On the other hand, TestParameterInjector requires API 24+ to run with instrumented tests.
 * It throws java.lang.NoClassDefFoundError: com.google.common.cache.CacheBuilder in lower APIs.
 * Parameterized Runner is compatible with instrumented test of any API level
 */
@SdkSuppress(minSdkVersion = 24)
@RunWith(TestParameterInjector::class)
class RecyclerViewFragmentTestParameterInjectorHappyPathTest(
    @TestParameter val configItem: HappyPathTestItem,
) : ScreenshotTest {

    @get:Rule
    val fragmentScenarioConfiguratorRule =
        fragmentScenarioConfiguratorRule<RecyclerViewFragment>(config = configItem.item)

    @HappyPath
    @Test
    fun snapFragment() {
        compareScreenshot(
            fragment = fragmentScenarioConfiguratorRule.fragment,
            name = "RecyclerViewFragment_${configItem.name}_TestParameterInjector",
        )
    }
}

@SdkSuppress(minSdkVersion = 24)
@RunWith(TestParameterInjector::class)
class RecyclerViewFragmentTestParameterInjectorUnhappyPathTest(
    @TestParameter val configItem: UnhappyPathTestItem,
) : ScreenshotTest {

    @get:Rule
    val fragmentScenarioConfiguratorRule =
        fragmentScenarioConfiguratorRule<RecyclerViewFragment>(config = configItem.item)

    @UnhappyPath
    @Test
    fun snapFragment() {
        compareScreenshot(
            fragment = fragmentScenarioConfiguratorRule.fragment,
            name = "RecyclerViewFragment_${configItem.name}_TestParameterInjector",
        )
    }
}
