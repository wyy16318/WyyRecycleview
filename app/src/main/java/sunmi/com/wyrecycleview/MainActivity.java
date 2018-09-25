package sunmi.com.wyrecycleview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mylhyl.prlayout.SwipeRefreshRecyclerView;
import com.mylhyl.prlayout.internal.OnListLoadListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,OnListLoadListener {

    private SwipeRefreshRecyclerView swipeRefresh;
    private RecyclerViewAdapter adapter;
    private List<String> objects = new ArrayList<>();
    private int index;
    private int footerIndex = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        swipeRefresh = (SwipeRefreshRecyclerView) findViewById(R.id.swipeRefresh);

        swipeRefresh.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        swipeRefresh.setOnListLoadListener(this);
        swipeRefresh.setOnRefreshListener(this);

        for (int i = 0; i < footerIndex; i++) {
            objects.add("数据 = " + i);
        }
        adapter = new RecyclerViewAdapter();
        swipeRefresh.setAdapter(adapter);
        swipeRefresh.setEmptyText("数据又没有了!");


    }

    @Override
    public void onRefresh() {
        swipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                objects.add(0, "下拉 = " + (--index));
                adapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        },1000);
    }

    @Override
    public void onListLoad() {

        swipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {


                int count = footerIndex + 5;
                for (int i = footerIndex; i < count; i++) {
                    objects.add("上拉 = " + i);
                }
                footerIndex = count;
                Log.i("wyy", "run: --上拉后的数据--"+count);
                adapter.notifyDataSetChanged();
                swipeRefresh.setLoading(false);

            }
        },1000);


    }




    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public int getItemCount() {
            return objects.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(android.R.layout.simple_list_item_1, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder) holder).tv.setText(objects.get(position));
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(android.R.id.text1);
            }
        }

    }

}
