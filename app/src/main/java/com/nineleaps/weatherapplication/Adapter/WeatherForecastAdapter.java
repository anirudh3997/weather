package com.nineleaps.weatherapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineleaps.weatherapplication.Common.Common;
import com.nineleaps.weatherapplication.Model.WeatherForecastResult;
import com.nineleaps.weatherapplication.R;
import com.squareup.picasso.Picasso;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder> {

    Context context;
    WeatherForecastResult weatherForecastResult;

    public WeatherForecastAdapter(Context context, WeatherForecastResult weatherForecastResult) {
        this.context = context;
        this.weatherForecastResult = weatherForecastResult;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public WeatherForecastResult getWeatherForecastResult() {
        return weatherForecastResult;
    }

    public void setWeatherForecastResult(WeatherForecastResult weatherForecastResult) {
        this.weatherForecastResult = weatherForecastResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/")
                .append(weatherForecastResult.list.get(position).weather.get(0).getIcon())
                .append(".png").toString()).into(holder.img_weather);
        holder.txt_date.setText(
                new StringBuilder(Common.ConvertUnixToDate(
                        weatherForecastResult.list.get(position).dt)));
        holder.txt_description.setText(
                new StringBuilder(
                        weatherForecastResult.list.get(position).weather.get(0).getDescription()));
        holder.txt_temperature.setText(
                new StringBuilder(String.valueOf(
                        weatherForecastResult.list.get(position).main.getTemp())).append("°C"));

    }

    @Override
    public int getItemCount() {
        Log.e("getItemCount: ", String.valueOf(weatherForecastResult));
        return weatherForecastResult.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_date,txt_description,txt_temperature;
        ImageView img_weather;
        public MyViewHolder(View itemView){
            super(itemView);

            img_weather = itemView.findViewById(R.id.img_weather);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_description = itemView.findViewById(R.id.txt_description);
            txt_temperature = itemView.findViewById(R.id.txt_temperature);

        }
    }
}