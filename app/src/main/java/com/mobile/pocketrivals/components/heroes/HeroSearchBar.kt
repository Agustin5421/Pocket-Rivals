package com.mobile.pocketrivals.components.heroes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions
import com.mobile.pocketrivals.ui.theme.searchBarText

@Composable
fun HeroSearchBar(text: String, onTextChange: (String) -> Unit) {
  Surface(
    modifier =
      Modifier.fillMaxWidth().padding(Dimensions.MediumPadding).height(Dimensions.SearchBarHeight),
    shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
    border = BorderStroke(Dimensions.MediumDividerThickness, MaterialTheme.colorScheme.tertiary),
    tonalElevation = Dimensions.Elevation,
    color = MaterialTheme.colorScheme.primary
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(Dimensions.LargePadding, vertical = Dimensions.MediumPadding)
    ) {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = stringResource(R.string.search_icon),
        tint = MaterialTheme.colorScheme.searchBarText
      )

      Spacer(modifier = Modifier.width(Dimensions.SmallSpacer))

      Box(modifier = Modifier.weight(Dimensions.MediumWeight)) {
        if (text.isEmpty()) {
          Text(
            text = stringResource(R.string.search_by_hero_s_name),
            color = MaterialTheme.colorScheme.searchBarText,
            fontSize = Dimensions.MediumFontSize
          )
        }

        BasicTextField(
          value = text,
          onValueChange = onTextChange,
          textStyle =
            TextStyle(
              fontSize = Dimensions.MediumFontSize,
              color = MaterialTheme.colorScheme.secondary
            ),
          singleLine = true,
          cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
          modifier = Modifier.fillMaxWidth()
        )
      }

      if (text.isNotEmpty()) {
        Icon(
          imageVector = Icons.Default.Close,
          contentDescription = stringResource(R.string.clear),
          modifier =
            Modifier.clickable { onTextChange("") }.padding(start = Dimensions.MediumPadding),
          tint = MaterialTheme.colorScheme.searchBarText
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroSearchBar() {
  var search by remember { mutableStateOf("") }
  HeroSearchBar(text = search, onTextChange = { search = it })
}
