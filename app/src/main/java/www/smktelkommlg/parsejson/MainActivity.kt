package www.smktelkommlg.parsejson



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient().getMovieService()
            .enqueue(object : Callback<List<MovieResponse>> {
                override fun onFailure(call: Call<List<MovieResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<MovieResponse>>,
                    response: Response<List<MovieResponse>>
                ) {
                    list_movies.adapter = MovieAdapter(response.body())
                }

            })
    }
}
