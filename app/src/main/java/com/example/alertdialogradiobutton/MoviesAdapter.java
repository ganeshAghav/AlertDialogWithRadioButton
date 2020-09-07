package com.example.alertdialogradiobutton;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public LinearLayout mainLayout;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView year, genre;
        public MyViewHolder(View view) {
            super(view);
            //title = (TextView) view.findViewById(R.id.title1);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            mainLayout = (LinearLayout) view.findViewById(R.id.listrelvlayout);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
       // holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AlertDialog levelDialog = null;
                final CharSequence[] colors_radio={"Green","Black","White"}; //items

                // Creating and Building the Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Select The Difficulty Level");
                //builder.setPositiveButton("Accept", null);
                builder.setNeutralButton("Cancel", null);
                final AlertDialog finalLevelDialog = levelDialog;
                builder.setSingleChoiceItems(colors_radio, -1, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        // TODO Auto-generated method stub
                        Toast.makeText(view.getContext(),"The selected color is "+colors_radio[item], Toast.LENGTH_LONG).show();
                        Log.i("Select = ", "" + colors_radio[item]);
                        //dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Toast.makeText(view.getContext(),"Clicked on Accept button here open your new activity", Toast.LENGTH_LONG).show();
                    }
                });
                levelDialog = builder.create();
                levelDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
