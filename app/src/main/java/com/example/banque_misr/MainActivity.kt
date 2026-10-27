package com.example.banque_misr

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.example.banque_misr.ui.theme.Banque_MisrTheme
import com.example.banque_misr.ui.theme.Burgundy
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Banque_MisrTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanqueMisr(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanqueMisr(modifier: Modifier = Modifier) {
    val context= LocalContext.current
    var username by rememberSaveable { mutableStateOf("") }
    var isArabic by rememberSaveable { mutableStateOf(false) }
    var Password by rememberSaveable { mutableStateOf("") }
    var isFormed =username.isNotBlank()&&Password.isNotBlank()
    Column(modifier= Modifier.padding(horizontal =18.dp )) {

        Row(
            modifier = Modifier.padding(top = 84.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.bm_icon),
                contentDescription = "BanqueMisrLogo",
            )
            Text(
                text= "العربية",
                fontWeight = FontWeight.SemiBold,
                color = Burgundy,
                fontSize = 32.sp,
                modifier = Modifier.clickable{
                    ChangeLanguage(context)
                }
            )
        }
        OutlinedTextField(
         value = username
            , onValueChange ={
            username=it
            }
            , label = {
                Text("Username",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(alpha = 0.3f),
                    fontSize = 20.sp
                )
            },
            modifier = Modifier.padding(top = 32.dp).fillMaxWidth()
        )
        OutlinedTextField(
            value = Password
            , onValueChange ={
                Password=it
            }
            , label = {
                Text("Password",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(alpha = 0.3f),
                    fontSize = 20.sp
                )
            },
            modifier = Modifier.padding(top = 32.dp).fillMaxWidth()
        )
        Text(
            text="Forgot username/password?",
            fontSize = 12.sp,
            color = Color.Black.copy(alpha = 0.6f),
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.Underline,
            modifier= Modifier.clickable{
            }.padding(top =24.dp ),
        )
        Button(
            onClick ={},
            enabled = isFormed,
            modifier = Modifier.padding(top = 48.dp).fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Burgundy,
                contentColor = Color.White
                , disabledContainerColor =  Burgundy.copy(alpha = 0.3f),
            ),
        ) {
           Text(
               text="Login"
               , fontWeight = FontWeight.Bold,
               fontSize = 24.sp,
               color = Color.White.copy(0.7f)
           )
        }
       Text(
           text = buildAnnotatedString {
               append("Need help? ")
               withLink(
                    LinkAnnotation.Url(
                        url = "",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = Burgundy,
                                fontWeight = FontWeight.SemiBold,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    )
                ){
                    append("Contact us")
                }

           },
           modifier= Modifier.padding(top = 24.dp)


       )

        HorizontalDivider(
            thickness = 1.dp,
            color=Color.LightGray.copy(alpha = 0.8f)
            , modifier = Modifier.padding(top=32.dp)
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceEvenly
            ){

         IconItem(
             R.drawable.our_products,
             listOf("Our" +
                     " products"),

         )
            IconItem(
                R.drawable.nearest_branch_or_atm,
                listOf("Nearst branch or ATM"),

            )
            IconItem(
                R.drawable.exchange_rate,
                listOf("Exchand rate")
            )

        }
    }}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_5")
@Composable
private fun  BanqueMisrPreview() {
    BanqueMisr()
}
fun ChangeLanguage(context:android.content.Context){
    val appLocal= LocaleListCompat.forLanguageTags("ar")
    AppCompatDelegate.setApplicationLocales(appLocal)
}