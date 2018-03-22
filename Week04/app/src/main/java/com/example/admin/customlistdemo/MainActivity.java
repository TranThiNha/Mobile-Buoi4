package com.example.admin.customlistdemo;

import android.app.Activity;
import android.content.Context;
import android.printservice.CustomPrinterIconCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txtSelection;
    ListView lvList;

    String[] items = { "Image-1", "Image-2", "Image-3", "Image-4", "Image-5",
            "Image-6", "Image-7", "Image-8", "Image-9", "Image-10", "Image-11",
            "Image-12", "Image-13", "Image-14", "Image-15" };
    Integer[] thumbnails = { R.drawable.hinh1, R.drawable.hinh2,
            R.drawable.hinh3, R.drawable.hinh4,
            R.drawable.hinh5, R.drawable.hinh6,
            R.drawable.hinh7, R.drawable.hinh8,
            R.drawable.hinh9, R.drawable.hinh10,
            R.drawable.hinh11, R.drawable.hinh12,
            R.drawable.hinh13, R.drawable.hinh14,
            R.drawable.hinh15 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSelection = (TextView) findViewById(R.id.txtSelection);
        lvList= (ListView) findViewById(R.id.lvList);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int temp=i+1;
                String text = "Your selection is Image-"+ temp;
                txtSelection.setText(text);
            }
        });

        CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(
                this,
                R.layout.custom_row_icon_label,
                items,
                thumbnails);
// bind intrinsic ListView to custom adapter
        lvList.setAdapter(adapter);
    }//onCreate
    // react to user's selection of a row


    class CustomIconLabelAdapter extends ArrayAdapter<String> {
        Context context;
        Integer[] thumbnails;
        String[] items;

        public CustomIconLabelAdapter(Context context, int layoutToBeInflated,
                                      String[] items, Integer[] thumbnails) {
            super(context, R.layout.custom_row_icon_label, items);
            this.context = context;
            this.thumbnails = thumbnails;
            this.items = items;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            View row = inflater.inflate(R.layout.custom_row_icon_label, null);
            TextView label = (TextView) row.findViewById(R.id.txtItem);
            ImageView icon1 = (ImageView) row.findViewById(R.id.img1);
            ImageView icon2 = (ImageView) row.findViewById(R.id.img2);
            label.setText(items[position]);
            icon1.setImageResource(thumbnails[position]);
            icon2.setImageResource(thumbnails[position]);
            return (row);
        }
    }
}

