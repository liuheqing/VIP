package vip.vip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pojo.Goods;

/**
 * Created by Liuheqing on 2016/5/12.
 */
public class OneListViewAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    List<Goods> list;

    public OneListViewAdapter(Context context, List<Goods> list) {
        this.list=list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.guanggao_item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView_guanggao);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_guanggao);
            viewHolder.tv_cost = (TextView) convertView.findViewById(R.id.tv_guanggao2);
            convertView.setTag(viewHolder);
        }
           viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imageView.setImageResource(list.get(position).getCost());
        viewHolder.tv_name.setText("今夏时尚 随心搭购-运动风潮");
        viewHolder.tv_cost.setText("剩1天");

        return convertView;
    }
    class ViewHolder{

       ImageView imageView;
       TextView  tv_name;
       TextView tv_cost;

    }
}
