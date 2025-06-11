package com.example.ejemplo1composeidgs904


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo1composeidgs904.Ejemplo1ComposeIDGS904Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso"),
    PersonajeTarjeta("dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad"),
    PersonajeTarjeta("gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola. Es el primer hijo de Son Goku y Chi-Chi"),
    PersonajeTarjeta("krilin", "Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku. Es junto a Bulma uno de los personajes de apoyo principales de Dragon Ball, Dragon Ball Z y Dragon Ball Super"),
    PersonajeTarjeta("bills", "Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película, y que aparece en el manga y anime de Dragon Ball Super"),
    PersonajeTarjeta("picolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z"),
    PersonajeTarjeta("n_18", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian. Tras su cambio de humano a Androide, le insertaron un chip con el objetivo de destruir a Son Goku"),
    PersonajeTarjeta("n_17", "Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es hija del Dr. Brief y su esposa Panchy, hermana menor de Tights y una gran amiga de Son Goku con quien inicia la búsqueda de las Esferas del Dragó"),
    PersonajeTarjeta("vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza"),
    PersonajeTarjeta("mrroshi", "Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo, y con ello el sueño de todo villano: dominar el mundo")
)

data class PersonajeTarjeta(val tittle: String, val body: String)

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn {
         items(personajes){ personaje ->
             MyPersonajes(personaje)
         }
     }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        ) {
            ImagenHeroe(personaje.tittle)
            Personajes(personaje)
        }
    }
}

@Composable
fun Personajes(personaje: PersonajeTarjeta) {
    Column {
        Personaje(personaje.tittle,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle) {
    Text(text = name)
    }


@Composable

fun ImagenHeroe(imageName: String){

    val context = LocalContext.current
    val ImageResId = remember (imageName){
        context.resources.getIdentifier(imageName.lowercase(), "drawable", context.packageName)
    }
    Image(
        painterResource(id = ImageResId),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
    }

@Preview
@Composable
fun PreviewMessageCard() {
        Tarjeta(tarjetas)
    }
