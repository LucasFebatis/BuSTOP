package com.febatis.bustop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.febatis.bustop.R;
import com.febatis.bustop.model.Favorito;
import com.febatis.bustop.model.Historico;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.MyViewHolder> {
private List<Historico> mDataset;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public View view;
    public MyViewHolder(View v) {
        super(v);
        view = v;
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public HistoricoAdapter(List<Historico> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HistoricoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_historico, parent, false);
        //...
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //TODO: Definir valores aos componentes
        //holder.textView.setText(mDataset.get(position));

        final ImageView iv = holder.view.findViewById(R.id.imageView2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mDataset.get(holder.getAdapterPosition()).isFavorito()) {
                    mDataset.get(holder.getAdapterPosition()).setFavorito(false);
                    iv.setImageResource(R.drawable.desfavoritar);
                } else {
                    mDataset.get(holder.getAdapterPosition()).setFavorito(true);
                    iv.setImageResource(R.drawable.favoritar);
                }


            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}