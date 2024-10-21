package es.master.p3_retrofitweb.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import es.master.p3_retrofitweb.R;
import es.master.p3_retrofitweb.databinding.HotelLayoutBinding;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    HotelLayoutBinding binding;
    private final List<Hotel> hotels;

    public HotelAdapter(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Usamos Data Binding para inflar la vista
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflamos directamente con HotelLayoutBinding para obtener el binding.
        HotelLayoutBinding binding = HotelLayoutBinding.inflate(inflater, parent, false);
        return new HotelViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        // Obtenemos el hotel de la lista
        Hotel hotel = hotels.get(position);

        // Usamos Glide para cargar la imagen en el ImageView
        Glide.with(holder.itemView.getContext())
                .load(hotel.getThumbUrl().getImageURL())
                .override(450, 250)
                //.placeholder(R.drawable.placeholder_image)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .error(R.drawable.ic_launcher_foreground) // Imagen en caso de error
                .into(holder.binding.ivMain); // Asume que `ivMain` es el id del ImageView

        // Vinculamos el hotel al binding para que los datos se actualicen en la UI
        holder.bind(hotel);

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    // ViewHolder interno
    class HotelViewHolder extends RecyclerView.ViewHolder {
        // El binding generado automáticamente por DataBinding
        private final HotelLayoutBinding binding;

        public HotelViewHolder(@NonNull HotelLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Método para vincular los datos al binding
        public void bind(Hotel hotel) {
            // Vinculamos el objeto hotel al binding
            binding.setHotel(hotel);
            // Necesario para que el binding actualice la interfaz inmediatamente
            binding.executePendingBindings();
        }
    }
}
