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




  }

}
