package nyc.c4q.android44unit5mid_unitpracticalassessment.Views;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
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

    String name = results.getName().getFirst() + " " + results.getName().getLast();
    personName.setText(name);

    Picasso.with(itemView.getContext()).load(results.getPicture().getThumbnail()).into(personImage);

  }
}
