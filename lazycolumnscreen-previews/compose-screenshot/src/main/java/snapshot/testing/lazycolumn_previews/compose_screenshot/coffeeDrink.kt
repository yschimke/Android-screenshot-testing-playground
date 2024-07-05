package snapshot.testing.lazycolumn_previews.compose_screenshot

import androidx.compose.runtime.Composable
import com.example.road.to.effective.snapshot.testing.lazycolumnscreen.CoffeeDrinkItem

@Composable
fun coffeeDrink() =
    CoffeeDrinkItem(
        id = 1L,
        name = "Something",
        imageUrl = R.drawable.americano_small,
        description = "Something",
        ingredients = "Espresso, Water",
        isFavourite = false
    )