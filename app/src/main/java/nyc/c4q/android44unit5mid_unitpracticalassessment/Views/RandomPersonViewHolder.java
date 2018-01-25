package nyc.c4q.android44unit5mid_unitpracticalassessment.Views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import nyc.c4q.android44unit5mid_unitpracticalassessment.DetailActivity;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.Results;
import nyc.c4q.android44unit5mid_unitpracticalassessment.R;

/**
 * Created by c4q on 1/24/18.
 */

public class RandomPersonViewHolder extends ViewHolder {

  private TextView personName;
  private ImageView personImage;


  public RandomPersonViewHolder(View itemView) {
    super(itemView);
    personName = itemView.findViewById(R.id.person_name);
    personImage = itemView.findViewById(R.id.person_image);
  }

  public void onBind(Results results) {

    final String name = results.getName().getFirst() + " " + results.getName().getLast();
    personName.setText(name);
    final String cell = results.getCell();
    final String dob = results.getDob();
    final String email = results.getEmail();
    final String city = results.getLocation().getCity();
    final int postcode = results.getLocation().getPostcode();
    final String state = results.getLocation().getState();
    final String street = results.getLocation().getStreet();
    final String largepic_url = results.getPicture().getLarge();
    Picasso.with(itemView.getContext()).load(results.getPicture().getThumbnail()).into(personImage);

    itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent goToDetailActivity = new Intent(itemView.getContext(), DetailActivity.class);
        goToDetailActivity.putExtra("Name", name);
        goToDetailActivity.putExtra("Cell", cell);
        goToDetailActivity.putExtra("DOB", dob);
        goToDetailActivity.putExtra("Email", email);
        goToDetailActivity.putExtra("City", city);
        goToDetailActivity.putExtra("PostCode", postcode);
        goToDetailActivity.putExtra("State", state);
        goToDetailActivity.putExtra("Street", street);
        goToDetailActivity.putExtra("Picture", largepic_url);
        itemView.getContext().startActivity(goToDetailActivity);
      }
    });


  }
}
