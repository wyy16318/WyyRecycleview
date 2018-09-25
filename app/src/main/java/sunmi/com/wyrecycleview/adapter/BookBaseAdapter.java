package sunmi.com.wyrecycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sunmi.com.wyrecycleview.R;

/**
 * 　　  　　　　 ┏┓       ┏┓
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　 █████━█████  ┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * 　　　　　　　　　　┃　　　┃  神兽保佑,代码无bug
 * <p>
 * Created by Administrator on 2018/7/24.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/7/24
 * Time: 17:16
 * 王洋洋
 */

public class BookBaseAdapter    extends RecyclerView.Adapter<BookBaseAdapter.ViewHolder> {

    private List<Book> mBookList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
        ViewHolder  viewHolder=new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.bookname.setText(book.getNumber());
        holder.bookImage.setImageResource(book.getImg());
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bookImage;
        TextView bookname;

        public ViewHolder(View view) {
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.book_iamge);
            bookname = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public BookBaseAdapter(List<Book> mBookList) {
        this.mBookList = mBookList;
    }

}
