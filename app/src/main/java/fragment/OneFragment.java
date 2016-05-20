package fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

import pojo.Goods;
import vip.vip.OneListViewAdapter;
import vip.vip.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private RollPagerView rollPagerView;
    private ListView listView;
    private List<Goods> list_goods;
    private Goods goods;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        View view1 = inflater.inflate(R.layout.guanggao, null);
        listView = (ListView) view.findViewById(R.id.one_listview);

        goods = new Goods(R.drawable.img4,null,null);
       Goods goods1 = new Goods(R.drawable.img4,null,null);
        Goods goods7 = new Goods(R.drawable.img4,null,null);
        Goods goods2 = new Goods(R.drawable.img4,null,null);
        Goods goods3 = new Goods(R.drawable.img4,null,null);
        Goods goods4 = new Goods(R.drawable.img4,null,null);
        Goods goods5 = new Goods(R.drawable.img4,null,null);
        Goods goods6 = new Goods(R.drawable.img4,null,null);
        list_goods = new ArrayList<>();
        list_goods.add(goods);
        list_goods.add(goods1);
        list_goods.add(goods2);
        list_goods.add(goods3);
        list_goods.add(goods4);
        list_goods.add(goods5);
        list_goods.add(goods6);
        list_goods.add(goods7);

        listView.addHeaderView(view1);
        listView.setAdapter(new OneListViewAdapter(getContext(), list_goods));
        rollPagerView = (RollPagerView) view1.findViewById(R.id.roll_fragment);
        rollPagerView.setPlayDelay(3000);
        rollPagerView.setAnimationDurtion(500);
        rollPagerView.setAdapter(new TestLoopAdapter(rollPagerView));
        rollPagerView.setHintView(new ColorPointHintView(getContext(), Color.RED, Color.WHITE));
        return view;
    }
    class TestLoopAdapter extends LoopPagerAdapter {

        private int[] imgs = {R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,};

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            return view;
        }


        @Override
        protected int getRealCount() {
            return imgs.length;
        }
    }






}
