package nyc.c4q.android44unit5mid_unitpracticalassessment;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

  private TextView personName;
  private TextView cell;
  private TextView dob;
  private TextView email;
  private TextView city;
  private TextView postcode;
  private TextView state;
  private TextView street;
  private ImageView largepic;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    largepic = findViewById(R.id.largepic);
    personName = findViewById(R.id.name);
    cell = findViewById(R.id.cell);
    dob = findViewById(R.id.dob);
    email = findViewById(R.id.email);
    city = findViewById(R.id.city);
    postcode = findViewById(R.id.postcode);
    state = findViewById(R.id.state);
    street = findViewById(R.id.street);
    loadIntent();
  }

  private void loadIntent() {
    Bundle extra = getIntent().getExtras();
    personName.setText(extra.getString("Name"));
    cell.setText(extra.getString("Cell"));
    dob.setText(extra.getString("DOB"));
    email.setText(extra.getString("Email"));
    city.setText(extra.getString("City"));
    postcode.setText(extra.getString("PostCode"));
    state.setText(extra.getString("State"));
    street.setText(extra.getString("Street"));
    String picture = extra.getString("Picture");

    Picasso.with(getApplicationContext()).load(picture).into(largepic);


  }

}
