package com.android.kuro.currencytracker.screen.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.kuro.currencytracker.R
import com.android.kuro.currencytracker.common.CustomIndicator
import com.android.kuro.currencytracker.ui.theme.ButtonChooseCurrencyColor
import com.android.kuro.currencytracker.ui.theme.ButtonNextColor
import com.android.kuro.currencytracker.ui.theme.Welcome1TextColor
import com.android.kuro.currencytracker.ui.theme.Welcome2TextColor
import com.android.kuro.currencytracker.ui.theme.WorkSansFamily

@Composable
fun OnBoardScreen(
    viewModel: OnBoardViewModel = hiltViewModel()
) {
    val next = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.welcome_1),
            style = MaterialTheme.typography.headlineLarge,
            color = Welcome1TextColor,
            fontFamily = WorkSansFamily,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.welcome_2),
            style = MaterialTheme.typography.bodyLarge,
            color = Welcome2TextColor,
            fontFamily = WorkSansFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ButtonChooseCurrencyColor, RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_currency),
                        contentDescription = "Currency"
                    )
                    Text(
                        text = stringResource(id = R.string.choose_home_currency),
                        color = Color.Black.copy(0.7f),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(start = 34.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .clickable {  }
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(14.dp),
                                painter = painterResource(id = R.drawable.ic_currency_vnd),
                                contentDescription = "Currency Icon"
                            )
                            Text(
                                text = stringResource(id = R.string.vnd),
                                style = MaterialTheme.typography.titleSmall,
                                fontFamily = WorkSansFamily,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = stringResource(id = R.string.currency_vnd),
                            fontFamily = WorkSansFamily,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black.copy(0.7f)
                        )
                    }
                    Image(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIndicator(next.value)
            CustomIndicator(!next.value)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonNextColor,
            ),
            shape = RoundedCornerShape(16.dp),
            onClick = { next.value = !next.value }) {
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.next),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = WorkSansFamily,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}