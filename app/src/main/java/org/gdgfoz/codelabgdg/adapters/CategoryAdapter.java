package org.gdgfoz.codelabgdg.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.gdgfoz.codelabgdg.R;
import org.gdgfoz.codelabgdg.models.Category;

import java.util.List;

/**
 * Created by hussan on 12/12/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context mContext;
    private List<Category> items;

    public CategoryAdapter(Context mContext, List<Category> items) {
        this.mContext = mContext;
        this.items = items;
    }

    public void setItems(List<Category> items) {
        this.items = items;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Category category = items.get(position);

        holder.txtName.setText(category.getCategory());

        Picasso.with(mContext).load(category.getSrcIcon()).into(holder.imgCategory);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgCategory = (ImageView) itemView.findViewById(R.id.img_category);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
        }
    }
}
