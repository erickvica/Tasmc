package com.example.vivanco.tasmc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by VIVANCO on 12/01/2015.
 */
public class AdaptadorHotelesDisponibles extends RecyclerView.Adapter<AdaptadorHotelesDisponibles.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    //Lista de hoteles
    private ArrayList<Hotel> listHoteles = new ArrayList<>();
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;


    public AdaptadorHotelesDisponibles(Context context) {
        inflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
    }

    public void setHotelList(ArrayList<Hotel> listHoteles) {
        this.listHoteles = listHoteles;
        notifyItemRangeChanged(0, listHoteles.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.renglon_hoteles_disponibles, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Hotel currentHotel = listHoteles.get(position);
        holder.nombre.setText(currentHotel.getNombre());
        holder.precio.setText(currentHotel.getPrecio());
        holder.estrellas.setRating(currentHotel.getEstrellas() / 20.0f);
        String urlImagen = currentHotel.getUrlImagen();
        if (urlImagen != null) {
            imageLoader.get(urlImagen, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.imagen.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return listHoteles.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imagen;
        private TextView nombre;
        private TextView precio;
        private RatingBar estrellas;

        public MyViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            precio = (TextView) itemView.findViewById(R.id.precio);
            estrellas = (RatingBar) itemView.findViewById(R.id.estrellas);


            //icon.setOnClickListener(this); solo con el icono reacciona al click
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            //Toast.makeText(context, "hola"+getPosition(),Toast.LENGTH_LONG); usa get position
            switch (getPosition() + 1) {
/*                case 1:
                    context.startActivity(new Intent(context, Hoteles.class));
                    break;*/

            }
//            context.startActivity(new Intent(context, SubActivity.class));
        }
    }
}
