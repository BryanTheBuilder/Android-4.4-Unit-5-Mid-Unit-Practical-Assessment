package nyc.c4q.android44unit5mid_unitpracticalassessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.RandomPeople;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.Results;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Utils.RandomPeopleService;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  public static final RandomPeopleService RANDOM_PEOPLE_SERVICE = ServiceGenerator.createService();
  private RecyclerView recyclerView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.random_people_rv);

    loadRecycler();

  }

  private void loadRecycler() {

    RANDOM_PEOPLE_SERVICE.getRandomPeople().enqueue(new Callback<RandomPeople>() {
      @Override
      public void onResponse(Call<RandomPeople> call, Response<RandomPeople> response) {

        List<Results> results = response.body().getResults();


      }

      @Override
      public void onFailure(Call<RandomPeople> call, Throwable t) {

      }
    });

  }

}
