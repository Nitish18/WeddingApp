package contacts;

import android.content.Context;
import android.content.Intent;

import com.eventassociate.weddingapp.R;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class CustomAdapter extends BaseAdapter{   
    String [] result;
    String [] result2;
    Context context;
 String[] imageId;
      private static LayoutInflater inflater=null;
    public CustomAdapter(Contact mainActivity, String[] prgmNameList, String[] prgmImages , String[] prgmNameList2 ) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        result2=prgmNameList2;
        context=mainActivity;
        imageId=prgmImages;
         inflater = ( LayoutInflater )context.
                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView img;
        TextView tv2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;       
             rowView = inflater.inflate(R.layout.program_list, null);
             holder.tv=(TextView) rowView.findViewById(R.id.textView1);
             holder.tv2=(TextView) rowView.findViewById(R.id.textView3);
             holder.img=(TextView) rowView.findViewById(R.id.textView2);       
         holder.tv.setText(result[position]);
         holder.img.setText(imageId[position]);
         holder.tv2.setText(result2[position]);
         
         rowView.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
            	
            	
            	
            	
            	 imageId[position].replaceAll("-", "");
 	            Intent callIntent = new Intent(Intent.ACTION_CALL);
 	            callIntent.setData(Uri.parse("tel:"+imageId[position]));
 	            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
 	           context.startActivity(callIntent);
            	
            	
            	
            	
            	
         	
            	
            	
                           }
        });   
        return rowView;
    }

}