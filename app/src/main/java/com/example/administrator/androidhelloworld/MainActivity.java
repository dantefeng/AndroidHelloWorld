package com.example.administrator.androidhelloworld;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1OnClick(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("这是一个DiaLog");
        //设置标题
        builder.setMessage("你确定你知道了吗");
        //设置内容
        builder.setIcon(R.mipmap.ic_launcher);
        //设置头像Icon
        builder.show();
        /**解释说明：
         AlertDialog是通说Builder构建者模式来创建的，其中使用builder来创建Dialog,
         通过show()方法展示*/

    }

    public void button2OnClick(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("这是一个DiaLog");
        //设置标题
        builder.setMessage("你确定你知道了吗");
        //设置内容
        builder.setIcon(R.mipmap.ic_launcher);
        //设置头像Icon

        //添加一个确定按钮，打印log发现是 i=-1
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main","用户点击了确定按钮");
                Log.d("Main","用户点击了确定按钮"+i);
            }
        });
        //添加一个取消按钮，打印log 发现是 i=-2
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main","用户点击了取消按钮");
                Log.d("Main","用户点击了取消按钮"+i);
            }
        });
        //添加一个中立按钮，打印log,发现是 i=-3
        builder.setNeutralButton("中立", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main","用户点击了中立");
                Log.d("Main","用户点击了中立"+i);
            }
        });
        //这个方法是监听当用户点击了dialog窗体之外的方法，
        // dialog.setCancelable(false);如果存在这句话的话，那么这个监听就无效了，
        //哪怕用户按回退键
        //注意的是，这个监听所指窗体之外也包括了用户按回退键这个动作
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("Main","用户点击了视图外面");
            }
        });

        /**你会发现你可以使用好多setNegativeButton,方法来设置按钮，但是最终有效果
         最后添加或执行的。这样你就可以根据不同的情况来展示不同的AlertDialog界面了
         另外你点了哪一个按钮，那么AlertDialog窗体就会消失*/

        builder.show();
        /**解释说明：
         AlertDialog是通说Builder构建者模式来创建的，其中使用builder来创建Dialog,
         通过show()方法展示*/

    }

    public void button3OnClick(View view){
        final String items[] = {"我是Item一", "我是Item二", "我是Item三", "我是Item四"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//设置标题的图片
                .setTitle("列表对话框")//设置对话框的标题
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }

    public void button4OnClick(View view){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        //这是创建方式之一，还有一种，是需要两个参数，参数二是主题，int theme;
        progressDialog.setTitle("这是一个ProgressDialog");
        //设置题目
        progressDialog.setMessage("这里面是内容区域");
        //设置内容区域
        progressDialog.setIcon(R.mipmap.ic_launcher);
        //设置Icon
        progressDialog.show();

    }

    public void button5OnClick(View view){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        //这是创建方式之一，还有一种，是需要两个参数，参数二是主题，int theme;
        progressDialog.setTitle("这是一个ProgressDialog");
        //设置题目
        progressDialog.setMessage("这里面是内容区域");
        //设置内容区域
        progressDialog.setIcon(R.mipmap.ic_launcher);
        //设置Icon

        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-2
            }
        });

        progressDialog.setButton(ProgressDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-1
            }
        });

        progressDialog.setButton(ProgressDialog.BUTTON_NEUTRAL, "其他", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-3
            }
        });
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("Main","点击了空白区域");
            }
        });
        //上述四个动作一点,progressDialog也是消失
        //除非设置progressDialog.setCancelable(false);当然设置这个属性，表示的是
        //针对于点击空白处和回退键处无效了，那么点击三个按钮还是一样会隐藏dialog窗体

        progressDialog.show();

    }

    public void button6OnClick(View view){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        //这是创建方式之一，还有一种，是需要两个参数，参数二是主题，int theme;
        progressDialog.setTitle("这是一个ProgressDialog");
        //设置题目
        progressDialog.setMessage("这里面是内容区域");
        //设置内容区域
        progressDialog.setIcon(R.mipmap.ic_launcher);
        //设置Icon

        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-2
            }
        });

        progressDialog.setButton(ProgressDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-1
            }
        });

        progressDialog.setButton(ProgressDialog.BUTTON_NEUTRAL, "其他", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main",""+i);//-3
            }
        });
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("Main","点击了空白区域");
            }
        });
        //上述四个动作一点,progressDialog也是消失
        //除非设置progressDialog.setCancelable(false);当然设置这个属性，表示的是
        //针对于点击空白处和回退键处无效了，那么点击三个按钮还是一样会隐藏dialog窗体

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //会展示一个条形状
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //就是默认的，不断转圈的样式()就是图一的样式

        progressDialog.setIndeterminate(true);
        //true  进度条采用不明确显示进度的‘模糊模式’
        //false 进度条不采用‘模糊模式’，而采用明确显示进度的‘明确模式’，这样就可以保证可以修改进度了

        progressDialog.show();

        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(10);
        //明确模式下可改变进度条的样式

    }

}
