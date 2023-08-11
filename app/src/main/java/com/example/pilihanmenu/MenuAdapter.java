package com.example.pilihanmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;
    private Context context;

    public MenuAdapter(List<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);

        holder.imageView.setImageResource(menuItem.getImageResourceId());
        holder.textViewName.setText(menuItem.getName());
        holder.textViewDescription.setText(menuItem.getDescription());

        // Convert the integer price to a formatted string
        String formattedPrice = "Rp " + String.format("%,d", menuItem.getPrice());
        holder.textViewPrice.setText(formattedPrice);

        holder.buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailFoodLayout(menuItem);
            }
        });
    }


    // Method untuk membuka layout detail makanan
    private void openDetailFoodLayout(MenuItem menuItem) {
        Intent intent = new Intent(context, DetailFoodActivity.class);
        intent.putExtra("imageResourceId", menuItem.getImageResourceId());
        intent.putExtra("name", menuItem.getName());
        intent.putExtra("description", menuItem.getDescription());
        intent.putExtra("price", menuItem.getPrice());
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewDescription;
        TextView textViewPrice;
        Button buttonOrder;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonOrder = itemView.findViewById(R.id.buttonOrder);
        }
    }
}
