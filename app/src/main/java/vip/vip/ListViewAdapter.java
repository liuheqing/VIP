package vip.vip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static vip.vip.R.id.list_item_1;
import static vip.vip.R.id.list_item_2;

/**
 * Created by Liuheqing on 2016/5/9.
 */
public class ListViewAdapter extends BaseAdapter {
    List<String> list;
    LayoutInflater inflater;
    Context context;
    List<Integer> imageList;


    public ListViewAdapter(Context context,List<String> list,List<Integer> imageList) {
        this.list = list;
        this.context = context;
        this.imageList= imageList;
        this.inflater = LayoutInflater.from(context);


    }
    public ListViewAdapter(Context context,List<String> list) {
        this.list = list;
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
            convertView = inflater.inflate(R.layout.listview, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_item_1);
            viewHolder.imageView2 = (ImageView) convertView.findViewById(R.id.list_item_2);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.lv_textView);
            convertView.setTag(viewHolder);
        } else {
           viewHolder= (ViewHolder) convertView.getTag();
        }
            viewHolder.textView.setText(list.get(position));
        // viewHolder.imageView.setImageResource(imageList.get(position));
            viewHolder.imageView.setImageResource(R.drawable.bg_accout_item_size);
            viewHolder.imageView2.setImageResource(R.drawable.icon_voucher_forward);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
    }
}
