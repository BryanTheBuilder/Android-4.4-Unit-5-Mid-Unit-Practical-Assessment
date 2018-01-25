package nyc.c4q.android44unit5mid_unitpracticalassessment;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Controller.RandomPersonAdapter;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.RandomPeople;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.Results;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Utils.RandomPeopleService;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = "JSON?";
  public static final RandomPeopleService RANDOM_PEOPLE_SERVICE = ServiceGenerator.createService();
  private RandomPersonAdapter randomPersonAdapter;

  private RecyclerView recyclerView;
  private GridLayoutManager gridLayoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.random_people_rv);
    gridLayoutManager =
        new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);

    Call<RandomPeople> randomPeopleCall = RANDOM_PEOPLE_SERVICE.getRandomPeople();

    randomPeopleCall.enqueue(new Callback<RandomPeople>() {
      @Override
      public void onResponse(Call<RandomPeople> call, Response<RandomPeople> response) {
        if (response.code() == 200) {
          RandomPeople randomPeople = response.body();
          if (randomPeople != null) {
            List<Results> getresults = new ArrayList<>();
            getresults.addAll(randomPeople.getResults());
            randomPersonAdapter = new RandomPersonAdapter(getresults, getApplicationContext());
            randomPersonAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(randomPersonAdapter);
            randomPersonAdapter.notifyDataSetChanged();
            Log.d(TAG, "adapter SET");
            recyclerView.setLayoutManager(gridLayoutManager);

            if (getApplication().getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT) {
              recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            } else {
              recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
            }
          }
        }

      }

      @Override
      public void onFailure(Call<RandomPeople> call, Throwable t) {

      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }
}
