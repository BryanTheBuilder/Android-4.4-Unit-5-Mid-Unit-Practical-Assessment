package nyc.c4q.android44unit5mid_unitpracticalassessment.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Models.Results;
import nyc.c4q.android44unit5mid_unitpracticalassessment.R;
import nyc.c4q.android44unit5mid_unitpracticalassessment.Views.RandomPersonViewHolder;

/**
 * Created by c4q on 1/24/18.
 */

public class RandomPersonAdapter extends RecyclerView.Adapter<RandomPersonViewHolder> {

  private List<Results> results = new ArrayList<>();
  private Context context;

  public RandomPersonAdapter(
      List<Results> results, Context context) {
    this.results = results;
    this.context = context;
  }

  @Override
  public RandomPersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false );
    return new RandomPersonViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RandomPersonViewHolder holder, int position) {
      holder.onBind(results.get(position));
  }

  @Override
  public int getItemCount() {
    return results.size();
  }

  public void addNewStatutes(List<Results> getresults) {
    this.results.addAll(getresults);
    notifyDataSetChanged();
  }
}
