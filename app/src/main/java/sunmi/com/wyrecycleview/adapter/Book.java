package sunmi.com.wyrecycleview.adapter;

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
 * Time: 17:19
 * 王洋洋
 */

public    class Book {

      private  String  number;
      private   int   img;


    public Book(String number, int img) {
        this.number = number;
        this.img = img;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Book{" +
                "number='" + number + '\'' +
                ", img=" + img +
                '}';
    }
}
