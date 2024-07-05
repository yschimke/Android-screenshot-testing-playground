package snapshot.testing.lazycolumn_previews.compose_screenshot

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.road.to.effective.snapshot.testing.lazycolumnscreen.AppTheme
import com.example.road.to.effective.snapshot.testing.lazycolumnscreen.CoffeeDrinkItem
import com.example.road.to.effective.snapshot.testing.lazycolumnscreen.CoffeeDrinkList
import com.example.road.to.effective.snapshot.testing.lazycolumnscreen.R

/**
 * Record: ./gradlew :lazycolumnscreen-previews:compose-screenshot:updateDebugScreenshotTest
 * Verify: ./gradlew :lazycolumnscreen-previews:compose-screenshot:validateDebugScreenshotTest
 *
 * Keep in mind that currently, Compose Preview screenshot testing tool only supports previews
 * in the "screenshotTest" source, so previews in the "main" source are ignored
 */
class PreviewsForScreenshotTests {
    @Composable
    private fun coffeeDrink() =
        CoffeeDrinkItem(
            id = 1L,
            name = stringResource(R.string.americano_title),
            imageUrl = R.drawable.americano_small,
            description = stringResource(R.string.americano_description),
            ingredients = "Espresso, Water",
            isFavourite = false
        )

    @Composable
    @Preview
    fun CoffeeDrinkListWithParametersPreview(
        @PreviewParameter(provider = CoffeeDrinkItemProvider::class) drinkItem: CoffeeDrinkItem
    ) {
        AppTheme {
            CoffeeDrinkList(
                coffeeDrink = drinkItem
            )
        }
    }

    @PreviewFontScale
    @PreviewLightDark
    @Composable
    fun CoffeeDrinkListMultiConfigPreview() {
        AppTheme {
            CoffeeDrinkList(
                coffeeDrink = coffeeDrink()
            )
        }
    }

    @Preview(locale = "ar-rXB")
    @Composable
    fun CoffeeDrinkListPseudoLocalePreview() {
        AppTheme {
            CoffeeDrinkList(
                coffeeDrink = coffeeDrink()
            )
        }
    }

    @Preview(apiLevel = 31)
    @Composable
    fun CoffeeDrinkListApiLevelPreview() {
        AppTheme {
            CoffeeDrinkList(
                coffeeDrink = coffeeDrink().copy(name = "API ${Build.VERSION.SDK_INT}")
            )
        }
    }
}