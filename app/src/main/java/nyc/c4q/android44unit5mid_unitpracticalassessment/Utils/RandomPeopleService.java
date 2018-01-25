package nyc.c4q.android44unit5mid_unitpracticalassessment.Utils;

import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.RandomPeople;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 1/24/18.
 */

public interface RandomPeopleService {

  @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
  Call<RandomPeople> getRandomPeople();

}
